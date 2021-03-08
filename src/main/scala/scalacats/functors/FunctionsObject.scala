package scalacats.functors

import cats.instances.function._
import cats.syntax.functor._

object FunctionsObject {

  val f1: Int => Int    = x => x * 6
  val f2: Int => String = x => x + "!"

  def mapCombine =
    (f1 map f2)(2)

  def functionCombine = (f1 andThen f2)(3)

  def main(args: Array[String]): Unit = {
    println(mapCombine)
    println("--------------------------------------")
    println(functionCombine)
  }
}
