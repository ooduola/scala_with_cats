package Monads

import scala.util.Try

object IntroToMonads extends  App {

  def parseInt(str: String): Option[Int] =
    Try(str.toInt).toOption

  def divide(a: Int, b: Int): Option[Int] =
    if (b == 0) None else Some(a / b)

  def stringDivideBy(x: String, y: String): Option[Int] = {
    parseInt(x).flatMap { int1 =>
      parseInt(y).flatMap { int2 =>
        divide(int1, int2)
      }
    }
  }
  val test: List[(Int,Int)] = for
  {
    x <- (1 to 3).toList
    y <- (4 to 5).toList
  } yield  (x, y)

  println(test)

  println((1 to 3).toList)
  println(stringDivideBy("10", "5d"))

  //exercise 1
  // define map in the same way for every monad using the existing methods, flatmap and pure

  trait Monad[F[_]] {
    def pure[A](value: A): F[A]
    def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]

    def map[A, B](value: F[A])(func: A => B): F[B] =
      flatMap(value)(a => ???)
  }
}
