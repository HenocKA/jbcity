package main.scala.sim.network


object NetworkFactory {
  var listNetwork = Vector("***","###","&&&","~~~")
  def apply (typeInfr:String):Network = typeInfr match  {
    
    //Infrastructure 
    case "***" =>  new NetworkElectricity 

      //InfrastructureCommercial
    case "###" => new NetworkRailway 
      
      //InfrastructureEntertainment
    case "&&&" => new NetworkRoad 
    
      //InfrastructureProduction
    
      
      //InfrastructureResidential  
    case "~~~" => new NetworkWater 
    
      //InfrastructureSecurity

      //InfrastructureSocial
      
      //InfrastructureTransport
    
  }
}

