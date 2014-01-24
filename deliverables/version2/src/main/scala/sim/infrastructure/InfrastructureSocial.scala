package main.scala.sim.infrastructure

class InfrastructureSocial extends Infrastructure with Employments

class University extends InfrastructureSocial {
  constructionCost = 2500
  destructionCost = 250
  constructionTime = 170
  energy = 1200
  water = 500
  
  numEmployment = 500
}