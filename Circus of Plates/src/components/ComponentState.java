package components;

import java.awt.Dimension;
import java.awt.Point;

public interface ComponentState extends Momento<IGameComponent> {

  public Point getLocation();

  public Dimension getSize();
}
