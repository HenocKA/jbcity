package main.scala.ui.console
import scala.util.Marshal
import scala.io.Source
import scala.collection.immutable
import java.io._
import main.scala.sim._
import main.scala.sim.even._
import main.scala.sim.infrastructure._
import main.scala.sim.network._
import scala.concurrent.ops._

class ConsoleGame extends scala.Serializable with RandomEven{
  var i = 0;
  var imax = 1;
  var console = new ConsoleDisplay()
  var cities:Array[City] = Array.ofDim(50)
  //var city = cities(0);
  var mayors: Array[Mayor] = Array.ofDim(50)
  //var mayor = mayors(0)
  var habs : Array[Population] = Array.ofDim(50)
  //var hab = habs(0)
  
  
  def init(){
    print("City Name : ")
    val city_name = readLine()
    cities(i) = new City(city_name,10,10)
    cities(i).init();
    print("Mayor Name : ")
    val mayor_name = readLine()
    mayors(i) = new Mayor(mayor_name, cities(i), 1000)
    habs(i) = new Population()
    this.display(this.i)
    //event()
  }
  
  // Lance une epidemie, le nombre de personnes touchées
  // est aléatoirement calculé
  override def epidemic(arg:Int){
    var r = new scala.util.Random
    this.habs(i).nb -= r.nextInt(this.habs(i).nb)
  }

  // Un desastre provoque la destruction 
  // aléatoire de #arg infrastructures
  override def disaster(arg:Int){
    var r = new scala.util.Random
    var nb = arg
    while(nb>0){
      var abs = r.nextInt(cities(i).abs)
      var ord = r.nextInt(cities(i).ord)
      if(cities(i).map(abs)(ord)!=null){
	cities(i).destroy(abs,ord)
	nb -= 1
      }
    }
  }

  //Fonction pour le lancement des fonctions aléatoires 
  //pour les évènements par un autre thread que le principal
  def event(){
    spawn{
      this.run()
    }
  }
  
  def load(i:Int){
  /*  var in = new FileInputStream("city.log")
    var bytes = Stream.continually(in.read).takeWhile(-1 !=).map(_.toByte).toArray
    var ville :City = Marshal.load(bytes)
    this.city = ville
    //this.city = Marshal.load[City](bytes)

    in = new FileInputStream("mayor.log")
    bytes = Stream.continually(in.read).takeWhile(-1 !=).map(_.toByte).toArray     
    //this.mayor = Marshal.load[Mayor](bytes)
    
    in = new FileInputStream("hab.log")
    bytes = Stream.continually(in.read).takeWhile(-1 !=).map(_.toByte).toArray
//    this.hab = Marshal.load(bytes)
*/
    this.display(this.i)
    
  }
  
  def save(i:Int){
    //sauvegarde
    //var city = this.cities(i)
    //var mayor = this.mayors(i)
    //var hab = this.habs(i)
    var out = new FileOutputStream("cities.log")
    out.write(Marshal.dump(cities))
    out.close
    out = new FileOutputStream("mayors.log")
    out.write(Marshal.dump(mayors))
    out.close
    out = new FileOutputStream("habs.log")
    out.write(Marshal.dump(habs))
    out.close
    //exit
    //sys.exit();
  }
  
  def create_inf(inf:Infrastructure){
    println("Enter line and row")
    try{
      val x = readInt()
      val y = readInt()
      this.mayors(i).add(inf,x,y)
      this.display(i)
    } catch {
      case ex: NumberFormatException => 
        println("Incorrect Choice !")
        this.display(i)
    }
  }
  
  
  def create_net(net:Network){
    println("Enter line and row")
    try{
      val x = readInt()
      val y = readInt()
      this.mayors(i).add(net,x,y)
      this.display(this.i)
    } catch {
      case ex: NumberFormatException => 
        println("Incorrect Choice !")
        this.display(this.i)
    }
  }
  
  def delete_inf(){
    println("Enter line and row")
    try{
      val x = readInt()
      val y = readInt()
      this.mayors(i).destroy(x,y)
      this.display(this.i)
    } catch {
      case ex: NumberFormatException => 
        println("Incorrect Choice !")
        this.display(this.i)
    }
  }
  
