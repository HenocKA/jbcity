package main.scala.ui.ConsoleUI

import main.scala.sim._
import main.scala.sim.infrastructure._

class ConsoleDisplay{
    val numLetters = 3 //num of caratees

  def displayCity(city:City){	
    val ord = city.ord
    val abs = city.abs
    val map = city.map
		
    print("    ")
    for (x <- 0 to abs-1)
      print("  " + x + "   ")
    println("")
    for (i <- 0 to abs-1){
       print("    ")
      for(x <-0 to abs-1)
        print("----- ")
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
    print("    ")
    for(x <-0 to abs-1)
        print("----- ")
  }	

	
  def displayCell(obj:JBObject): String = obj match  {
      
    case inf:InfrastructureCommercial =>  "\033[31m" + simpleName(inf) + "\033[0m"		
    case inf:InfrastructureEntertainment =>  "\033[32m" + simpleName(inf) + "\033[0m"
    case inf:InfrastructureProduction =>  "\033[33m" + simpleName(inf) + "\033[0m"
    case inf:InfrastructureResidential =>  "\033[34m" + simpleName(inf) + "\033[0m"
    case inf:InfrastructureSecurity =>  "\033[35m" + simpleName(inf) + "\033[0m"
    case inf:InfrastructureSocial =>  "\033[36m" + simpleName(inf) + "\033[0m"
    case inf:InfrastructureTransport =>  "\033[37m" + simpleName(inf) + "\033[0m"
    
    case inf:Infrastructure =>  simpleName(inf)
    case null => "\033[30m" + simpleName(null) + "\033[0m"
		
  }
  
  def simpleName(obj:JBObject): String = {
    if (obj == null)
      " " * this.numLetters
    else {
       val name = obj.getClass.getSimpleName
       if (name.length >=4)
         name.substring(0,this.numLetters)
       else
         name + " " * (numLetters - name.length )
    }
  }
    
  
  def displayInfrastructures(){
    var infras = InfrastructureFactory.listInfrastructures
    for (i <- 0 to infras.length-1)
      println(i + " : " + infras(i))
  }

}
