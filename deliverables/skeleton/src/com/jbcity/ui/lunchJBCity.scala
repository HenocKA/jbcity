package com.jbcity.ui

import swing._
import scala.swing.event.ButtonClicked

object lunchJBCity extends SimpleSwingApplication {
  def top = new MainFrame() {
    title = "JBCity GAME"
    size= new Dimension (1000,1000)
    
    val Load = new Button {
      text = "Charger le jeux"
    }
    val label = new Label {
      text = "Lancemenrt de JBCity..."
    }	
    
    val labName = new Label{text = "Votre nom"}
    val txtName = new TextField("")
    
    val labCity = new Label{text = "Nom de votre ville"}
    val txtNameCity = new TextField("")
    
    val closeBtn   = new Button(Action("Fermer") {this.dispose()})

    
    contents = new BoxPanel(Orientation.Vertical) {
      contents += new FlowPanel{
        labName
        txtName
      }
      contents += Load
      contents += label
      contents += closeBtn
      border = Swing.EmptyBorder(30, 30, 10, 30)
    }
    listenTo(Load)
    var nClicks = 0
    reactions += {
      case ButtonClicked(e) =>
        nClicks += 1
        label.text = "Le jeux va etre charge dans un instant...: "+ nClicks
    }
  }
}