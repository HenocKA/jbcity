package com.jbcity.sim

class infrastructure {
	var id="inf";
	var cost=0;
	var time=0;
	var energy=0;
	var water=0;
	def create (m:mayor, x:Int, y:Int){
	  if (m.budget >= cost 
	      && m.my_city.energy >= energy 
	      && m.my_city.water >= water){
	    m.my_city.map(x)(y)= this.id;
	    m.modify_budget(-1*this.cost)
	    m.my_city.modify_energy(-1*this.energy)
	    m.my_city.modify_water(-1*this.water)
	  }
	  else {
	    println("Impossible de créer cette infrastucture...")
	  }
	}
	def delete (m:mayor, x:Int, y:Int){
	  if(m.my_city.isEmpty(x,y) || 
	      m.my_city.map(x)(y)!= this.id)
	    println("Impossible de détruire ici")
	  else{
	    m.my_city.map(x)(y)="\033[30memp\033[0m"
	  }
	}
}

