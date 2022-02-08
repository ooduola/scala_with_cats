
object Playground extends App {

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    def loop(n: Int): Boolean = {
      if (n >= as.length - 1) true
      else if (!ordered(as(n), as(n + 1))) false
      else loop(n + 1)
    }
    loop(0)
  }

  def compose[A,B,C](f: B => C, g: A => B): A => C =
    a => f(g(a))
  def f(n: Int) = n * 2
  def g(n: Int ) = n / 2

  println(compose(f, g)(8))
  println(isSorted(Array(0,1,3), (a: Int, b: Int) => a < b))
}
