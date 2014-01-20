package main.scala.sim.network
import main.scala.sim._
import main.scala.sim.even._
import main.scala.sim.infrastructure._

abstract class Network extends JBObject with Maintenance {
  
  var constructionCost = 1000 
  var destructionCost = 100
  var constructionTime = 0
  var energy = 100
  var water = 100
  
  maintenanceCost = 10 //by day
	
  def getname():String = "***"
  
}

