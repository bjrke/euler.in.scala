package de.bjrke.euler.problem0022

import scala.io._
import scala.util._
import scala.collection.mutable.ListBuffer

/**
 * Using names.txt  (right click and 'Save Link/Target As...'), a 46K text file 
 * containing over five-thousand first names, begin by sorting it into 
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name 
 * score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * 871198282
 */
object Problem0022 {
  def main(args : Array[String]) : Unit = {
    val src = Source.fromURL( getClass.getClassLoader.getResource("de/bjrke/euler/problem0022/names.txt") )
    var currentword = "";
    val names = new ListBuffer[String]()
    src.foreach( _ match {
      case '"' => if ( !currentword.isEmpty ) {
          names += currentword
          currentword = ""
      }
      case ',' =>
      case ch : Char => currentword += ch 
    } )
    val res = names.toArray
    var total = 0
    Sorting.quickSort( res )
    for ( i <- 0 until res.length ) {
      total += ( i + 1 ) * res( i ).foldLeft( 0 )( _ + _ - ( 'A' - 1 ) )
    }
    println( total )
  }



}
