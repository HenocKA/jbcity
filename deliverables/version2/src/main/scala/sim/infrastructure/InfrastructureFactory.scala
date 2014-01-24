package main.scala.sim.infrastructure


object InfrastructureFactory {
  var listInfrastructures = Vector("McDonalds","SqualesBowlingClub","House",
                                   "Hotel","University", "Airport",
                                   "CarbonFactory","Police")
  def apply (typeInfr:String):Infrastructure = typeInfr match  {
    
    //Infrastructure 
    case "TownHall" =>  new TownHall 

      //InfrastructureCommercial
    case "McDonalds" => new McDonalds 
    
      
      //InfrastructureEntertainment
    case "SqualesBowlingClub" => new SqualesBowlingClub 
    
      //InfrastructureProduction
    case "CarbonFactory" => new CarbonFactory
      
      //InfrastructureResidential  
    case "House" => new House 
    case "Hotel" => new Hotel

      //InfrastructureSecurity
     case "Police" => new 
      
      //InfrastructureSocial
      case "University" => new University
      
      //InfrastructureTransport
      case "Airport" => new 
  }
}

