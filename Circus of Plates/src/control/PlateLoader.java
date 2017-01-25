package control;

import java.awt.Color;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import javax.swing.JFileChooser;
import components.IItem;

/**
 * This class should load instances of each concrete class as its interfaces the
 * classes should all be loaded from a configuration file. classes loaded should
 * be all classes implementing IItem
 * 
 * @author Dahlia
 *
 */
public class PlateLoader {

  public IItem getItem(JFileChooser fileChooser, Color color) {
    try {
      File selectedFile = fileChooser.getSelectedFile();
      java.net.URL url = selectedFile.toURI().toURL();
      URL[] urls = new URL[] { url };
      @SuppressWarnings("resource")
      ClassLoader loader = new URLClassLoader(urls);
      String className = selectedFile.getName();
      className = className.substring(0, className.length() - 5);
      Class<?> loadedClass = loader.loadClass("componentsImpl." + className);
      URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[] { new URL("file:" + File.pathSeparator) });
      Class<?> clz = loader.loadClass("componentsImpl." + className);
      return (IItem) clz.getDeclaredConstructor(Color.class).newInstance(color);
    } catch (ClassNotFoundException e) {
      System.out.println("Cant load from this path ");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
}
