package components;

import java.awt.Dimension;
import java.awt.Point;

public interface IGameComponent {
 
  /**
   * returns requested position of the component.
   * @return requested position of the component in form of Point.awt..
   */
  public Point requestedPosition();
  
  /**
   * returns actual position.
   * @return actual position in form of Point.awt.
   */
  public Point getActualPosition();
  
  /**
   * detects intersection of components.
   * @param other the other component to test intersection.
   * @return returns true iff there is an intersection.
   */
  public boolean intersects( IGameComponent other);
  
  /**
   * gets size of component.
   * @return size as dimension.awt.
   */
  public Dimension getSize();
}
