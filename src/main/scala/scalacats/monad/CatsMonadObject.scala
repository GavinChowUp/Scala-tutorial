package scalacats.monad

import cats.Monad
import cats.instances.list._
import cats.instances.option._


object CatsMonadObject {

  def simpleMonad = {
    val xs          = List(1, 2, 3)
    val listMonad   = Monad[List]
    val optionMonad = Monad[Option]

    listMonad.flatMap(xs)(x => listMonad.pure(x * 2))
    optionMonad.flatMap(Option(1))(x => optionMonad.pure(x * 10))
  }

  def sumSquare1[F[_]: Monad](x: F[Int], y: F[Int]): F[Int] = {
    import cats.syntax.flatMap._
    import cats.syntax.functor._

    import scala.language.higherKinds

    x.flatMap(a => y.map(b => a * a + b * b))
  }

  def sumSquare2[F[_]: Monad](x: F[Int], y: F[Int]): F[Int] =
    for {
      a ← x
      b ← y
    } yield a * a + b * b

  def main(args: Array[String]): Unit = {
    println(simpleMonad)
    println("----------------------------------")
    println(sumSquare1(Option(5), Option(6)))
  }

}
