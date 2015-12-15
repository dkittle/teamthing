package game

import org.scalatest.{Matchers, FlatSpec}
import game.Position._

class ScheduleSpec extends FlatSpec with Matchers {

    "A schedule" should "have one draw if specified" in {
      val series = new Schedule().create("1", 1)
      series.name should be ("1")
      series.draws.size should be (1)
      series.draws(0).name should be ("A")
    }

  it should "have two draws if that is specified" in {
    val series = new Schedule().create("2", 2)
    series.name should be ("2")
    series.draws.size should be (2)
    series.draws(0).name should be ("A")
    series.draws(1).name should be ("B")
  }

  "A team" should "not be found" in {
    val c = Team(Map(Lead -> Player()), "C")
    val d = Team(Map(Lead -> Player(), Second -> Player()), "D")
    val t3 = List(c,d)
    val sched = new Schedule()
    val team = sched.findAvailableTeam(t3, List(Lead))
    team should be (None)
  }

  "Team C" should "be found" in {
    val c = Team(Map(Lead -> Player()), "C")
    val d = Team(Map(Lead -> Player(), Second -> Player()), "D")
    val t3 = List(c,d)
    val sched = new Schedule()
    val team = sched.findAvailableTeam(t3, List(Second))
    team should not be (None)
    team.take(1).headOption.get should be (c)
  }

  "Team C or D" should "be found" in {
    val c = Team(Map(Lead -> Player()), "C")
    val d = Team(Map(Lead -> Player(), Second -> Player()), "D")
    val t3 = List(c,d)
    val sched = new Schedule()
    val team = sched.findAvailableTeam(t3, List(Vice))
    t3 should contain (team.take(1).headOption.get)
    val teams = sched.findAvailableTeams(t3, List(Vice))
    t3.diff(teams).headOption should be (None)
  }

}
