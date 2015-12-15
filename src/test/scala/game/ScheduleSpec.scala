package game

import org.scalatest.{Matchers, FlatSpec}

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


}
