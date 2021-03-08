package scalacats.introduction.typeclass

import scalacats.introduction.typeclass.JsonWriterInstance._

object InterfaceObject {
  def toJson[A](value: A)(implicit writer: JsonWriter[A]): Json = writer.write(value)

  def main(args: Array[String]): Unit =
    InterfaceObject.toJson("String")
}
