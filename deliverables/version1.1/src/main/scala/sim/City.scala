package main.scala.sim

class City(_name:String, _abs:Int, _ord:Int) {
	var abs = _abs
	var ord = _ord
  val name = _name
  var energy=0;
  var water = 0;
  var energy_max = 10;
  var water_max = 10;
  val map:Array[Array[JBObject]] = Array.ofDim(abs,ord);
  
  def init() ={ 
    for (i <- 0 to abs-1)
      for (j <- 0 to ord-1)
        this.map(i)(j)=new JBObject();
  }
  def isEmpty(i:Int, j:Int):Boolean= {
    if (this.map(i)(j) == null) 
    	true 
    else 
    	false
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
  	
  def get_impots(x:Int,y:Int){
    return;
    //this.map(i)(j).get_impots();
  }
}