package main.scala.sim.infrastructure

class InfrastructureEntertainment extends Infrastructure with Taxes 
                                     with Employments{
  
  constructionCost = 1500
  destructionCost = 350
  constructionTime = 75
  energy = 700
  water = 460
    
  numEmployment=79
  taxes = 600 
    
}

class SqualesBowlingClub extends InfrastructureEntertainment