package MonoidsSemigroup

import cats.Monoid

object ExerciseBoolean extends App {

  implicit val BooleanAndMonoid: Monoid[Boolean] = {
    new Monoid[Boolean] {
      override def combine(x: Boolean, y: Boolean): Boolean = x && y
      override def empty: Boolean = true
    }
  }

  implicit val BooleanOrMonoid: Monoid[Boolean] = {
    new Monoid[Boolean] {
      override def combine(x: Boolean, y: Boolean): Boolean = x || y
      override def empty: Boolean = false
    }
  }

  // Exclusive Or
  implicit val BooleanEitherMonoid: Monoid[Boolean] = {
    new Monoid[Boolean] {
      override def combine(x: Boolean, y: Boolean): Boolean = (x && !y) || (!x && y)
      override def empty: Boolean = false
    }
  }

  // Exclusive Nor (the negation of exclusive or)
  implicit val BooleanXnorMonoid: Monoid[Boolean] = {
    new Monoid[Boolean] {
      override def combine(x: Boolean, y: Boolean): Boolean = (x || !y) && (!x || y)
      override def empty: Boolean = true
    }
  }
}
