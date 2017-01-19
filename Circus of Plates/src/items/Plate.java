package items;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Plate extends BaseShape {
  protected int[]Xv;
  protected int[]Yv;
  
  /**
   * creates plate with given parameters.
   * @param location location of top left corner in form of Point.awt(x,y).
   * @param size size of top left corner in form of dimension.awt(w,h).
   * @param color color of component.
   */
  public Plate(Point location, Dimension size , Color color) {
    super( location,  size ,  color);
  
    generateVertices();
    
  }
  
  /**
   * generate vertices of plate.
   */
  protected void generateVertices() {
    Xv = new int[4];
    Yv = new int[4];
    Xv[0] = 0;
    Xv[1] = size.width / 4;
    Xv[2] = size.width * 3 / 4;
    Xv[3] = size.width;
    Yv[0] = Yv[3] = 0;
    Yv[1] = Yv[2] = size.height;
  }
  
  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    Graphics2D graphics2D = (Graphics2D) graphics;

    graphics2D.setColor(color);
    graphics2D.fillPolygon(Xv, Yv, 4);

    graphics2D.setColor(Color.black);
    graphics2D.drawPolygon(Xv, Yv, 4);
    
  }
  
  @Override
  public Rectangle getBounds() {
    return null;
  }
  
}
