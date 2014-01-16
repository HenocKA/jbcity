package main.scala.sim.infrastructure

abstract class InfrastructureProduction extends Infrastructure
                                           with Maintenance{
  constructionCost = 35000
  destructionCost = 750
  constructionTime = 35
  energy = 2500
  water = 3575
}

