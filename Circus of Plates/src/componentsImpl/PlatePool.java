package componentsImpl;

import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import components.IDispenser;
import components.IItem;
import items.BaseShape;

/**
 * this class is responisble for pooling items and its creation , acts as a bin
 * for dispensed items as well and produces new Items on demand.
 * 
 * @author Ahmed Hamdy
 *
 */
public class PlatePool implements IDispenser<IItem> {

  protected Queue<IItem> bank;
  protected Color[] colors;

  public PlatePool() {
    bank = new LinkedList<IItem>();
    colors = new Color[5];
    colors[0] = Color.RED;

    colors[1] = Color.BLUE;

    colors[2] = Color.GREEN;

    colors[3] = Color.YELLOW;

    colors[4] = Color.MAGENTA;
  }

  @Override
  public synchronized IItem getNewInstance() {
    int threshold = new Random().nextInt(100);
    if ( bank.isEmpty()|| threshold > 60) {
      //TODO change creation of plates
      System.out.println("bolo");
      IItem nwItem = new Plate(colors[new Random().nextInt(5)]);
      return nwItem;
    }
    IItem nwItem = bank.poll();
    return nwItem;
  }

  @Override
  public void dispose(IItem disposable) {
    bank.add(disposable);
    BaseShape t = ((BaseShape)disposable);
    t.setLocation(new Point(-20,-10));
    t.getParent().remove(t);
  }

}
