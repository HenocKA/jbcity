package main.scala.sim.infrastructure


object InfrastructureFactory {
  var listInfrastructures = Vector("McDonalds","SqualesBowlingClub","House")
  def apply (typeInfr:String):Infrastructure = typeInfr match  {
    
    //Infrastructure 
    case "TownHall" =>  new TownHall 

      //InfrastructureCommercial
    case "McDonalds" => new McDonalds 
      
      //InfrastructureEntertainment
    case "SqualesBowlingClub" => new SqualesBowlingClub 
    
      //InfrastructureProduction
    
      
      //InfrastructureResidential  
    case "House" => new House 
    
      //InfrastructureSecurity

      //InfrastructureSocial
      
      //InfrastructureTransport

    
  }
}

