/**
  * Created by g.bernonville-ext on 07/12/2016.
  */

import math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
object Player extends App {
  // w: width of the building.
  // h: height of the building.
  val Array(w, h) = for (i <- readLine split " ") yield i.toInt
  val n = readInt
  // maximum number of turns before game over.
  var Array(x0, y0) = for (i <- readLine split " ") yield i.toInt
  var (minx0, maxx0, miny0, maxy0) = (0, w, 0, h)
  var borders = (minx0, maxx0, miny0, maxy0)

  // game loop
  while (true) {
    val bombdir = readLine
    // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
    val (x1, y1) = bombdir match {
      case "U" => goUp((x0, y0))
      case "UL" => goLeft(goUp((x0, y0)))
      case "UR" => goRight(goUp((x0, y0)))
      case "L" => goLeft((x0, y0))
      case "D" => goDown((x0, y0))
      case "DL" => goLeft(goDown((x0, y0)))
      case "DR" => goRight(goDown((x0, y0)))
      case "R" => goRight((x0, y0))
    }

    val (minx1, maxx1, miny1, maxy1) = restrictArea(bombdir, (x0, y0))
    minx0 = minx1
    maxx0 = maxx1
    miny0 = miny1
    maxy0 = maxy1

    borders = (minx0, maxx0, miny0, maxy0)

    // Write an action using println
    // To debug: Console.err.println("Debug messages...")
    x0 = x1
    y0 = y1

    // the location of the next window Batman should jump to.
    Console.err.println((minx1, maxx1, miny1, maxy1))
    println(x0 + " " + y0)
  }

  def restrictArea(direction: String, currentPos: (Int, Int)) = {
    currentPos match {
      case (x0, y0) =>
        direction match {
          case "U" => (minx0, maxx0, miny0, y0)
          case "UL" => (minx0, x0, miny0, y0)
          case "UR" => (x0, maxx0, miny0, y0)
          case "L" => (minx0, x0, miny0, maxy0)
          case "D" => (minx0, maxx0, y0, maxy0)
          case "DL" => (minx0, x0, y0, maxy0)
          case "DR" => (x0, maxx0, y0, maxy0)
          case "R" => (x0, maxx0, miny0, maxy0)
        }
    }
  }

  def goUp(currentPos: (Int, Int)): (Int, Int) = currentPos match {
    case (x, y) => borders match {
      case (minx, maxx, miny, maxy) => (x, miny + (y-miny) / 2)
    }
  }

  def goLeft(currentPos: (Int, Int)): (Int, Int) = currentPos match {
    case (x, y) => borders match {
      case (minx, maxx, miny, maxy) => (minx + (x-minx) / 2, y)
    }
  }

  def goRight(currentPos: (Int, Int)): (Int, Int) = currentPos match {
    case (x, y) => borders match {
      case (minx, maxx, miny, maxy) => (x + (maxx - x) / 2, y)
    }
  }

  def goDown(currentPos: (Int, Int)): (Int, Int) = currentPos match {
    case (x, y) => borders match {
      case (minx, maxx, miny, maxy) => (x, y + (maxy - y) / 2)
    }
  }

}