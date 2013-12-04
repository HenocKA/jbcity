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
    this.mayor = new mayor(mayor_name, city, 50)
    this.display()
  }
  
  def load(){
    
  }
  
  def save(){
    //sauvegarde
	//exit
    sys.exit();
  }
  
  def menu_create(){
    println("1: Infrastructure")
    println("2: Network")
    println("0: Quit")
    var i = readInt()
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
  }
  
  def menu_destroy(){
    println("1: Infrastructure")
    println("2: Network")
    println("0: Quit")
    var i = readInt()
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
  }
  
  def menu_impots(){
    println("Choisir infrastructure (ligne puis colonne)")
    var i = readInt()
    var j = readInt()
    this.mayor.get_impots(i,j)
  }
  
  def menu_quit(){
    println("1: Enregistrer et Quitter")
    println("2: Quitter sans enregistrer")
    var i = readInt()
    i match {
      case 1 => println("Enregistrement en cours..."); 
      this.save()
      case 2 => println("Fermeture de la session");
      sys.exit()
      case _ => println("1: Enregistrer et Quitter")
      println("2: Quitter sans enregistrer")
      i=readInt()
    }
  }
  
  def menu(){
    println("1: Création infrastructure")
    println("2: Destruction infrastructure")
    println("3: Récolter impots")
    println("4: Quitter jeu")
    var i = readInt()
    i match {
      case 1 => this.menu_create()
      case 2 => this.menu_destroy()
      case 3 => this.menu_impots()
      case 4 => this.menu_quit()
    } 
  }
  
  def display(){
    this.city.display();
    println("nb_hab: "+hab.nb)
    println("budget: "+mayor.budget)
    println("energy: "+city.energy)
    println("water: "+city.water)
  }
}

object partie {
  def main(args: Array[String]){
    print("\033[2J")
    println("1: nouveau jeu")
    println("2: charger jeu")
    var i = readInt()
    var p = new partie()
    //print("\033[2J")
    if (i==1){
      p.init()
    }		
    else{
      p.load()
    }
    while (true){
      var s = readLine()
      if (s=="menu"){
        print("\033[2J")
        p.menu();
        i = readInt();
        print("\033[2J")
        p.display()
      }
      else {
        print("\033[2J")
        if (s=="q" || s=="Q" || s=="quit" || s=="Quit"){
          p.menu_quit()
        }	
        else
          println("Test")
      } 	
    }	
    val infrastructure = new infrastructure()
    p.mayor.create(infrastructure, 2, 5)
    print("\033[2J")
    p.display()
  }
}