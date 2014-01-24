package main.scala.sim.infrastructure

abstract class InfrastructureProduction extends Infrastructure
                                           with Maintenance with Employments


class CarbonFactory extends InfrastructureProduction{
  constructionCost = 35000
  destructionCost = 750
  constructionTime = 35
  energy = 2500
  water = 3575
  
  numEmployment = 1525
}