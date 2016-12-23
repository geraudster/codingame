import org.scalatest.FlatSpec

/**
  * Created by g.bernonville-ext on 09/12/2016.
  */
class DwarfTest extends FlatSpec {
  "App" should "parse standard input" in {
    val input =
      """3
        |1 2
        |1 3
        |3 4""".stripMargin

    assert (Solution.tree(input.split("\r\n").toIterator) === Map(1 -> List(2, 3), 3 -> List(4)))
  }
}
