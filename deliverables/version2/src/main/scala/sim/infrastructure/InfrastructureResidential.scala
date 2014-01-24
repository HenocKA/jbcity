package main.scala.sim.infrastructure

abstract class InfrastructureResidential extends Infrastructure with Inhabitants 

class House extends InfrastructureResidential{
  constructionCost = 200
  destructionCost = 50
  constructionTime = 10
  energy = 100
  water = 50

  inhabitantsMax = 10
  randomInhabitants //Random Number of inhabitants

  taxes=10
}

class Hotel extends InfrastructureResidential with Employments{
  constructionCost = 2000
  destructionCost = 505
  constructionTime = 25
  energy = 1500
  water = 750
  
  inhabitantsMax = 250
  randomInhabitants //Random Number of inhabitants
  
  numEmployment = 250
}