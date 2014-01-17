package main.scala.sim
import main.scala.sim.even._

import main.scala.sim.infrastructure._

class City(_name:String, _abs:Int, _ord:Int) extends RandomEven {
  var abs = _abs
  var ord = _ord
  val name = _name
  var energy = 0
  var water = 0
  var energy_max = 10
  var water_max = 10
  var map:Array[Array[JBObject]] = Array.ofDim(abs,ord)
  
  def init() ={ 
    for (i <- 0 to abs-1)
      for (j <- 0 to ord-1)
        this.map(i)(j)=null;
    
    add(InfrastructureFactory ("TownHall"),
        abs/2,
        ord/2) //Ajout de la mairie dans la ville
  }
//  def isEmpty(i:Int, j:Int):Boolean= {
//    if (this.map(i)(j) == null) 
//      true 
//    else 
//      false
//}
  def modify_energy (x:Int) = {
    this.energy += x;
  }
  def modify_water (x:Int) = {
    this.water += x;
  }
  def modify_energy_max(x:Int) = {
    this.energy_max += x;
  }
  	
  def getTax(x:Int,y:Int): Int = map(x)(y) match {
    case tmpInfras:Infrastructure => tmpInfras.collectTax
    case _ => 0
  }
  
  def getTaxes : Int = {
    var taxes = 0
    
    for (i <- 0 to abs-1)
      for (j <- 0 to ord-1)
        taxes += getTax(i,j)
   
    taxes
  }
  
  def add(obj: JBObject, i: Int, j: Int) :Boolean = {
    if (map(i)(j) == null){
      map(i)(j) = obj
      true
    }
    else 
      false
      
  }
  
  def destroy(x: Int, y: Int)= {
    map(x)(y) = null
  }
  
  /**
   * Lance une Èpidemie
   * numberPeople est le nombre de personne 
   * qui sera toucher par l'Èpidemie
   */
  override def epidemic(numberPeople:Int){
    
  }
  /**
   * Lance d'un dasastre
   * numberInfrastructure est le nombre de d'instrastructure  
   * qui sera toucher par le desestre
   */
  override def disaster (numberInfrastructure:Int){
    
  }
  /**
   * Lance autre attaque
   * level aui sera le viveau de dangÈrisitÈ de l'attaque
   */
  override def OtherAttack (level:Int){
    
  }
}
