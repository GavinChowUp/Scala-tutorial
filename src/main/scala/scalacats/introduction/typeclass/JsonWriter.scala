package scalacats.introduction.typeclass

trait JsonWriter[A] {
  def write(value: A): Json
}
