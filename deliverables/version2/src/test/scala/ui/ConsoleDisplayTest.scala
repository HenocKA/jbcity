package test.scala.ui

import org.scalatest._
import org.scalatest.matchers._
import org.scalacheck._

class ConsoleDisplayTest {
  import main.scala.ui._
  import main.scala.sim._

   var console: ConsoleDisplay =   new ConsoleDisplay()
   var mayor: Mayor = new Mayor("",new City("KMCity", 10, 10),0)
   

  	console.displayCity(mayor.city)
  
}