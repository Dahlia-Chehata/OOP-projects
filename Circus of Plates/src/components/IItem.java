package components;

import java.awt.Color;

public interface IItem extends IGameComponent {

  /**
   * gets color of the component.
   * @return color of the component as Color.awt.
   */
  public Color getColor();
  
  public void drop();
  

  public PlateState toState();
}
