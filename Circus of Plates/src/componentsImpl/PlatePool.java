package componentsImpl;

import java.util.LinkedList;
import java.util.Queue;

import components.IDispenser;
import components.IItem;

/**
 * this class is responisble for pooling items and its creation , acts as a bin
 * for dispensed items as well and produces new Items on demand.
 * 
 * @author Ahmed Hamdy
 *
 */
public class PlatePool implements IDispenser<IItem> {

  protected Queue<IItem> bank;

  public PlatePool() {
    bank = new LinkedList<IItem>();
  }

  @Override
  public IItem getNewInstance() {
    if ( bank.isEmpty()) {
      //TODO change creation of plates
      IItem nwItem = new Plate();
      return nwItem;
    }
    IItem nwItem = bank.poll();
    return nwItem;
  }

  @Override
  public void dispose(IItem disposable) {
    bank.add(disposable);
    System.out.println("as");
  }

}