    def delete_net(){
    println("Enter line and row")
    try{
      val x = readInt()
      val y = readInt()
      this.mayors(i).destroy(x,y)
      this.display(this.i)
    } catch {
      case ex: NumberFormatException => 
        println("Incorrect Choice !")
        this.display(this.i)
    }
  }
  
// Créer une nouvelle ville avec un nouveau maire
  def menu_new(){
    this.imax +=1
    this.save(this.i)
    this.i += 1
    this.init();
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
              if (j < 0 || j >= infras.length){
                 println("Incorrect Choice !")
                console.displayInfrastructures()
                j = -1
              }
                
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
            
            val net = NetworkFactory (Netw(j-1))
            create_net (net)
        case 0 => this.display(this.i)
        case _ => 
          this.menu_create()
      }
    } catch {
      case ex: NumberFormatException => 
        println("Choix incorrecte!")
        this.display(this.i)
    }
  }
  
  def menu_delete(){
    println("Entrer ligne puis colonne")
    try{
      val x = readInt()
      val y = readInt()
      this.mayors(i).destroy(x,y)
      this.display(this.i)
    } catch {
      case ex: NumberFormatException => 
        println("Choix incorrecte!")
        this.display(this.i)
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
        this.display(this.i)
    }
  }
  
  def menu_impots(){
    try{
      println("Choisir infrastructure (ligne puis colonne)")
      var i = readInt()
      var j = readInt()
      this.mayors(this.i).getTax(i,j)
    } catch {
      case ex: NumberFormatException => 
        println("Choix incorrecte!")
        this.display(this.i)
    }
  }
  
  def menu_quit(){
    println("1: Enregistrer et Quitter (non fonctionnel)")
    println("2: Quitter sans enregistrer")
    try{
      var i = readInt()
      i match {
        case 1 => println("Enregistrement en cours..."); 
          this.save(this.i); sys.exit()
	  exit
        case 2 => println("Fermeture de la session");
          sys.exit(); exit
        case _ => 
	  println("1: Enregistrer et Quitter (non fonctionnel)")
          println("2: Quitter sans enregistrer")
          i=readInt()
	  i match {
	    case 1 => println("Enregistrement en cours...");
	    this.save(this.i); sys.exit()
	    case _ =>
	    sys.exit();
	  }

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
    println("5: Change city")
    println("0: Back")
    try{
      var i = readInt()
      i match {
        case 0 => this.display(this.i)
        case 1 => this.menu_create()
        case 2 => this.menu_delete()
        case 3 => this.menu_impots()
        case 4 => this.menu_quit()
	case 5 => this.display_cities()
        case _ => this.menu()
      }
    } catch {
      case ex: NumberFormatException => this.display(this.i)
    }
  }

  def display_cities(){
    for (j <- 0 to this.imax-1){
      println("("+j+")"+" City : " + this.cities(j).name + 
	      " Mayor : " + this.mayors(i).name +
	      " Population : "+ this.habs(i).nb )
    }
    try{
      var k = readInt()
      if (k<this.imax && k>=0){
	this.i = k
	this.load(k)
      }
      else {
	println("Veuillez entrer un entier supérieur à 0 et inférieur à "+this.imax)
	this.display(this.i)
      }
    } catch {
      case ex: NumberFormatException => this.display(0)
    }
  }

  
  def display(i:Int){
    var city = this.cities(i)
    var mayor = this.mayors(i)
    var hab = this.habs(i)
    print("\033[2J")
    print("   " + "Mayor: " +mayor.name + "\t")
    print("City: "+city.name + "\t")
    println("Money: " + mayor.budget)
    
    print("   " + "Population: " + hab.nb + "/" + hb.max"\t")    
    print("Energy: " + city.energy + "\t")
    println("Water: " + city.water)
    
    print("   " + "Happiness: " + hab.sat + "%" + "\t")
    print("Criminality: " + " 0%" + "\t" )
    println("Pollution: " + " 0%" + "\n")
    //this.city.display();   
    console.displayCity(city);
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
          p.load(this.i)
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
      println("Enter m or menu")
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
        else {
	  if (s=="n" || s=="N")
	    p.menu_new()
	  else 
            println("quit (or q) or menu (or m)")
	} 	
      }
      
    }
  } 
}

