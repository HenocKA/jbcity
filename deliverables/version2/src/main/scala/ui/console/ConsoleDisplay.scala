package main.scala.ui.console

import main.scala.sim._
import main.scala.sim.infrastructure._
import main.scala.sim.network._

class ConsoleDisplay extends scala.Serializable{
  var numLetters = 3 //num of caratees
  var lineCaption = ""
  var caption = ""

  def displayCity(city: City) {
    val ord = city.ord
    val abs = city.abs
    val map = city.map

    print("    ")
    for (x <- 0 to abs - 1)
      print("  " + x + "   ")
    println("")
    for (i <- 0 to abs - 1) {
      print("    ")
      for (x <- 0 to abs - 1)
        print("----- ")
      println("")
      print(i + " ")
      for (j <- 0 to ord - 1) {
        print(" | ");
        print(displayCell(map(i)(j)));

        //print("| ");
      }

      print(" |")

      println(" " + getLineCaption);
    }
    print("    ")
    for (x <- 0 to abs - 1)
      print("----- ")
    
    clearCaption()
  }
  
   def getClassNameWithColor(obj: JBObject, numChar: Int, symbol:Boolean = false): String = obj match {
    case inf: InfrastructureCommercial    => "\033[31m" + simpleName(inf, numChar) + "\033[0m"
    case inf: InfrastructureEntertainment => "\033[32m" + simpleName(inf, numChar) + "\033[0m"
    case inf: InfrastructureProduction    => "\033[33m" + simpleName(inf, numChar) + "\033[0m"
    case inf: InfrastructureResidential   => "\033[34m" + simpleName(inf, numChar) + "\033[0m"
    case inf: InfrastructureSecurity      => "\033[35m" + simpleName(inf, numChar) + "\033[0m"
    case inf: InfrastructureSocial        => "\033[36m" + simpleName(inf, numChar) + "\033[0m"
    case inf: InfrastructureTransport     => "\033[37m" + simpleName(inf, numChar) + "\033[0m"

    case inf: Infrastructure              => simpleName(inf, numChar)
    
    case net: NetworkElectricity    => "\033[31m" + simpleName(net, numChar,symbol) + "\033[0m"
    case net: NetworkRailway => "\033[32m" + simpleName(net, numChar, symbol) + "\033[0m"
    case net: NetworkRoad    => "\033[33m" + simpleName(net, numChar, symbol) + "\033[0m"
    case net: NetworkWater   => "\033[34m" + simpleName(net, numChar, symbol) + "\033[0m"

    case null => "\033[30m" + simpleName(null, numChar) + "\033[0m"
  }

  def displayCell(obj: JBObject): String =  {
    if (obj != null)
     addLineCaption(obj)
    getClassNameWithColor(obj, numLetters, true)
  }

  def simpleName(obj: JBObject, numChar: Int, symbol:Boolean = false): String = {
    if (obj == null )
      " " * numChar
    else if(symbol) {
      getNetSymbol(obj, numChar)
    }
    else {
      val name = obj.getClass.getSimpleName
      if (name.length >= numChar)
        name.substring(0, numChar)
      else
        name + " " * (numChar - name.length)
    }
  }
  
  def getNetSymbol(obj: JBObject, numChar: Int): String = obj match {
    case _: NetworkElectricity    => "*" * numChar
    case _: NetworkRailway => "-" * numChar
    case _: NetworkRoad    => "+" * numChar
    case _: NetworkWater   => "~" * numChar
    
    case _ => " " * numChar
  }
 

  def displayInfrastructures() {
    var infras = InfrastructureFactory.listInfrastructures
    for (i <- 0 to infras.length - 1)
      println(i + " : " + infras(i))
  }

  def addLineCaption(obj:JBObject) = {
    val name = obj.getClass.getSimpleName
    val nameColored = getClassNameWithColor(obj,name.length)
    
    if (caption.contains(nameColored) == false) {
      caption += nameColored
      if (lineCaption == "")
        lineCaption = nameColored
      else
        lineCaption += ", " + nameColored
    }
  }

  def getLineCaption: String = {
    val tmp = lineCaption
    lineCaption = ""
    tmp
  }

  def clearCaption() ={
    caption = ""
  }
}
