package scalacats.functors
import cats.Functor

object CatsFunctorObject {

  def functorInstanceObject = {

    val listFunctor   = Functor[List]
    val optionFunctor = Functor[Option]
    //instance object
    listFunctor.map(List(1, 2, 3))(_ + 1)
    optionFunctor.map(Option(1))(_ + 2)

    val f: Int => Int                 = x => x + 2
    val fList: List[Int] => List[Int] = listFunctor.lift(f)

    fList(List(1, 3, 4))
  }

  def functorFunction1 = {

    import cats.instances.function._
    import cats.syntax.functor._

    val f1: Int => Int    = x => x + 1
    val f2: Int => String = x => x + "!"

    val f: Int => String = f1.map(f2)

    f(100)
  }

  def doMath[F[_]](x: F[Int])(implicit functor: Functor[F]): F[Int] = {

    import cats.Functor
    import cats.syntax.functor._

    x.map(x => x * 2)

  }

  def main(args: Array[String]): Unit = {

    //以下操作，其实和List以及原生的Option的map的操作是一致的
    println(functorInstanceObject)

    //以下操作，Function1 也没有map函数，但是可以用来掩饰Functor 这个type class
    println(functorFunction1)

    //以下操作，无论什么样的Functor context 都能实现
    println(doMath(List(1, 2, 3)))
    println(doMath(Option(1)))
  }
}
