package scalacats.monoidsANDsemigroups

trait MyMonoid[A] extends MySemigroup[A] {
  val identityElement: A
}

object MyMonoid {

  def apply[A](implicit m: MyMonoid[A]): MyMonoid[A] = m

  implicit val andMonoid: MyMonoid[Boolean] = new MyMonoid[Boolean] {
    override val identityElement: Boolean = true
    override def combine(x: Boolean, y: Boolean): Boolean = x && y
  }
}
