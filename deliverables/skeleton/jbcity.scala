//Déclaration des différentes classes, il manque à rajouter les attributs, les méthodes...

abstract class Map {
  def map(i:Int, j:Int):Array[String];
  def case_vide(i:Int, j:Int):Bool;
  def type_case(i:Int, j:Int):String;
}

abstract class Maire {
  val budjet:Int;
}

abstract class Habitant{
  val nbr:Int;
  //Fonctions pour augmenter ou diminuer le nombre d'habitants
  def diminue(i:Int);
  def augmente(i:Int);
}

abstract class Ville{
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

abstract class Infrastructure{

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
