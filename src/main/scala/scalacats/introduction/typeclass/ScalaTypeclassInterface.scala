package scalacats.introduction.typeclass

import JsonWriterInstance._

object ScalaTypeclassInterface {

  implicitly[JsonWriter[Int]]

  def main(args: Array[String]): Unit =
    println(InterfaceObject.toJson(2))

}
