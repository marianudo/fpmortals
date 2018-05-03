package algebra

import scala.language.higherKinds
import java.time.Instant

import scalaz._
import Scalaz._

final case class MachineNode(id: String)

trait Machines[F[_]] {
  def getTime: F[Instant]
  def getManaged: F[NonEmptyList[MachineNode]]
  def getAlive: F[Map[MachineNode, Instant]]
  def start(node: MachineNode): F[MachineNode]
  def stop(node: MachineNode): F[MachineNode]
}

object Machines {
  implicit object IdMachines extends Machines[Id] {
    override def getTime: Scalaz.Id[Instant] = ???

    override def getManaged: Scalaz.Id[NonEmptyList[MachineNode]] = ???

    override def getAlive: Scalaz.Id[Map[MachineNode, Instant]] = ???

    override def start(node: MachineNode): Scalaz.Id[MachineNode] = ???

    override def stop(node: MachineNode): Scalaz.Id[MachineNode] = ???
  }

  def testApply[F[_]: Machines: Apply]() = {
    val m = implicitly[Machines[F]]

    val x: F[Unit] = ^^^(m.getTime, m.getManaged, m.getAlive, m.getTime) {
      case (t, m, a, t2) => println("Nah")
    }
  }
}