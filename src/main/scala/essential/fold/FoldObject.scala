package essential.fold

object FoldObject {

  def initList = 1 to 2

  def scalaFold = {
    val i = initList.fold(2)((x, y) => x * y)
    println(i)
  }

  //从左端向右端累加
  def scalaFoldLeft = {
    val i = initList.foldLeft(0)((sum, i) => sum - i)
    println(i)
  }

  //从右端向左端累加
  def scalaFoldRight = {

    //10
    //2-10
    //1-(2-10)
    //10-(2-10)-(1-(2-10))
    // ❌ this is a wrong case, sum need be right side
    val i = initList.foldRight(10)((sum, i) => sum - i)
    println(i)
    println(10 - (2 - 10) - (1 - (2 - 10)))

    println("*************************************")

    // ✅ 10-2-1
    val y = initList.foldRight(10)((i, sum) => sum - i)
    println(y)
  }

  def main(args: Array[String]): Unit = {
    scalaFold
    println("-------------------------------------")
    scalaFoldLeft
    println("-------------------------------------")
    scalaFoldRight
  }

}
