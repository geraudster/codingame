/**
  * Created by g.bernonville-ext on 09/12/2016.
  */

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
sealed trait Tree[A]

case object Nil extends Tree[Nothing]
case class Cons[A](root: A, children: Array[Tree[A]]) extends Tree[A]

object Solution extends App {
  val n = readInt // the number of relationships of influence

//  val tree = tree(io.Source.stdin.getLines)

  def tree(lines: Iterator[String]) = {
    lines.next // skip first line
    lines.map({x => { println("hi " + x); for(i <- x split " ")yield i.toInt} })
  }
  // Write an action using println
  // To debug: Console.err.println("Debug messages...")


  // The number of people involved in the longest succession of influences
//  println(tree)
}