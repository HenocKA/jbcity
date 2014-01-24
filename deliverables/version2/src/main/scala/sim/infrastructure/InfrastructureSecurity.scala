package main.scala.sim.infrastructure

class InfrastructureSecurity extends Infrastructure 

class Police extends InfrastructureSecurity{
  constructionCost = 50000
  destructionCost = 5000
  constructionTime = 1000
  energy = 1000
  water = 5000
}