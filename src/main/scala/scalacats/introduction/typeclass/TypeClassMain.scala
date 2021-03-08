package scalacats.introduction.typeclass

import scalacats.introduction.typeclass.JsonWriterInstance._
import scalacats.introduction.typeclass.InterfaceSyntax.JsonWriterOps

object TypeClassMain {

  def main(args: Array[String]): Unit = {
    InterfaceObject.toJson("String Json")
    1.toJson
  }
}
