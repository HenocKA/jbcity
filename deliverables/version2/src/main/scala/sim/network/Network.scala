package main.scala.sim.network

import main.scala.sim._
import main.scala.sim.even._
import main.scala.sim.infrastructure._

abstract class Network extends JBObjectConstructed with Maintenance {
  
   constructionCost = 1000 
   destructionCost = 100
   constructionTime = 0
   energy = 100
   water = 100
  
  maintenanceCost = 10 //by day
	
  def getname():String = "***"
  
}

