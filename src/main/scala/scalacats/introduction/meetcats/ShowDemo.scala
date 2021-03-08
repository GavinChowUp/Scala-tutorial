package scalacats.introduction.meetcats

import cats.syntax.show._

object ShowDemo {

  def main(args: Array[String]): Unit = {
    //用法1
    Dog("WangWang", 10).show
    //用法2
    Dog.dogShow.show(Dog("HaHa", 1))
  }
}
