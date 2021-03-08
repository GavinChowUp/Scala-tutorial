package scalacats.introduction.eq

import cats.instances.int._
import cats.syntax.eq._

object EqObject {

  def unsafeEqual = List(1, 2, 3).map(Option(_)).filter(item => item == 1)

  def main(args: Array[String]): Unit = {

    //1.Comparing int
    //原因是Option[Int]与Int做比较，所以List为空
    println(unsafeEqual)
    println("----------------------------------------------")

    println(1 === 1)
    println(1 =!= 2)

    //2.Comparing Options
    Option(1) === None
  }
}
