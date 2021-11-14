package Functors

import cats.Functor
import cats.instances.list._
import cats.instances.option._
import cats.instances.function._
import cats.syntax.functor._

object FunctorWithCats extends App {

  //  trait Functor[F[_]] { self =>
  //    def map[A, B](fa: F[A])(f: A => B): F[B]

  val list1 = List(1, 2, 3)
  val option1 = Option(123)

  val list2 = Functor[List].map(list1)(_ * 2)
  val option2 = Functor[Option].map(option1)(_.toString)

  println(list2)
  println(option2)

  // lift method
  val func = (x: Int) => x + 1
  val liftedFunc = Functor[Option].lift(func)
  println(liftedFunc(Option(20)))

  val func1 = (a: Int) => a + 1
  val func2 = (a: Int) => a + 2
  val func3 = (a: Int) => a + 3
  val func4 = func1 map func2 map func3

  println(func4(3))

  // abstraction over functors
  def doMath[F[_]](start: F[Int])(implicit functor: Functor[F]): F[Int] =
    start.map(_ + 1 * 2)

  println(doMath(Option(12)))

}
