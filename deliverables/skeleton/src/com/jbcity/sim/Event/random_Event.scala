package com.jbcity.Event

class random_Event {
	//D�claration des variables
	var typeEvent:String;
	var dead:Int = 0;
	var wounded:Int = 0;
	var missing:Int = 0;
	var level:Int = 0;
  	//D�claration des Getters
	abstract def getLevel:Int ;
	abstract def getTime:Int ;
	abstract def getDead:Int ;
	abstract def getWounded:Int ;
	abstract def getType:String ;
	abstract def getMissing:Int ;
	//D�claration des Setters
	abstract def setLevel = (level:Int) {this.level = level} 
	abstract def setTime = (time:Int) {this.time = time}
	abstract def setDead = (dead:Int) {this.dead = dead}
	abstract def setWounded = (wounded:Int) {this.wounded = wounded}
	abstract def setType = (typeEvent:String) {this.typeEvent = typeEvent}
	abstract def setMissing = (missing:Int) {this.missing = missing}
	
}