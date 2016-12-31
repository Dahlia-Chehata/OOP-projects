package gui;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JComponent;

import java.awt.Color;

import items.BaseShape;
import items.Plate;
import listeners.GuiKeyListener;
import listeners.GuiMouseListener;

public class Main {

  public static void main(String args[]){
    testClass alpha = new testClass();
    alpha.setLayout(null);;
    JComponent omak = new Plate(new Point(50,100),new Dimension(60,20),Color.red);
    omak.setLocation(new Point(0,0));
    alpha.add(omak);
    
  }
}
