package main.scala.sim.infrastructure

abstract class InfrastructureResidential extends Infrastructure with Inhabitants {
  constructionCost = 200
  destructionCost = 50
  constructionTime = 10
  energy = 100
  water = 50

  inhabitantsMax = 10
  randomInhabitants //Random Number of inhabitants

  taxes=10
}
class House extends InfrastructureResidential