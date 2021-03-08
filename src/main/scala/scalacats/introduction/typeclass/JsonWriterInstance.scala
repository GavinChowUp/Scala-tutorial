package scalacats.introduction.typeclass


object JsonWriterInstance {

  implicit val stringWriter = new JsonWriter[String] {
    override def write(value: String): Json = JsonString(value)
  }

  implicit val numWriter = new JsonWriter[Int] {
    override def write(value: Int): Json = JsonNumber(value)
  }

}
