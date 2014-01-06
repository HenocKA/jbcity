package main.scala.sim.infrastructure


class InfrastructureFactory {
  
  def  apply (typeInfr:String):Infrastructure = typeInfr match  {
    
    case "Commercial" => new InfrastructureCommercial()
    case "Entertainment"  => new InfrastructureEntertainment()
    case "Production" => new InfrastructureProduction()
    case "Residential" => new InfrastructureResidential()
    case "Security" => new InfrastructureSecurity()
    case "Social" => new InfrastructureSocial()
    case "Transport" => new InfrastructureTransport()
    
  }
}

