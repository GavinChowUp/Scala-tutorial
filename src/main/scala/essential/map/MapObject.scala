package essential.map

object MapObject {

  def initList = 1 to 5

  def scalaMap =
    println(initList.map(x => x * 2))

  def main(args: Array[String]): Unit = {
    //F[A],A=>B :F[B]
    scalaMap
  }
}
