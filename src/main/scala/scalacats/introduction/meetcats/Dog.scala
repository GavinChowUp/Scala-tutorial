package scalacats.introduction.meetcats

import cats.syntax.show._

import cats.Show
import cats.instances.string._
import cats.instances.int._

case class Dog(name: String, age: Int)

object Dog {
  implicit val dogShow: Show[Dog] = dog => {
    s"${dog.age.show},${dog.name.show}"
  }
}
