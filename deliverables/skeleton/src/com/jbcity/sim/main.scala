//package com.jbcity.sim
import com.jbcity.sim._

class partie{
  
}

object partie {
  def main(args: Array[String]){
    val city = new city(10,10)
    city.init();
    city.display()
    val mayor = new mayor("zouhire", city, 50)
    val infrastructure = new infrastructure()
    mayor.create(infrastructure, 2, 5)
    city.display()
  }
}