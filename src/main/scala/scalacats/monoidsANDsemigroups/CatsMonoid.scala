package scalacats.monoidsANDsemigroups

import cats.Monoid
import cats.syntax.semigroup._

object CatsMonoid {

  def setCombine = Set(1, 2, 3) |+| Set(1, 2, 4)

  def mapCombine = Map("a" → 1) |+| Map("b" → 2)

  def intCombine = 1 |+| 2

  def main(args: Array[String]): Unit = {
    println(setCombine)

    println(mapCombine)

    println(intCombine)
  }

}
