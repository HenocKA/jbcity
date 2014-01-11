package main.scala.sim.infrastructure
import main.scala.sim._

abstract class Infrastructure extends JBObject with Random_Even {
	var id="inf";
	var cost=0;
	var time=0;
	var energy=0;
	var water=0;
        
        def create (m:Mayor, x:Int, y:Int){
	  if (m.budget >= cost 
	      && m.city.energy >= energy 
	      && m.city.water >= water){
	   //m.city.map(x)(y)= this.id;
	    m.city.map(x)(y)= this;
	    m.modify_budget(-1*this.cost)
	    m.city.modify_energy(-1*this.energy)
	    m.city.modify_water(-1*this.water)
	  }
	  else {
	    println("Impossible de crÃ©er cette infrastucture...")
	  }
	}
	
	def delete (m:Mayor, x:Int, y:Int){
	  if(m.city.isEmpty(x,y) || 
	      m.city.map(x)(y)!= this.id)
	    println("Impossible de dÃ©truire ici")
	  else{
	    m.city.map(x)(y)= null
	  }
	}
	
	/**
	 * Effets liés à un random even sur l'infrastructure
	 * Cette méthode est appelé si l'intrastructure doit
	 * subir des modifications aléatoire
	 */

	def Even_Destroy (m:Mayor, x:Int, y:Int){
	  
	}
}

