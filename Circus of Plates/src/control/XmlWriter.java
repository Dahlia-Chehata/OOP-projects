package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import components.IGameController;
import componentsImpl.Game;

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
    //System.out.println(xml);
    try {
      FileWriter t = new FileWriter(writer);
      t.write(xml);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public IGameController load() {
    String xml = "";
    Scanner inp = null;
    try {
      inp = new Scanner(writer);
    } catch (FileNotFoundException e1) {
      
      e1.printStackTrace();
    }
    while (inp.hasNextLine())
      xml += inp.nextLine();
    Game toret = (Game) xstream.fromXML(xml);
    return toret;
  }
}
