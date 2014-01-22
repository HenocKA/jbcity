package main.scala.sim

abstract class JBObject  extends scala.Serializable {
}

abstract class JBObjectConstructed extends JBObject{
  var constructionCost = 10 
  var destructionCost = 10
  var constructionTime = 0
  var energy = 10
  var water = 10
}

abstract class JBObjectNotConstructed extends JBObject{
}