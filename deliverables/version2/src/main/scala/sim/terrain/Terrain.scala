package main.scala.sim.terrain

import main.scala.sim._

abstract class Terrain extends JBObjectNotConstructed {
}

class Mountain extends Terrain

class Valley extends Terrain

class Lake extends Terrain

class Grass extends Terrain