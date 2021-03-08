package scalacats.monad

import scala.util.Try

object MonadObject {

  def parseInt(v: String): Option[Int] =
    Try(v.toInt).toOption

  def divide(x: Int, y: Int): Option[Int] =
    if (y == 0) None
    else Some(x / y)

  //[Version:1]实现将parseInt 和divid 的 combine
  def stringDivide1(a: String, b: String): Option[Int] = {
    val maybeIntA = parseInt(a)
    val maybeIntB = parseInt(b)

    if (maybeIntA.isEmpty || maybeIntB.isEmpty) None
    else divide(maybeIntA.get, maybeIntB.get)
  }

  //[Version:2]使用flatmap，直接避免Option可能没有返回值的复杂性
  def stringDivide2(a: String, b: String): Option[Int] =
    parseInt(a).flatMap(x => parseInt(b).flatMap(y => divide(x, y)))

  //若计算产生monad content,则用map
  //若计算产生monad 则用 flatMap
  //若同时具备map和flatMap，则可用for
  def stringDivide3(a: String, b: String): Option[Int] =
    for {
      x <- parseInt(a)
      y <- parseInt(b)
      z <- divide(x, y)
    } yield z

}
