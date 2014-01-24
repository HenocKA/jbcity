package main.scala.sim.infrastructure

class InfrastructureTransport extends Infrastructure with Employments 

class Airport extends InfrastructureTransport{
  constructionCost = 5000
  destructionCost = 5000
  constructionTime = 84
  energy = 7500
  water = 5050
  
  numEmployment = 5000
}