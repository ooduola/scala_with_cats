package MonoidsSemigroup


object SemigroupsRJVM extends App {

  import cats.Semigroup
  import cats.instances.int._
  import cats.instances.string._
  import cats.syntax.semigroup._

  val intSemigroup: Semigroup[Int] = Semigroup[Int]
  val stringSemigroup: Semigroup[String] = Semigroup[String]

  //specific API
  def reduceIntList(list: List[Int]) = list.reduce(intSemigroup.combine)
  def reduceStringList(list: List[String]) = list.reduce(stringSemigroup.combine)

  //general API
  def reduceThings[T](list: List[T])(implicit semigroup: Semigroup[T]) = list.reduce(semigroup.combine)

  def reduceThings2[T : Semigroup](list: List[T]) = list.reduce(_ |+| _)

  // TODO 1: Support new data type
  case class Expense(id: Long, amount: Double)

//  implicit def expenseSemigroupOne: Semigroup[Expense] = {
//    new Semigroup[Expense] {
//      override def combine(x: Expense, y: Expense): Expense = Expense(Math.max(x.id, y.id), y.amount + x.amount)
//    }
//  }

  implicit val expenseSemigroupTwo: Semigroup[Expense] = Semigroup.instance {
    (e1, e2) => Expense(Math.max(e1.id, e2.id), e1.amount + e2.amount)
  }

  val testExpenses = List(Expense(1,44), Expense(2,55))
  println(reduceThings(testExpenses))

}
