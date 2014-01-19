package main.scala.sim.infrastructure
import main.scala.sim._
import main.scala.sim.even._
import scala.util.Random

abstract class Infrastructure extends JBObject {
  var constructionCost = 1000 
  var destructionCost = 100
  var constructionTime = 0
  var energy = 100
  var water = 100
        
  var taxes = 10 //Impôts
  
  def collectTax : Int = {
    val _taxes = taxes
    taxes = 0
    _taxes
  } 
  //Execute this methode every hour
  def increaseTaxes = {taxes += taxes} 
  def increaseTaxes (percent: Int) = {taxes += taxes*percent} 
}


//Habitants
trait Inhabitants {
  var inhabitantsMax = 10
  var inhabitants = 0//Number of inhabitant
  
  def increaseInhabitants(number:Int) = {
    inhabitants+= number;
    verifyInhabitants
  }
  
  def decreaseInhabitants(number: Int) = {
    inhabitants-= number
    verifyInhabitants
  }
  def randomInhabitants = {
    inhabitants = (new Random) nextInt(inhabitantsMax)
  }
  def verifyInhabitants = {
    if (inhabitants > inhabitantsMax) 
      inhabitants = inhabitantsMax
    if (inhabitants < 0) 
      inhabitants = 0
  }
}

// Entretien des batiments
trait Maintenance {
  var maintenanceCost = 10 //by day
}

// Entretien des batiments
trait Employments {
  var numEmployment = 50 //by day
}

class TownHall extends Infrastructure with Inhabitants{
  inhabitantsMax = 1
  inhabitants = 1
}