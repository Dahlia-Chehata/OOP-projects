package componentsImpl;

import components.APlate;
import components.IGameComponent;
import components.IItem;
import components.PlateState;
import items.BaseShape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Plate extends BaseShape implements IItem, APlate {

  private Point reqPosition;

  public Plate(Color color) {
    super();
    this.setSize(new Dimension(25, 5));
    this.color = color;
  }

  @Override
  public Point requestedPosition() {
    if (reqPosition == null) {
      reqPosition = (Point) location.clone();
    }
    return reqPosition;
  }

  @Override
  public Point getActualPosition() {

    return this.location;
  }

  @Override
  public boolean intersects(IGameComponent other) {
    Rectangle temp = new Rectangle();
    temp.setLocation(other.getActualPosition());
    temp.setSize(other.getSize());

    Rectangle mt = new Rectangle();
    mt.setLocation(reqPosition);
    mt.setSize(size);
    // System.out.println(mt + " "+temp);
    return mt.intersects(temp);
  }

  @Override
  public void shift(int dx, int dy) {
    reqPosition = (new Point(location.x + dx, location.y + dy));

  }

  @Override
  public void placeOver(APlate nwItem) {
    int newy = -nwItem.getActualPosition().y + location.y - nwItem.getSize().height;
    nwItem.shift(0, newy);
    nwItem.acceptRequest();
    reqPosition = location;

  }

  @Override
  public void acceptRequest(Point requested) {
    setLocation(requested);
    reqPosition = requested;
  }

  @Override
  public void acceptRequest() {
    acceptRequest(reqPosition);
  }

  @Override
  public void declineRequest(Point requested) {
    reqPosition = location;

  }

  @Override
  public boolean contains(Point it) {
    if (it.x < reqPosition.x || it.x > reqPosition.x + size.width) {
      return false;
    }
    if (it.y < reqPosition.y || it.y > reqPosition.y + size.height) {
      return false;
    }
    return true;

  }

  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
//    int[] Xv;
//    int[] Yv;
//    Xv = new int[4];
//    Yv = new int[4];
//    Xv[0] = 0;
//    Xv[1] = size.width / 4;
//    Xv[2] = size.width * 3 / 4;
//    Xv[3] = size.width;
//    Yv[0] = Yv[3] = 0;
//    Yv[1] = Yv[2] = size.height;
//    Graphics2D graphics2D = (Graphics2D) graphics;
//
//    graphics2D.setColor(color);
//    graphics2D.fillPolygon(Xv, Yv, 4);
//
//    graphics2D.setColor(Color.black);
//    graphics2D.drawPolygon(Xv, Yv, 4);
  }

  @Override
  public void drop() {
    reqPosition = new Point(location.x, location.y + 10);
    // acceptRequest(reqPosition);

  }

  @Override
  public String toString() {
    return location.toString() + " " + size.toString() + " " + color;

  }

  @Override
  public PlateState toState() {
    return new GamePlateState(this);
  }

}
