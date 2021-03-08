package scalacats.functors

object DefAndValueObject {

  def defF: Int = {
    println("I am from def 1")
    1
  }

  def defG: Int = {
    println("I am from def 2")
    2
  }

  val valF: Int = {
    println("I am from val 11")
    11
  }

  val valG: Int = {
    println("I am from val 22")
    22
  }

  def testDefValue(defF: Int, defG: Int) =
    if (true) defF else defG

  def testDefFunction(defF: => Int, defG: => Int) =
    if (true) defF else defG

  def testValValue(valF: Int, valG: Int) =
    if (true) valF else valG

  def testValFunction(valF: => Int, valG: => Int) =
    if (true) valF else valG

  def main(args: Array[String]): Unit = {
    testDefValue(defF, defG)
    println("-----------------------------------")
    testDefFunction(defF, defG)
    println("-----------------------------------")
    testValValue(valF, valG)
    println("-----------------------------------")
    testValFunction(valF, valG)
    println("-----------------------------------")
  }
}
