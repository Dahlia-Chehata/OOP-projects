package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import components.IGameMaster;
import componentsImpl.Game;

/**
 * class responsible for building the GUI of the game.
 * 
 * @author Helana
 *
 */
public class Guibuilder extends JFrame {

  public JPanel gui;;
  private JFrame frame;
  private GuiLinker c ;

  public Guibuilder() {

    gui = new JPanel(null);
    gui.setSize(new Dimension(500,500));
    gui.setLocation(0, 100);
    this.setBounds(0, 0, 600, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    JMenuBar menubar = new JMenuBar();
    menubar.setBounds(0, 0, 550, 25);
    this.add(menubar);
    c = new GuiLinker(this);
    JMenu game = new JMenu("Game");
    this.add(gui);
    JMenu file = new JMenu("File");

    JMenu players = new JMenu("Players");
    menubar.add(game);
    menubar.add(file);
    menubar.add(players);
    JMenuItem adpl = new JMenuItem("Add AD player");
    adpl.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        
         
          c.addPlayer(1);
          
      }
    });
    players.add(adpl);
    JMenuItem lrpl = new JMenuItem("Add LR player");
    lrpl.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        
         
          c.addPlayer(2);
        
      }
    });
    players.add(lrpl);
    JMenuItem mopl = new JMenuItem("Add Mouse player");
    mopl.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        
         
          c.addPlayer(3);
        
      }
    });
    players.add(mopl);
    JMenuItem save = new JMenuItem("Save");
    save.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(
            getComponent(0)) == JFileChooser.APPROVE_OPTION) {
          File file = fileChooser.getSelectedFile();
          // System.out.println(file);
          c.setFile(file);
          c.save();
        }
      }
    });
    file.add(save);

    JMenuItem load = new JMenuItem("Load");
    load.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        // c.load();
      }
    });
    file.add(load);

    JMenuItem run = new JMenuItem("Run");
    run.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        c.run();
        // System.out.println("run");
      }
    });
    game.add(run);
    JMenuItem pause = new JMenuItem("Pause");
    pause.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        c.pause();
        // System.out.println("pause");
      }
    });
    game.add(pause);
    JMenuItem restart = new JMenuItem("Restart");
    restart.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        
        c.startGame();
      }
    });
    game.add(restart);
    JMenuItem end = new JMenuItem("End");
    end.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent arg0) {
        //c.pause();
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.exit(0);
      }
    });
    game.add(end);

  }

  public static void main(final String[] args) {
    Guibuilder window = new Guibuilder();
    window.setVisible(true);
  }

}
