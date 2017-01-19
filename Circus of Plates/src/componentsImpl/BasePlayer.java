package componentsImpl;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Properties;

import components.IGameComponent;
import components.IGamePlayer;
import components.IItem;
import gui.Observer;
import items.BaseShape;
/**
 * This class should impement basic operations of a player and is considered as a part of 
 * the game itself, calculating scores and defining the set to implement with 
 * driving events and defining operations of intersection and validation and plate acquisition
 * and classification.
 * @author Ahmed Hamdy
 *
 */
public class BasePlayer extends BaseShape implements IGamePlayer, Observer {

  @Override
  public Point requestedPosition() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Point getActualPosition() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean intersects(IGameComponent other) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Dimension getSize() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void handleEvent() {
    // TODO Auto-generated method stub

  }

  @Override
  public void handleEvent(Properties eventType) {
    // TODO Auto-generated method stub

  }

  @Override
  public int getScore() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void incrementScore() {
    // TODO Auto-generated method stub

  }

  @Override
  public void decrementScore() {
    // TODO Auto-generated method stub

  }

  @Override
  public void addPlate(IItem nwItem) {
    // TODO Auto-generated method stub

  }

  @Override
  public IItem[] getPlates() {
    // TODO Auto-generated method stub
    return null;
  }

}
