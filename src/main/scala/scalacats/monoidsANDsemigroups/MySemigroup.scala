package scalacats.monoidsANDsemigroups

import cats.Monoid

trait MySemigroup[A] {
  def combine(x: A, y: A): A

  Monoid
}
