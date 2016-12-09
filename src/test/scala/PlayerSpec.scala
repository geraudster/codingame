import org.scalatest.FlatSpec

/**
  * Created by g.bernonville-ext on 07/12/2016.
  */
class PlayerSpec extends FlatSpec {
  "Area" should "be restricted at the bottom when bomb is up" in {
    Player.minx0 = 0
    Player.maxx0 = 10
    Player.miny0 = 0
    Player.maxy0 = 15
    val newArea = Player.restrictArea("U", (2, 5))
    assert(newArea === (0, 10, 0, 5))
  }

  "Batman" should "go up when bomb is up" in {
    Player.minx0 = 0
    Player.maxx0 = 10
    Player.miny0 = 0
    Player.maxy0 = 15
    Player.borders = (0, 10, 0, 15)
    val newPosition = Player.goUp((2, 5))
    assert(newPosition === (2, 2))
  }

  "Batman" should "go up when bomb is up (2)" in {
    Player.minx0 = 23
    Player.maxx0 = 40
    Player.miny0 = 33
    Player.maxy0 = 60
    Player.borders = (23, 40, 33, 60)
    val newPosition = Player.goUp((31, 46))
    assert(newPosition === (31, 39))
  }

  "Batman" should "go down when bomb is down" in {
    Player.minx0 = 23
    Player.maxx0 = 40
    Player.miny0 = 33
    Player.maxy0 = 60
    Player.borders = (23, 40, 33, 60)
    val newPosition = Player.goDown((31, 46))
    assert(newPosition === (31, 53))
  }
}
