package cats.traverse

import cats.implicits._

object TraverseObject {

  def initList = List(Option(1), Option(2), Option(3), Option(4))

  def catsTraverse = {
    val option = List(Option(1), Option(2), Option(3)).traverse_(identity)
    println(option)
    println(initList)
  }

  def main(args: Array[String]): Unit = {
    catsTraverse
  }
}
