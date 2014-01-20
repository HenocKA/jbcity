package main.scala.sim.network

class NetworkRailway extends Network{
  constructionCost = 2000 
  destructionCost = 1500
  constructionTime = 50
  energy = 100
  water = 100
  
  maintenanceCost = 5 //by day
  override def getname():String = "---"
}