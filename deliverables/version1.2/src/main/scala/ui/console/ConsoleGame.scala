package main.scala.ui.ConsoleUI
import main.scala.sim._
import main.scala.sim.infrastructure._

class ConsoleGame{

  var console = new ConsoleDisplay()
  var city = new City("",0,0)
  var mayor = new Mayor("",city,10000)
  val hab = new Population()
  
  
  def init(){
    println("City Name : ")
    val city_name = readLine()
    this.city = new City(city_name,10,10)
    city.init();
    println("Mayor Name : ")
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
      this.mayor.create(inf,x,y)
      this.display()
    } catch {
      case ex: NumberFormatException => 
        println("Incorrect Choice !")
        this.display()
    }
  }
  
  def delete_inf(inf:Infrastructure){
    println("Enter line and row")
    try{
      val x = readInt()
      val y = readInt()
      this.mayor.delete(inf,x,y)
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
        case 1 => console.displayInfrastructureType()
          	println("1: Commerciale")
          	println("2: divertissement")
          	println("3: Production")
          	println("4: Résidentiel")
          	println("5: Securité")
          	println("6: Sociale")
          	println("7: Transport")
          	
          	var j=readInt()
          	j match {
	            case 1 =>
	              val inf = new InfrastructureCommercial()
	              this.create_inf(inf)
	            case 2 =>
	              val inf = new InfrastructureEntertainment()
	              this.create_inf(inf)
	            case 3 =>
	              val inf = new InfrastructureProduction()
	              this.create_inf(inf)
	            case 4 =>
	              val inf = new InfrastructureResidential()
	              this.create_inf(inf)
	            case 5 =>
	              val inf = new InfrastructureSecurity()
	              this.create_inf(inf)
	            case 6 =>
	              val inf = new InfrastructureSocial()
	              this.create_inf(inf)
	            case 7 =>
	              val inf = new InfrastructureTransport()
	              this.create_inf(inf)
	            case _ => this.display()
          }	
        case 2 => 
          println("1: Electricity")
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
  
  def menu_delete(){
    println("Entrer ligne puis colonne")
    try{
      val x = readInt()
      val y = readInt()
      this.mayor.delete(x,y)
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
        case 1 => console.displayInfrastructureType()
          i=readInt()
          i match {
            case 1 =>
              val inf = new InfrastructureCommercial()
              this.delete_inf(inf)
            case 2 =>
              val inf = new InfrastructureEntertainment()
              this.delete_inf(inf)
            case 3 =>
              val inf = new InfrastructureProduction()
              this.delete_inf(inf)
            case 4 =>
              val inf = new InfrastructureResidential()
              this.delete_inf(inf)
            case 5 =>
              val inf = new InfrastructureSecurity()
              this.delete_inf(inf)
            case 6 =>
              val inf = new InfrastructureSocial()
              this.delete_inf(inf)
            case 7 =>
              val inf = new InfrastructureTransport()
              this.delete_inf(inf)
            case _ => this.display()
          }	
        case 2 => 
          println("1: ElectricitÃ©")
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
    println("1: CrÃ©ation infrastructure")
    println("2: Destruction infrastructure")
    println("3: RÃ©colter impots")
    println("4: Quitter jeu")
    println("0: Retour")
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
    println("Ville: "+this.city.name+"    "
            +"Maire: "+this.mayor.name)
    //this.city.display();   
    console.displayCity(this.city);
    println()
    print("nb_hab: "+hab.nb)
    print("  budget: "+mayor.budget)
    print("  energy: "+city.energy)
    println("  water: "+city.water)
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

