package com.jbcity.sim

class mayor(n:String, c:city, b:Int){
	val name = n;
	var budget = b;
	val my_city = c;
	def modify_budget (x:Int) = {
	this.budget += x;
	}	
	
	//différentes actions possibles du maire
	def create(i:infrastructure, x:Int, y:Int){
	  if (this.my_city.isEmpty(x,y)) 
	    i.create(this,x,y)
	  else
	    println("impossible de construire à cet endroit"); 
	}
	def delete(i:infrastructure, x:Int, y:Int){
	  if (this.my_city.isEmpty(x,y)) 
	    println("impossible de détruire à cet endroit")
	  else
	    i.delete(this,x,y)
	}
	
	def delete(x:Int, y:Int){
	  if (this.my_city.isEmpty(x,y)) 
	    println("impossible de détruire à cet endroit")
	  else
	    this.my_city.map(x)(y)="\033[30memp\033[0m"
	}
	
	def create(n:network, x:Int, y:Int){
	  if (this.my_city.isEmpty(x,y)) 
	    n.create(this,x,y)
	  else
	    println("impossible de construire à cet endroit"); 
	}
	def delete(n:network, x:Int, y:Int){
	  if (this.my_city.isEmpty(x,y)) 
	    println("impossible de détruire à cet endroit")
	  else
	    n.create(this,x,y)
	}
	def get_impots(x:Int, y:Int){
	  if(this.my_city.isEmpty(x,y))
	    println("impossible de récolter des impôts ici")
	  else
	    this.my_city.get_impots(x,y);
	}
}