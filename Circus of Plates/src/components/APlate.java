package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public interface APlate extends IItem {

  

  /**
   * shifts plate by difference distance.
   * 
   * @param dx
   *          difference in x.
   * @param dy
   *          difference in y.
   */
  public void shift(int dx, int dy);

  /**
   * places over another plate.
   * @param under the plate base.
   */
  
  public void placeOver(APlate under);

  

  public boolean contains(Point reqPosition);
  

}
