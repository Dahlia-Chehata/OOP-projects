package componentsImpl;

import components.IDispenser;
import components.IItem;

/**
 * this class is responisble for pooling items and its creation , acts as a bin for dispensed
 * items as well and produces new Items on demand.
 * @author Ahmed Hamdy
 *
 */
public class PlatePool implements IDispenser<IItem> {

  @Override
  public IItem getNewInstance() {
   
    return null;
  }

  @Override
  public void dispose(IItem disposable) {
    
    
  }

}
