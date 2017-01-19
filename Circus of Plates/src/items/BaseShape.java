package items;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public abstract class BaseShape extends JComponent {
  protected Point location;
  protected Dimension size;
  protected Color color;

  public BaseShape() {
    this.setLayout(null);
    this.setVisible(true);
  }

  /**
   * creates shape with given parameters.
   * @param location location of top left corner in form of Point.awt(x,y).
   * @param size size of top left corner in form of dimension.awt(w,h).
   * @param color color of component.
   */
  public BaseShape(Point location, Dimension size, Color color) {
    this.setLayout(null);
    setLocation(location);
    setSize(size);
    this.color = color;
  }

  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
  }

  @Override
  public Point getLocation() {
    return location;
  }

  @Override
  public Dimension getSize() {
    return size;
  }

  @Override
  public void setLocation(Point location) {
    this.location = location;

    super.setLocation(location);
  }

  @Override
  public void setSize(Dimension size) {
    this.size = size;

    super.setSize(size);
  }

  @Override
  public boolean contains(Point point) {
    throw new UnsupportedOperationException();
  }

  /**
   * sets color of the shape.
   * 
   * @param color
   *          f the shape.
   * @throws NullPointerException
   *           if color parameter is null.
   */
  public void setColor(Color color) throws NullPointerException {
    if (color == null) {
      throw new NullPointerException();
    }
    this.color = color;
  }

  /**
   * gets color of the shape.
   * 
   * @return color of the shape.
   */
  public Color getColor() {
    return color;
  }

  @Override
  public void setBounds(Rectangle bounds) {
    setLocation(bounds.getLocation());
    setSize(bounds.getSize());
  }
}
