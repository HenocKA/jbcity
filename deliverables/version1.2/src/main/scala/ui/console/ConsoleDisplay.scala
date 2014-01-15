package main.scala.ui.ConsoleUI

import main.scala.sim._
import main.scala.sim.infrastructure._

class ConsoleDisplay{
  
  def displayCity(city:City){	
    val ord = city.ord
    val abs = city.abs
    val map = city.map
		
    for (x <- 0 to abs-1)
      print("    "+x+" ")
    println("")
    for (i <- 0 to abs-1){
      for(x <-0 to abs-2)
        print(" ----- ")
      println("")
      print(i+" ")
      for (j <- 0 to ord-1){
    	print(" | ");
        print(displayCell(map(i)(j)));
    	//print("| ");
      }
      print(" |")
      println("");
    }
  }	

	
  def displayCell(obj:JBObject): String = obj match  {
	
    case null => "\033[30memp\033[0m"
      
    case _:InfrastructureCommercial =>  "\033[31mcom\033[0m"
			
    case _:InfrastructureEntertainment =>  "\033[32mloi\033[0m"

    case _:InfrastructureProduction =>  "\033[33mpro\033[0m"

    case _:InfrastructureResidential =>  "\033[34mres\033[0m"
    
    case _:InfrastructureSecurity =>  "\033[35mloi\033[0m"
    
    case _:InfrastructureSocial =>  "\033[36msoc\033[0m"
	
    case _:InfrastructureTransport =>  "\033[37mtra\033[0m"
      
		
  }
  
  def displayInfrastructures(){
    var infras = InfrastructureFactory.listInfrastructures
    for (i <- 0 to infras.length-1)
      println(i + " : " + infras(i))
  }
  
  def displayIncorrectChoice(){
    
  }
}
