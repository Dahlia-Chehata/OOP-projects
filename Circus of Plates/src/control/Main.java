package control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.*;

import componentsImpl.BasePlayer;
import componentsImpl.Game;
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
    bob.addObserver(mom);
    KeyPlayer moms = new KeyPlayer('j','l');

    bob.addObserver(moms);
    bob.attachListener(frame);
    frame.setVisible(true);
    frame.setSize(500, 500);
    JPanel bewa = new JPanel(null);
    bewa.setSize(frame.getSize());
    frame.add(bewa);
    Game yala = new Game(bewa);
    mom.setLocation(new Point(50,301));
    mom.moveLeft();
    moms.setLocation(new Point(350,301));
    moms.moveRight();
    yala.addPlayer(mom);
    yala.addPlayer(moms);
    frame.setDefaultCloseOperation(3);
    
  }
  

}

