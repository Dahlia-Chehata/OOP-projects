package items;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class ImuutableShape extends BaseShape{

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
    throw new UnsupportedOperationException();
  }

  @Override
  public final void setBounds(Rectangle bounds) {
    throw new UnsupportedOperationException();
  }
}
