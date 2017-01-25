package componentsImpl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import components.IGameComponent;
import components.IItem;
import components.PlateState;
import items.BaseShape;

public class GamePlateState implements PlateState {

  private Point location;
  private Dimension size;
  private int score;
  private Color color;
  private Class<?> implementingClass;
  
  public GamePlateState(IItem source) {
    location = source.getActualPosition();
    size = source.getSize();
    implementingClass = source.getClass();
    color = source.getColor();
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
  public void applyState(IGameComponent toApply) {
    BaseShape six = (BaseShape) toApply;
    six.setLocation(location);
    six.setSize(size);
    six.setColor(color);
    
  }

  @Override
  public IGameComponent capturedState() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Color getColor() {
    
    return color;
  }

}
