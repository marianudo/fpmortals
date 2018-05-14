package algebra

import simulacrum._
import scalaz.{Scalaz, _}
import Scalaz._

import scala.language.higherKinds

@typeclass trait ConsoleIo[F[_]] {
  def read(): F[String]
  def write(str: String): F[Unit]
}

object ConsoleIo {
  implicit val syncIo: ConsoleIo[Id] = new ConsoleIo[Scalaz.Id] {
    override def read() = scala.io.StdIn.readLine()

    override def write(str: String) = println(str)
  }

  def echo[F[_]: ConsoleIo: Functor](): F[String] = {
    val op = implicitly[ConsoleIo[F]]

    for {
      str <- op.read()
    } yield str
  }

//  def play() = {
//    ops.toAllConsoleIoOps()
//  }
}

//object Playground {
//  def play() = {
//    import ConsoleIo._
//
//    val io = ConsoleIo[Id]
//
//    for {
//      msg <- io.read()
//      _ <- io.write(msg)
//    } yield ()
//  }
//}
