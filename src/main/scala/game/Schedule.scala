package game

import game.Position.Position

import scala.collection.mutable
import scala.collection.mutable.MutableList
import scala.util.Random

class Schedule {

  def create(seriesName: String, numDraws: Int): Series = {
    val draws = List.tabulate(numDraws)(n => new Draw(('A' + n).toChar.toString))
    new Series(seriesName, draws)
  }

  def buildTeamsOfFriends(hopefuls: List[Hopeful]): List[Team] = {
    val teams: MutableList[Team] = new mutable.MutableList[Team]()
    val friendlies = hopefuls.filter(h => h.partners.size > 0 && h.placed == false)
    if (friendlies.size == 0)
      teams.toList
    else {
      val player = friendlies(Random.nextInt(friendlies.size))
    }
    teams.toList
  }

  def findAvailableTeam(teams: List[Team], positions: List[Position]): Option[Team] = {
    val r = Random.shuffle(teams)
    val e = r.filter(t => positions.diff(t.players.keys.toList).size > 0)
    e.take(1).size match {
      case 0 => None
      case _ => Some(e.head)
    }
  }
}
