package essential.lazycompute

object LazyCompute {

  def firstLazy: Int = {
    println("I am from firstLazy")
    1
  }

  def secondLazy: Int = {
    println("I am from secondLazy")
    2
  }

  def chooseOne(
    first: Boolean,
    a: Int,
    b: Int): Unit =
    if (first) a else b

  def chooseOneLazy(
    first: Boolean,
    a: => Int,
    b: => Int): Int =
    if (first) a else b

  def main(args: Array[String]): Unit = {
    chooseOne(first = true, firstLazy, secondLazy)
    println("-------------------------------------------------")
    chooseOneLazy(first = true, firstLazy, secondLazy)
    println("-------------------------------------------------")
  }

}
