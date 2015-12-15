package game

import game.Position.Position

case class Team(players: Map[Position, Player] = Map(), draw: String = "")
