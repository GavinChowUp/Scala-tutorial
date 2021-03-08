package cats.kleisli

import cats.FlatMap
import cats.implicits._

object KleisliMain {
  def main(args: Array[String]): Unit = {

    val twice: Int => Int        = x => x * 2
    val countCats: Int => String = x => if (x == 1) "1 cat" else s"$x cats"

//    use andThen
    val twiceAsManyCats: Int => String = twice andThen countCats
    println(twiceAsManyCats(1))

//    use compose
    val alternativeTwiceAsManyCats: Int => String = countCats compose twice
    println(alternativeTwiceAsManyCats(2))

//    -----------the case we can't use andThen and compose

    val parse: String => Option[Int]      = s => if (s.matches("-?[0-9]+")) Some(s.toInt) else None
    val reciprocal: Int => Option[Double] = s => if (s != 0) Some(1 / s) else None

//    compile error
//    val andThen = parse andThen reciprocal

  }
}

final case class Kleisli[F[_], A, B](run: A => F[B]) {
  def compose[Z](k: Kleisli[F, Z, A])(implicit F: FlatMap[F]): Kleisli[F, Z, B] =
    Kleisli[F, Z, B](z => k.run(z).flatMap(run))
}
