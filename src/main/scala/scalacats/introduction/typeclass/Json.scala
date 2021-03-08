package scalacats.introduction.typeclass

//定义数据结构
sealed trait Json

final case class JsonObject(get: Map[String, Json]) extends Json
final case class JsonString(get: String)            extends Json
final case class JsonNumber(get: Int)               extends Json

