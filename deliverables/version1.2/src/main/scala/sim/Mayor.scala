package main.scala.sim
import main.scala.sim.infrastructure._

class Mayor(n:String, c:City, b:Int){
	val name = n;
	var budget = b;
	var city = c;
	def modify_budget (x:Int) = {
	this.budget += x;
	}	
	
  //Mayor Actions
	def add(i:JBObject, x:Int, y:Int) :Boolean ={
            city.add(i,x,y)
	}
        
	def destroy(x:Int, y:Int) {
	  city.destroy(x,y)
	}

	def getTax(x:Int, y:Int) : Int = {
	  city.getTax (x, y)
	}
}