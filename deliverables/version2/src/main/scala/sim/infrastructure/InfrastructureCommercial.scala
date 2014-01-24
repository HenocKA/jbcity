package main.scala.sim.infrastructure

abstract class InfrastructureCommercial extends Infrastructure 
                                           with Employments

class McDonalds extends InfrastructureCommercial{
  constructionCost = 2500 
  destructionCost = 100
  constructionTime = 25
  energy = 100
  water = 100
  
  
  numEmployment = 50
  taxes = 250
}


