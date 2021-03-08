package cats.reader

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits._

object ReaderObject {

  def getData: String => List[Int] = transaction => {
    println(s"$transaction - fetching data")
    List(1, 2, 3)
  }
  def encode(data: List[Int]): String => List[Int] = transaction => {
    println(s"$transaction - data before encode ${data}")
    val result = data.map(_ + 1)
    println(s"$transaction - data after encode ${result}")
    result
  }

  def save(data: List[Int]): String => Unit = transaction => {
    println(s"$transaction - saving data ${data}")
  }

  def job(): String => Unit = transaction => {
    val getDataFunc: String => List[Int]     = getData
    val encodedDataFunc: String => List[Int] = trans => encode(getDataFunc(trans))(trans)
    val saveDataFunc: String => Unit         = trans => save(encodedDataFunc(trans))(trans)
    saveDataFunc(transaction)
  }

  def main() = {
    Future(job()("trans1"))
    Future(job()("trans2"))

    //trans1 - fetching data
    //trans2 - fetching data
    //trans2 - data before encode List(1, 2, 3)
    //trans1 - data before encode List(1, 2, 3)
    //trans1 - data after encode List(2, 3, 4)
    //trans2 - data after encode List(2, 3, 4)
    //trans1 - saving data List(2, 3, 4)
    //trans2 - saving data List(2, 3, 4)
  }
}
