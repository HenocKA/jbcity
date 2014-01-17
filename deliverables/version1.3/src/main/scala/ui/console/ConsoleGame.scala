package main.scala.ui.ConsoleUI
import main.scala.sim._
import main.scala.sim.infrastructure._
import main.scala.sim.network._

class ConsoleGame{

  var console = new ConsoleDisplay()
  var city = new City("",10,10)
  var mayor = new Mayor("",city,10000)
  val hab = new Population()
  
  
  def init(){
    print("City Name : ")
    val city_name = readLine()
    this.city = new City(city_name,10,10)
    city.init();
    print("Mayor Name : ")
    val mayor_name = readLine()
    this.mayor = new Mayor(mayor_name, city, 1000)
    this.display()
  }
  
  def load(){
    
  }
  
  def save(){
    //sauvegarde
    //exit
    sys.exit();
  }
  
  def create_inf(inf:Infrastructure){
    println("Enter line and row")
    try{
      val x = readInt()
      val y = readInt()
      this.mayor.add(inf,x,y)
      this.display()
    } catch {
      case ex: NumberFormatException => 
        println("Incorrect Choice !")
        this.display()
    }
  }
  
  def create_net(net:Network){
    println("Enter line and row")
    try{
      val x = readInt()
      val y = readInt()
      this.mayor.add(net,x,y)
      this.display()
    } catch {
      case ex: NumberFormatException => 
        println("Incorrect Choice !")
        this.display()
    }
  }
  
  def delete_inf(){
    println("Enter line and row")
    try{
      val x = readInt()
      val y = readInt()
      this.mayor.destroy(x,y)
      this.display()
    } catch {
      case ex: NumberFormatException => 
        println("Incorrect Choice !")
        this.display()
    }
  }
  
    def delete_net(){
    println("Enter line and row")
    try{
      val x = readInt()
      val y = readInt()
      this.mayor.destroy(x,y)
      this.display()
    } catch {
      case ex: NumberFormatException => 
        println("Incorrect Choice !")
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
        case 1 =>{ 
            console.displayInfrastructures()
            
            var infras =  InfrastructureFactory.listInfrastructures
            
            var j = -1
            
            while (j == -1) {
              j=readInt()
              if (j < 0 && j >= infras.length)
                j = -1
            }
            
            val inf = InfrastructureFactory (infras(j))
            create_inf (inf)
          }
          
        case 2 => 
          println("1: Electricity")
          println("2: Railway")
          println("3: Road")
          println("4: Water")
          var Netw =  NetworkFactory.listNetwork
            
            var j = -1
            
            while (j == -1) {
              j=readInt()
              if (j < 0 && j >= Netw.length)
                j = -1
            }
            
            val net = NetworkFactory (Netw(j))
            create_net (net)
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
  
  def menu_delete(){
    println("Entrer ligne puis colonne")
    try{
      val x = readInt()
      val y = readInt()
      this.mayor.destroy(x,y)
      this.display()
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
        case 1 => console.displayInfrastructures()
          i=readInt()
          delete_inf()
        case 2 => 
          println("1: Electricity")
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
        println("Incorrect choice !")
        this.display()
    }
  }
  
  def menu_impots(){
    try{
      println("Choisir infrastructure (ligne puis colonne)")
      var i = readInt()
      var j = readInt()
      this.mayor.getTax(i,j)
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
    println("1: Create Infrastructure")
    println("2: Destroy Infrastructure")
    println("3: Collect Taxes")
    println("4: Quit")
    println("0: Back")
    try{
      var i = readInt()
      i match {
        case 0 => this.display()
        case 1 => this.menu_create()
        case 2 => this.menu_delete()
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
    print("   " + "Mayor: " +this.mayor.name + "\t")
    print("City: "+this.city.name + "\t")
    println("Money: " + mayor.budget)
    
    print("   " + "Population: " + hab.nb + "\t")    
    print("Energy: " + city.energy + "\t")
    println("Water: " + city.water)
    
    print("   " + "Happiness: " + " %" + "\t")
    print("Criminality: " + " 0%" + "\t" )
    println("Pollution: " + " 0%" + "\n")
    //this.city.display();   
    console.displayCity(this.city);
    println()
  }

  def launch(){
    print("\033[2J")
    println("1: New Game")
    println("2: Load Game (TO DO)")
    var p = new ConsoleGame()
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
          println("quit (or q) or menu (or m)")
      } 	
    }
  
  }
  
}

