package algebra

import simulacrum.{op, typeclass}

@typeclass trait Semigroup[A] {
  @op("|+|") def append(x: A, y: => A): A
}

object Semigroup {
  implicit val sumIntSemigroup: Semigroup[Int] = new Semigroup[Int] {
    override def append(x: Int, y: => Int) = x + y
  }

  implicit val appendStringSemigroup: Semigroup[String] = new Semigroup[String] {
    override def append(x: String, y: => String) = x + y
  }
}
