//package com.jbcity.entity

class ville(abs:Int, ord:Int) {
  var energy:Int =0;
  var water:Int = 0;
  var energy_max:Int = 10;
  var water_max:Int = 10;
  val map:Array[Array[String]] = Array.ofDim(abs,ord);
  def init(x:Int, y:Int) ={ 
    for (i <- 0 to x)
      for (j <- 0 to y)
        this.map(i)(j)="";
  }
  def isEmpty(i:Int, j:Int)= {
    if (this.map(i)(j)=="") true else false;  
  }
  def modify_energy (x:Int) = {
	this.energy += x;
  }
  def modify_water (x:Int) = {
	this.water += x;
  }
  def modify_energy_max(x:Int) = {
    this.energy_max += x;
  }
  
  
}