//Déclaration des différentes classes, il manque à rajouter les attributs, les méthodes...

abstract class Map {
  def map(x:Int, y:Int):Array[String];
  def is_empty(i:Int, j:Int):Bool;
  def what(i:Int, j:Int):String;
}

abstract class Maire {
  var budget:Int;
}

abstract class Habitant{
  var nbr:Int;
  //Fonctions pour augmenter ou diminuer le nombre d'habitants
  def decrease(i:Int);
  def increase(i:Int);
}

abstract class City extends Map{
  var map:Map;
  val name:String;
}

abstract class Random_Event{
  
}

abstract class Epidemie extends Random_Event{
  val id_epi:Int;
}

abstract class Catastrophe extends Random_Event{
  val id_cata:Int;
}

abstract class Attaque extends Random_Event{
  val id_atq:Int;
}

abstract class Reseau{
  
}

abstract class Reseau_elec extends Reseau{
  val id_elec:Int;
}

abstract class Reseau_rout extends Reseau{
  val id_rout:Int;
}

abstract class Reseau_ferr extends Reseau{
  val id_ferr:Int;
}

abstract class Trancon_elec {
  
}

abstract class Trancon_rout {

}

abstract class Trancon_ferr{

}

trait Infrastructure{
  def position(): (x:Int, y:Int)
  
}

abstract class Transport extends Infrastructure{
  
}

abstract class Securite extends Infrastructure{

}

abstract class Industrie extends Infrastructure{

}

abstract class Commerce extends Infrastructure{

}

abstract class Oeuvre extends Infrastructure{

}

abstract class Habitation extends Infrastructure{

}

abstract class Loisir extends Infrastructure{

}

abstract class Impot {

}

abstract class Season_Event{

}
