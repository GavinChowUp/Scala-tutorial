package scalacats.introduction.typeclass

object InterfaceSyntax {

  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit writer: JsonWriter[A]) = writer.write(value)
  }
}
