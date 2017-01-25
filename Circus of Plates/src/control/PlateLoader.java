package control;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import components.IItem;
import componentsImpl.Plate;

/**
 * This class should load instances of each concrete class as its interfaces the
 * classes should all be loaded from a configuration file. classes loaded should
 * be all classes implementing IItem
 * 
 * @author Dahlia
 *
 */
public class PlateLoader {
  private String path;
  public PlateLoader(String path) {
    this.path = path;
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
  public Class<?> loader() {
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

  
  public IItem getItem(int index, Color color) {
    try {
      File selectedFile = new File(path);
      java.net.URL url = selectedFile.toURI().toURL();
      URL[] urls = new URL[] { url };
      @SuppressWarnings("resource")
      ClassLoader loader = new URLClassLoader(urls);
      String className = selectedFile.getName();
      className = className.substring(0, className.length() - 5);
      Class<?> clz = loader.loadClass("componentsImpl." + className);
      return (Plate) clz.getDeclaredConstructor(Color.class).newInstance(color);
    } catch (ClassNotFoundException e) {
      System.out.println("Cant load from this path ");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

public IItem getItsem(int index, Color color) {
  try {
    File selectedFile = new File(path);
    java.net.URL url = selectedFile.toURI().toURL();
    URL[] urls = new URL[] { url };
    @SuppressWarnings("resource")
    ClassLoader loader = new URLClassLoader(urls);
    System.out.println(FileReader(path).get(index));
    Class<?> clz = loader.loadClass("componentsImpl."+FileReader(path).get(index));
    return (Plate) clz.getDeclaredConstructor(Color.class).newInstance(color);
  } catch (ClassNotFoundException e) {
    System.out.println("Cant load from this path ");
  } catch (Exception e) {
    e.printStackTrace();
  }
  return null;
}
public static void main(String args[]) {
  PlateLoader pld = new PlateLoader("plates.config");
  JFrame frame = new JFrame();
  frame.setLayout(null);
  JPanel pan = new JPanel(null);
  Plate plate= (Plate) pld.getItsem(1, Color.red);
  //System.out.println(plate.getClass());
  pan.add(plate);
  pan.setBounds(0, 0, 200, 200);
  frame.add(pan);
  frame.setVisible(true);
  frame.setSize(200, 200);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
