package componentsImpl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Properties;

import components.APlate;
import components.ICollection;
import components.IGameComponent;
import components.IGamePlayer;
import components.IItem;
import components.Iterator;
import gui.Observer;
import items.BaseShape;

/**
 * This class should impement basic operations of a player and is considered as
 * a part of the game itself, calculating scores and defining the set to
 * implement with driving events and defining operations of intersection and
 * validation and plate acquisition and classification.
 * 
 * @author Ahmed Hamdy
 *
 */
@SuppressWarnings("serial")
public class BasePlayer extends BaseShape implements IGamePlayer {

  private int score;
  private Point reqPosition;
  private Iterator<APlate> acquired;
  public static int shift;

  protected BasePlayer() {
    score = 0;
    acquired = new Iteratee<APlate>(); // TODO use dynamic linkage
    reqPosition =new Point();
    location = new Point();
  }

  @Override
  public Point requestedPosition() {
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
    Iterator<APlate> it = acquired;
    if (it.getval() != null)
      while (it != null) {
        if (it.getval().intersects(other)) {
          System.out.println(it.getval().getActualPosition() + " " + other.getActualPosition());

          acquired.reset();
          return true;
        }
        it = it.getNext();
      }
    acquired.reset();

    Rectangle mt = new Rectangle();
    mt.setLocation(reqPosition);
    mt.setSize(size);

    return mt.intersects(temp);

  }

  @Override
  public int getScore() {
    return score;
  }

  @Override
  public void incrementScore() {
    score++;
  }

  @Override
  public void decrementScore() {
    score--;
  }

  @Override
  public void addPlate(APlate nwItem) {
    // nwItem = (APlate)nwItem;
    Iterator<APlate> it = acquired;
    if (it.getval() != null)
      while (it != null) {

        System.out.println(it.getval() + " "+nwItem);
        if (nwItem.intersects(it.getval()) || it.getval().intersects(nwItem)) {

          it.getval().placeOver(nwItem);

          acquired.insert(nwItem);
          acquired.reset();
          return;
        }
        it = it.getNext();
      }
    int newy = -nwItem.getActualPosition().y + location.y - nwItem.getSize().height;
    nwItem.shift(0, newy);
    nwItem.acceptRequest();
    acquired.insert(nwItem);
    acquired.reset();
    return;

  }

  @Override
  public void acceptRequest(Point requested) {
    Iterator<APlate> it = acquired;
    Point mainShift = new Point(requested.x - location.x, requested.y - location.y);
    if (it.getval() != null)
      while (it != null) {
        APlate shit = it.getval();
        shit.acceptRequest(
            new Point(shit.getActualPosition().x + mainShift.x, 
                (shit.getActualPosition().y + mainShift.y)));
        it = it.getNext();
      }
    acquired.reset();
    setLocation(requested);

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
  public APlate[] getPlates() {
    return null;

  }

  public void moveLeft() {
    reqPosition = new Point(location.x - shift, location.y);
   // acceptRequest(reqPosition);

  }

  public void moveRight() {
    reqPosition = new Point(location.x + shift, location.y);
    //acceptRequest(reqPosition);
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

  public void clearPlates(Color ofColor) {
    // TODO
  }

  public void clearPlates() {
    // TODO
  }

}
