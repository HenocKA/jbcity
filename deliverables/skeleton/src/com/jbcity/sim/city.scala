package com.jbcity.sim

class city(abs:Int, ord:Int) {
  var energy=0;
  var water = 0;
  var energy_max = 10;
  var water_max = 10;
  val map:Array[Array[String]] = Array.ofDim(abs,ord);
  def init() ={ 
    for (i <- 0 to abs-1)
      for (j <- 0 to ord-1)
        this.map(i)(j)="emp";
  }
  def isEmpty(i:Int, j:Int)= {
    if (this.map(i)(j)=="emp") true else false;  
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
    for (x <- 0 to abs-1)
      print("    "+x+" ")
    println("")
    for (i <- 0 to abs-1){
      for(x <-0 to abs-2)
        print(" ----- ")
      println("")
      print(i+" ")
      for (j <- 0 to ord-1){
    	print(" | ");
        print(this.map(i)(j));
    	//print("| ");
      }
      print(" |")
      println("");
    }
  }	
  def get_impots(x:Int,y:Int){
    return;
    //this.map(i)(j).get_impots();
  }
}