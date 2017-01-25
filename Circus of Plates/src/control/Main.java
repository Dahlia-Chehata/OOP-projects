package control;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import components.IGameMaster;
import componentsImpl.BasePlayer;
import componentsImpl.Game;
import componentsImpl.KeyPlayer;
import componentsImpl.MousePlayer;
import componentsImpl.Plate;
import listeners.GuiKeyListener;
import listeners.GuiMouseListener;

/**
 * class responisble for running classes only.
 * @author Ahmed Hamdy
 *
 */
public class Main {
  
  public static void main (String args[]) {
    JFrame frame =new JFrame();
    KeyPlayer mom = new KeyPlayer(KeyPlayer.leftCharCode,KeyPlayer.rightCharCode);
    BasePlayer.shift = 10;
    KeyPlayer moms = new KeyPlayer(KeyPlayer.leftArrowCode,KeyPlayer.rightArrowCode);
   
    MousePlayer kok = new MousePlayer();

    frame.setVisible(true);
    frame.setSize(500, 600);
    JPanel bewa = new JPanel(null);
    bewa.setLocation(new Point(0,100));
    bewa.setSize(frame.getSize());
    frame.setLayout(null);
    frame.add(bewa);

    Game yala = new Game(bewa);
    //kok.moveRight();
    mom.getEvent().attachListener(frame);

    kok.getEvent().attachListener(frame);
    yala.addPlayer(kok);
    yala.addPlayer(mom);
    File f= new File("temp.xml");
    try {
      f.createNewFile();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    //yala.save(f);

    JButton bu = new JButton();
    bu.setBounds(new Rectangle(0,0,50,20));
    frame.add(bu);
    bu.addActionListener(new Main().new Pause(yala));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  }
  private class Pause implements ActionListener {
    IGameMaster c;
    boolean shit=false;
    public Pause(IGameMaster c) {
      this.c=c;
    }
    public void actionPerformed(final ActionEvent event) {
      
        if(!shit)
        c.pause();
        else
          c.run();
        shit = !shit;
        // System.out.println("pause");
      }
    }
  

}

