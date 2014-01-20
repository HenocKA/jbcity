package main.scala.sim.network


object NetworkFactory {
  var listNetwork = Vector("Electricity","Railway","Road","Water")
  def apply (typeInfr:String):Network = typeInfr match  {
    
    case "Electricity" =>  new NetworkElectricity //"***"

    case "Railway" => new NetworkRailway //"---"

    case "Road" => new NetworkRoad //"+++"

    case "Water" => new NetworkWater //"~~~"
  }
}

