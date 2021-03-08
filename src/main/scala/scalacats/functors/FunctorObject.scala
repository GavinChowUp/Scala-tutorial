package scalacats.functors

object FunctorObject {

  //map仅仅转换了其内容，并没有改变context
  def mapFunctor = (1 to 5).map(n => n + 1)

  def main(args: Array[String]): Unit =
    println(mapFunctor)
}
