import cats.Show
import cats.Eq
import cats.instances.int._
import cats.instances.option._
import cats.syntax.show._
import cats.syntax.eq._

object ScalaPlayground extends App {

  final case class Person(name: String, age: Int)
  final case class Cat(name: String, age: Int, description: String)

  val showInt = Show.apply[Int]
  val showString = Show.apply[String]

  implicit val personShow: Show[Person] =
    Show.show(Person => s"${Person.name} is the Founder of Pan African tech company. Business is ${Person.age} old.")

//  println(showInt.show(123))
//  println( showString.show("Oduduwa"))
//  print(123.show)

  val eqInt = Eq[String]
  val eqOpInt = Eq[Option[Int]]

//  println(eqInt.eqv("1","11"))
//  println(1 === 1)

  implicit val personEq: Eq[Person] =
    Eq.instance[Person] { (person1, person2) =>
      person1.name === person2.name &&
      person1.age === person2.age
    }

  implicit val catEq: Eq[Cat] =
    Eq.instance[Cat] { (cat1, cat2) =>
      cat1.name === cat2.name &&
      cat1.age === cat2.age &&
      cat1.description === cat2.description
    }

  val cat1 = Cat("Garfield", 38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")
  val optionCat1 = Option(cat1)
  val optionCat2 = Option.empty[Cat]

  println(cat1 === cat2)
//  println(cat1 =!= cat2)
//  println(optionCat1 =!= optionCat2)
//  println(optionCat1 === None)
  val a = 10
  val b = 10

//  println(Person("tunji", 10) === Person("tunjki", 11))
//  println(Person("Tunji", 10).show)
}
