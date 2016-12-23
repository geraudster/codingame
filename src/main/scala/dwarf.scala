import scala.collection.mutable

/**
  * Created by g.bernonville-ext on 09/12/2016.
  */

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
sealed trait Tree[A]

case class Cons[A](root: A, children: Array[A]) extends Tree[A]

case class Node[A](root: A, children: Array[Tree[A]]) extends Tree[A]

case object Nil extends Tree[Nothing]

object Solution extends App {
  val n = readInt // the number of relationships of influence

  def tree(lines: Iterator[String]) = {
    val nodeMap = mutable.HashMap.empty[Int, List[Int]]
    lines.drop(1).filter(x => !x.isEmpty).map(x => {
      val Array(x1, y1) = for (i <- x.split(" ")) yield i.toInt
      (x1, y1)
    }).toTraversable.groupBy(_._1).foreach({
      case (root, children) => {
        println (root, children)
        nodeMap += (root -> children.map(_._2).toList)
      }
    })
    nodeMap
  }

  def height(nodeMap: mutable.HashMap[Int, List[Int]]) = {

  }
  // Write an action using println
  // To debug: Console.err.println("Debug messages...")


  // The number of people involved in the longest succession of influe nces
  //  println(tree)
}