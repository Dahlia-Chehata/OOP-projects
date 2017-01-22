package control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.*;

import componentsImpl.BasePlayer;
import componentsImpl.KeyPlayer;
import componentsImpl.Plate;
import listeners.GuiKeyListener;

/**
 * class responisble for running classes only.
 * @author Ahmed Hamdy
 *
 */
public class Main {
  
  public static void main (String args[]) {
    JFrame frame =new JFrame();
    GuiKeyListener bob = new GuiKeyListener();
    KeyPlayer mom = new KeyPlayer('a','d');
    BasePlayer.shift = 10;
    Plate boba = new Plate();
    boba.setLocation(new Point(150,290));
    boba.setSize(new Dimension(25,5));
    boba.setColor(Color.RED);
    boba.drop();
    Plate bobs = new Plate();
    bobs.setLocation(new Point(154,284));
    bobs.setSize(new Dimension(25,5));
    bobs.setColor(Color.blue);
    bobs.drop();
    bob.addObserver(mom);
    mom.setLocation(new Point(100,300));
    mom.setSize(new Dimension(100,20));
    mom.setColor(Color.green);
    mom.moveLeft();
    mom.moveRight();
    
    mom.addPlate(boba);
    mom.addPlate(bobs);
   // System.out.println(mom.intersects(bobs));
    JPanel temo = new JPanel(null);
    temo.setSize(new Dimension(500,500));
    temo.add(mom);
    temo.add(boba);
    temo.add(bobs);
    //mom.addPlate(boba);
    frame.add(temo);
    bob.attachListener(frame);
    frame.setVisible(true);
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(3);
    
  }
  

}

