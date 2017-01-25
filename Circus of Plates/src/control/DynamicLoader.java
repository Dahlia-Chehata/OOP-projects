package control;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JPanel;
import components.IDispenser;
import components.IGameMaster;
import components.IGamePlayer;
import components.IItem;
import components.Iterator;

/**
 * This class should load instances of each concrete class as its interfaces the
 * classes should all be loaded from a configuration file. classes loaded should
 * be IGamePlayer, IGame Master, IDispenser , Iterator
 * 
 * @author Dahlia
 *
 */

public class DynamicLoader {

  public DynamicLoader() {

  }

  public List<String> FileReader(String FileName) {
    File file = new File(FileName);

    try {
      List<String> lines;
      lines = Files.readAllLines(Paths.get(file.toURI()), Charset.forName("UTF-8"));
      return lines;
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;

  }

  public Class<?> loader(String path) {
    try {
      File file = new File(path);
      java.net.URL url = file.toURI().toURL();
      URL[] urls = new URL[] { url };
      @SuppressWarnings("resource")
      ClassLoader loader = new URLClassLoader(urls);
      String className = file.getName();
      className = className.substring(0, className.length() - 5);
      Class<?> loadedClass = loader.loadClass("componentsImpl." + className);
      URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[] { new URL("file:" + File.pathSeparator) });
      Class<?> clz = loader.loadClass("componentsImpl." + className);
      return clz;
    } catch (ClassNotFoundException e) {
      System.out.println("Cant load from this path ");
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;

  }

  public IGamePlayer getPlayer() {

    String path = FileReader("Paths.txt").get(0);
    try {
      return (IGamePlayer) loader(path).newInstance();
    } catch (InstantiationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public IGameMaster getGame(JPanel gui) {

    String path = FileReader("Paths.txt").get(1);
    try {

      return (IGameMaster) loader(path).getDeclaredConstructor(JPanel.class).newInstance(gui);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public IDispenser<IItem> getDispenser() {

    String path = FileReader("Paths.txt").get(2);
    try {
      return (IDispenser<IItem>) loader(path).newInstance();
    } catch (InstantiationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public Iterator<IItem> getIterator() {

    String path = FileReader("Paths.txt").get(3);
    try {
      return (Iterator<IItem>) loader(path).newInstance();
    } catch (InstantiationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  

}
