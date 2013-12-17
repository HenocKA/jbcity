package main.scala.sim

class Mayor(n:String, c:City, b:Int){
	val name = n;
	var budget = b;
	var city = c;
	def modify_budget (x:Int) = {
	this.budget += x;
	}	
	
	//différentes actions possibles du maire
	def create(i:Infrastructure, x:Int, y:Int){
	  if (this.city.isEmpty(x,y)) 
	    i.create(this,x,y)
	  else
	    println("impossible de construire à cet endroit"); 
	}
	def delete(i:Infrastructure, x:Int, y:Int){
	  if (this.city.isEmpty(x,y)) 
	    println("impossible de détruire à cet endroit")
	  else
	    i.delete(this,x,y)
	}
	
	def delete(x:Int, y:Int):Boolean = {
	  if (this.city.isEmpty(x,y)) 
	  	false
	    //println("impossible de détruire à cet endroit")
	  else
	  	true;
	    //this.city.map(x)(y)="\033[30memp\033[0m"
	}
	
	def create(n:Network, x:Int, y:Int){
	  if (this.city.isEmpty(x,y)) 
	    n.create(this,x,y)
	  else
	    println("impossible de construire à cet endroit"); 
	}
	def delete(n:Network, x:Int, y:Int){
	  if (this.city.isEmpty(x,y)) 
	    println("impossible de détruire à cet endroit")
	  else
	    n.create(this,x,y)
	}
	def get_impots(x:Int, y:Int){
	  if(this.city.isEmpty(x,y))
	    println("impossible de récolter des impôts ici")
	  else
	    this.city.get_impots(x,y);
	}
}