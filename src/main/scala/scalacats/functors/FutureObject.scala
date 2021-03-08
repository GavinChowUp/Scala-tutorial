package scalacats.functors

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

//隐式转换注解
import scala.concurrent.ExecutionContext.Implicits.global

object FutureObject {

  def futureFunction = {
    val eventualInt = Future(110).map(_ + 1).map(_ * 6)
    Await.result(eventualInt, 1.second)
  }

  def main(args: Array[String]): Unit =
    println(futureFunction)

}
