package main.scala.sim.network
import main.scala.sim._
import main.scala.sim.even._

class Network extends JBObject {
  
  var constructionCost = 1000 
  var destructionCost = 100
  var constructionTime = 0
  var energy = 100
  var water = 100
  
	def create(m:Mayor, x:Int, y:Int){
	  return;
	}
  
}

// Entretien des batiments
trait EmploymentsNetwork {
  var numEmployment = 20 //by day
}