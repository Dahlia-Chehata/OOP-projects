package componentsImpl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PlatePolygon extends Plate {

  public PlatePolygon(Color color) {
    super(color);
    
  }

  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    int[] Xv;
    int[] Yv;
    Xv = new int[4];
    Yv = new int[4];
    Xv[0] = 0;
    Xv[1] = size.width / 4;
    Xv[2] = size.width * 3 / 4;
    Xv[3] = size.width;
    Yv[0] = Yv[3] = 0;
    Yv[1] = Yv[2] = size.height;
    Graphics2D graphics2D = (Graphics2D) graphics;

    graphics2D.setColor(color);
    graphics2D.fillPolygon(Xv, Yv, 4);

    graphics2D.setColor(Color.black);
    graphics2D.drawPolygon(Xv, Yv, 4);
  }

}
