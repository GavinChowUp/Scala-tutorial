package essential.flatmap

case class ProductMapping(response: Map[String, String])
case class ProductId(value: Int)

object FlatMapObject {

  def initList = 1 to 5

  def testKey = {
    val map = Map(ProductId(1) -> "2")
    val maybeString = map.getOrElse(ProductId(1), "")
    println(maybeString)
  }

  def scalaFlatMap =
    println(initList.flatMap(x => Set(s"${x.toString} from set")))

  def listToMap = {
    val value = List(ProductMapping(Map("1" -> "11")), ProductMapping(Map("2" -> "22")), ProductMapping(Map("3" -> "33")))
    val map   = value.flatMap(productMapping => productMapping.response).toMap
    val value1 = map.toList.flatMap { t =>
      List(t._2)
    }.toList
    println("-------------------------------")
    println(value1)
    println("-------------------------------")
    println(map)
  }

  def main(args: Array[String]): Unit = {
    //F[A],A=>M[B] :F[B]
    scalaFlatMap

    listToMap

    testKey
  }

}
