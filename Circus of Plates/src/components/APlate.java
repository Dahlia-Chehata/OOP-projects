package components;

import java.awt.Color;
import java.awt.Point;

public interface APlate {

  /**
   * returns actual position.
   * 
   * @return actual position in form of Point.awt.
   */
  public Point getActualPosition();

  /**
   * gets color of the component.
   * 
   * @return color of the component as Color.awt.
   */
  public Color getColor();

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

}
