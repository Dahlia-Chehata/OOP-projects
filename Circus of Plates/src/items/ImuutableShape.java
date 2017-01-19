package items;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public abstract class ImuutableShape extends BaseShape {

  /**
   * creates shape with given parameters.
   * @param location location of top left corner in form of Point.awt(x,y).
   * @param size size of top left corner in form of dimension.awt(w,h).
   * @param color color of component.
   */
  public ImuutableShape(Point location, Dimension size , Color color) {
    this.setLayout(null);
    this.location = location;
    super.setLocation(location);
    this.size = size;
    super.setSize(size);
    this.color = color;
  }


  @Override
  public final void setLocation(Point location) {
    throw new UnsupportedOperationException();
  }

  @Override
  public final void setSize(Dimension size) {
    throw new UnsupportedOperationException("shape is immutable");
  }


  @Override
  public final void setColor(Color color) {
    throw new UnsupportedOperationException("shape is immutable");
  }

  @Override
  public final void setBounds(Rectangle bounds) {
    throw new UnsupportedOperationException("shape is immutable");
  }
}
