package componentsImpl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class PlateEllipse extends Plate {

  PlateEllipse(Color color) {
    super(color);
    this.setSize(new Dimension(25, 5));
  }

  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    Graphics2D graphics2D = (Graphics2D) graphics;

    graphics2D.setColor(color);
    graphics.fillOval(0, 0, 5, 25);

    graphics2D.setColor(Color.black);
    graphics2D.drawOval(0, 0, 5, 25);
  }

}
