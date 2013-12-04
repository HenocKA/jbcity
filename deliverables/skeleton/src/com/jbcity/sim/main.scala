//package com.jbcity.sim
import com.jbcity.sim._
import java.io._

class partie{
  var city = new city("",0,0)
  var mayor = new mayor("",city,0)
  val hab = new population()
  
  
  def init(){
    println("Entrer le nom de la ville")
    val city_name = readLine()
    this.city = new city(city_name,10,10)
    city.init();
    println("Entrer le nom du maire")
    val mayor_name = readLine()
    this.mayor = new mayor(mayor_name, city, 1000)
    this.display()
  }
  
  def load(){
    
  }
  
  def save(){
    //sauvegarde
	//exit
    sys.exit();
  }
  
  def create_inf(inf:infrastructure){
    println("Entrer ligne puis colonne")
    try{
    val x = readInt()
    val y = readInt()
    this.mayor.create(inf,x,y)
    this.display()
    } catch {
        case ex: NumberFormatException => 
        println("Choix incorrecte!")
        this.display()
    }
  }
  
  def menu_create(){
    println("1: Infrastructure")
    println("2: Network")
    println("0: Quit")
    var i = readInt()
    try{
    i match {
      case 1 => 
        println("1: Commerce")
        println("2: Loisir")
        println("3: Production")
        println("4: Résidentiel")
        println("5: Sécurité")
        println("6: Social")
        println("7: Transport")
        i=readInt()
        i match {
          case 1 =>
          val inf = new infras_commercial()
          this.create_inf(inf)
          case 2 =>
          val inf = new infras_entertainment()
          this.create_inf(inf)
          case 3 =>
          val inf = new infras_production()
          this.create_inf(inf)
          case 4 =>
          val inf = new infras_residential()
          this.create_inf(inf)
          case 5 =>
          val inf = new infras_security()
          this.create_inf(inf)
          case 6 =>
          val inf = new infras_social()
          this.create_inf(inf)
          case 7 =>
          val inf = new infras_transport()
          this.create_inf(inf)
          case _ => this.display()
    	}	
      case 2 => 
        println("1: Electricité")
        println("2: Water")
        println("3: Railway")
      case 0 => this.display()
      case _ => 
        this.menu_create()
    }
    } catch {
      case ex: NumberFormatException => 
        println("Choix incorrecte!")
        this.display()
    }
  }
  
  def menu_destroy(){
    println("1: Infrastructure")
    println("2: Network")
    println("0: Quit")
    var i = readInt()
    try{
    i match {
      case 1 => 
        println("1: Commerce")
        println("2: Loisir")
        println("3: Production")
        println("4: Résidentiel")
        println("5: Sécurité")
        println("6: Social")
        println("7: Transport")
      case 2 => 
        println("1: Electricité")
        println("2: Water")
        println("3: Railway")
      case 0 => println("retour")
      case _ => 
        println("1: Infracture")
        println("2: Network")
        i=readInt()
    }
    } catch {
      case ex: NumberFormatException => 
        println("Choix incorrecte!")
        this.display()
    }
  }
  
  def menu_impots(){
    try{
    println("Choisir infrastructure (ligne puis colonne)")
    var i = readInt()
    var j = readInt()
    this.mayor.get_impots(i,j)
    } catch {
        case ex: NumberFormatException => 
        println("Choix incorrecte!")
        this.display()
    }
  }
  
  def menu_quit(){
    println("1: Enregistrer et Quitter (non fonctionnel)")
    println("2: Quitter sans enregistrer")
    try{
    var i = readInt()
    i match {
      case 1 => println("Enregistrement en cours..."); 
      this.save()
      case 2 => println("Fermeture de la session");
      sys.exit()
      case _ => println("1: Enregistrer et Quitter (non fonctionnel)")
      println("2: Quitter sans enregistrer")
      i=readInt()
    }
    } catch {
      case ex: NumberFormatException => this.menu_quit()
    }
  }
  
  def menu(){
    println("1: Création infrastructure")
    println("2: Destruction infrastructure")
    println("3: Récolter impots")
    println("4: Quitter jeu")
    println("0: Retour")
    try{
    var i = readInt()
    i match {
      case 0 => this.display()
      case 1 => this.menu_create()
      case 2 => this.menu_destroy()
      case 3 => this.menu_impots()
      case 4 => this.menu_quit()
      case _ => this.menu()
    }
    } catch {
      case ex: NumberFormatException => this.display()
    }
  }
  
  def display(){
    print("\033[2J")
    println("Ville: "+this.city.name+"    "
        +"Maire: "+this.mayor.name)
    this.city.display();
    println()
    print("nb_hab: "+hab.nb)
    print("  budget: "+mayor.budget)
    print("  energy: "+city.energy)
    println("  water: "+city.water)
  }
}

object partie {
  def main(args: Array[String]){
    print("\033[2J")
    println("1: nouveau jeu")
    println("2: charger jeu (non fonctionnel)")
    var p = new partie()
    try {
    var i = readInt()
    //print("\033[2J")
    if (i==1){
      p.init()
    }		
    else{
      if (i==2)
        p.load()
      else {
        println("Choix possible: 1 ou 2")
        println("Fermeture...")
        sys.exit()
      }
    }
    } catch {
      case ex: NumberFormatException => 
        println("Choix possible: 1 ou 2")
        println("Fermeture...")
        sys.exit()
    }
    while (true){
      var s = readLine()
      if (s=="menu" || s=="m"){
        //print("\033[2J")
        p.menu();
        //i = readInt();
        //p.display()
      }
      else {
        //print("\033[2J")
        if (s=="q" || s=="quit"){
          p.menu_quit()
        }	
        else
          println("Tappez quit (or q) or menu (or m)")
      } 	
    }
  }
}