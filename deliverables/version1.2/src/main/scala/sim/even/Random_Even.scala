package main.scala.sim.even

/** 
 * GÈnÈrateur d'evenement
 */

trait Random_Even extends Runnable {
  val rateRandom = 1000
  val misfortuneVal = 13
  
    def run() {
	    while (true) {
	      var r = new scala.util.Random
	      if(r.nextInt(rateRandom) == misfortuneVal)
	        generateDisaster
	    }
    }
  
  /**
   * GÈnÈrateur de dÈsastre
   */
  def generateDisaster() {
    var r = new scala.util.Random
    var i:Int = r.nextInt(3)
    i match {
        case 0 => this.epidemic(r.nextInt(1000000))
        case 1 => this.disaster(r.nextInt(1000000))
        case _ => this.OtherAttack(r.nextInt(3))
      }
  }
  
  /**
   * Lance une Èpidemie
   * numberPeople est le nombre de personne 
   * qui sera toucher par l'Èpidemie
   */
  def epidemic(numberPeople:Int){
    
  }
  /**
   * Lance d'un dasastre
   * numberInfrastructure est le nombre de d'instrastructure  
   * qui sera toucher par le desestre
   */
  def disaster(numberInfrastructure:Int){
    
  }
  /**
   * Lance autre attaque
   * level aui sera le viveau de dangÈrisitÈ de l'attaque
   */
  def OtherAttack(level:Int){
    
  }
}