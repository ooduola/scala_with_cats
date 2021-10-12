package MonoidsSemigroup

import cats.{Monoid, Semigroup}
import cats.syntax.semigroup._

import java.time.MonthDay

object SuperAdder extends App {
//  The cutting edge SuperAdder v3.5a‐32 is the world’s first choice for adding
//  together numbers. The main function in the program has signature def
//  add(items: List[Int]): Int. In a tragic accident this code is deleted!
//  Rewrite the method and save the day!

  def addOld(items: List[Int]): Int =
    items.sum

//  People now want to add
//  List[Option[Int]]. Change add so this is possible. The SuperAdder code
//  base is of the highest quality, so make sure there is no code duplication!

  def add[A](items: List[A])(implicit monoid: Monoid[A]): A =
    items.foldLeft(monoid.empty)(monoid.combine) // can also use: _ |+| _

  println(add(List(1, 2, 3)))
  println(add(List(Option(1), Option(2), Option(3))))

//  SuperAdder is entering the POS (point‐of‐sale, not the other POS) market.
//  Now we want to add up Orders:
//  case class Order(totalCost: Double, quantity: Double)
//  We need to release this code really soon so we can’t make any modifications to add.
//  Make it so!

  case class Order(totalCost: Double, quantity: Double)

  implicit val OrderMonoid: Monoid[Order] =
    new Monoid[Order] {
      override def combine(x: Order, y: Order): Order =
        Order(x.totalCost + y.totalCost, x.quantity + y.quantity)

      override def empty: Order = Order(0, 0)
    }

  println(add(List(Order(10.0, 10.0), Order(5.0, 5.0))))
}
