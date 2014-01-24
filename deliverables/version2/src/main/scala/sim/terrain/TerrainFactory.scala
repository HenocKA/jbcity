package main.scala.sim.terrain


object TerrainFactory {
  var listTerrain = Vector("Mountain","Valley","Lake","Grass")
  
  def apply (typeTerr:String):Terrain = typeTerr match  {
    
    case "Mountain" =>  new Mountain 

    case "Valley" => new Valley 

    case "Lake" => new Lake 

    case "Grass" => new Grass
  }
}