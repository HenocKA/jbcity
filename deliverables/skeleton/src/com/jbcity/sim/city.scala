package com.jbcity.sim

class city(abs:Int, ord:Int) {
  var energy=0;
  var water = 0;
  var energy_max = 10;
  var water_max = 10;
  val map:Array[Array[String]] = Array.ofDim(abs,ord);
  def init() ={ 
    for (i <- 0 to abs)
      for (j <- 0 to ord)
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
  
  def display(){
    for (i <- 0 to abs){
      for (j <- 0 to ord){
        print(this.map(i)(j));
    	print("| ");
      }
    println("");
    }
  }	
  def get_impots(x:Int,y:Int){
    return;
    //this.map(i)(j).get_impots();
  }
}