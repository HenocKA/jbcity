package main.scala.sim.infrastructure

abstract class InfrastructureCommercial extends Infrastructure with Taxes 
                                           with Employments{
  constructionCost = 2500 
  destructionCost = 100
  constructionTime = 25
  energy = 100
  water = 100
  
  
  numEmployment = 50
  taxes = 250
}

class McDonalds extends InfrastructureCommercial


