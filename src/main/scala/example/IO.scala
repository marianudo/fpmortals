package example

class IO[A](eff: () => A) {
  def map[B](f: A => B): IO[B] = IO(f(eff()))

  def flatMap[B](f: A => IO[B]): IO[B] = f(eff())

  def run: A = eff()
}

object IO {
  def apply[A](a: => A): IO[A] = new IO(() => a)
}