package game

sealed trait Person {
  def firstname: String = ""
  def lastname: String = ""
  def email: String = ""
  def partners: List[Person] = Nil
  def affinities: List[Person] = Nil
  def aversions: List[Person] = Nil
}

case class Player(
                  override val firstname: String = "",
                  override val lastname: String = "",
                  override val email: String = "",
                  override val partners: List[Person] = Nil,
                  override val affinities: List[Person] = Nil,
                  override val aversions: List[Person] = Nil,
                   position: Position.Value = Position.Lead) extends Person
case class Hopeful(
                    override val firstname: String,
                    override val lastname: String,
                    override val email: String,
                    override val partners: List[Person],
                    override val affinities: List[Person],
                    override val aversions: List[Person],
                    placed: Boolean,
                    positions: List[Position.Value]) extends Person

object Position extends Enumeration {
  type Position = Value
  val Lead, Second, Vice, Skip = Value
}

