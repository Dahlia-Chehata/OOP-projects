package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JPanel;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import components.GameState;
import components.IGameController;
import componentsImpl.Game;
import componentsImpl.GameStateImpl;

public class XmlWriter implements GameWriter{

  private File writer;
  XStream xstream;
  public XmlWriter() {
    xstream = new XStream(new DomDriver());
  }

  public XmlWriter(File writer) {
    xstream = new XStream(new DomDriver());
    setFile(writer);
  }

  public void setFile(File writer) {
    this.writer = writer;
  }

  public void save(IGameController game) {
    String xml = "";
    xml = xstream.toXML(game.toState());
    try {
      FileWriter t = new FileWriter(writer);
      t.write(xml);
      t.close();
     // System.out.println(xml + writer.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public IGameController load(JPanel gui) {
    String xml = "";
    Scanner inp = null;
    try {
      inp = new Scanner(writer);
    } catch (FileNotFoundException e1) {
      
      e1.printStackTrace();
    }
    while (inp.hasNextLine())
      xml += inp.nextLine();
    
    GameState toret = (GameStateImpl) xstream.fromXML(xml);

    System.out.println(toret.getplayers()[0].getLocation());
      gui.removeAll();
      Game.clearInstance();
      Game game = Game.getinstance(gui);
      toret.applyState(game);
    return game;
  }

}
