package MonoidsSemigroup

import cats.{Monoid, Semigroup}

object ExerciseSet extends App {

  implicit def setUnionMonoid[A](): Monoid[Set[A]] = {
    new Monoid[Set[A]] {
       def combine(x: Set[A], y: Set[A]): Set[A] = x | y
       def empty: Set[A] = Set.empty[A]
    }
  }

  implicit def setIntersectionSemigroup[A](): Semigroup[Set[A]] = {
    new Semigroup[Set[A]] {
       def combine(x: Set[A], y: Set[A]): Set[A] = x & y
    }
  }

  implicit def symDiffMonoid[A]: Monoid[Set[A]] = {
    new Monoid[Set[A]] {
       def combine(x: Set[A], y: Set[A]): Set[A] = (x diff y) | (y diff x)
       def empty: Set[A] = Set.empty
    }
  }

  val intSetMonoids = ExerciseSet.setUnionMonoid[Int]
  val intSetMonoids2 = ExerciseSet.setIntersectionSemigroup[Int]
  val intSetMonoids3 = ExerciseSet.symDiffMonoid[Int]

  val mySet: Set[Int] = Set(1,3,4)
  val mySet2: Set[Int] = Set(3,4,5)

  println(intSetMonoids.combine(mySet, mySet2))
  println(intSetMonoids2.combine(mySet, mySet2))
  println(intSetMonoids3.combine(mySet, mySet2))

}
