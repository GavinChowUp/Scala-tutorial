package essential.option

object OptionObject {

  def initList = List(Option(1), Option(2), None)

  def scalaOptionExists = {
    val value = initList.foreach(x => x.get)
    println(value)
  }

  def main(args: Array[String]): Unit =
    scalaOptionExists

}