package main.scala.sim
import main.scala.sim.even._

class Population extends scala.Serializable with RandomEven{
  var max:Int = 1; //nb max d'habitants possible
  var nb: Int = 1; // nb d'habitant
  var sat:Int = 50 // niveau de satisfaction des habitants
  
  //x positif ou négatif
  def modify_max (x:Int) = {
    this.max += x;
  }
  def modify_nb(x:Int) = {
    this.nb += x;
  }
  def modify_sat(x:Int){
    this.sat += x;
  }
  override def epidemic(numberPeople:Int){
    var r = new scala.util.Random
    this.nb -= r.nextInt(this.nb)
  }
  
}
