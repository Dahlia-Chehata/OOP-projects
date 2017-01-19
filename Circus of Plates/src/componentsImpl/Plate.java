package componentsImpl;

import java.awt.Point;

import components.APlate;
import components.IGameComponent;
import components.IItem;
import items.BaseShape;

public class Plate extends BaseShape implements IItem,APlate {

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
  public void shift(int dx, int dy) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void placeOver(APlate under) {
    // TODO Auto-generated method stub
    
  }

}
