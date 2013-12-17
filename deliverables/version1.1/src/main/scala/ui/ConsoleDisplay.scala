package main.scala.ui

import main.scala.sim._

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
        print(display_cell(map(i)(j)));
    	//print("| ");
      }
      print(" |")
      println("");
    }
  }	

	
	def display_cell(obj:JBObject): String = obj.getClass.getSimpleName match  {
	
		case "InfrastructureCommercial" =>  "\033[31mcom\033[0m"
			
		case "InfrastructureEntertainment" => "\033[32mloi\033[0m"

		case "InfrastructureProduction" => "\033[33mpro\033[0m"

		case "InfrastructureResidential" => "\033[34mres\033[0m"
    
    	case "InfrastructureSecurity" => "\033[35mloi\033[0m"
    
    	case "InfrastructureSocial" => "\033[36msoc\033[0m"
	
		case "InfrastructureTransport" => "\033[37mtra\033[0m"
    
		case _ => "\033[30memp\033[0m"
	}
}