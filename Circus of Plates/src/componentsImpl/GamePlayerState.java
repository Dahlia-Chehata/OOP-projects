package componentsImpl;

import java.awt.Dimension;
import java.awt.Point;

import components.IGameComponent;
import components.IGamePlayer;
import components.PlateState;
import components.PlayerState;

public class GamePlayerState implements PlayerState {

  private Point location;
  private Dimension size;
  private PlateState[] plates;
  private int score;
  private Class<?> implementingClass;

  
  public GamePlayerState(IGamePlayer source) {
    location = source.getActualPosition();
    size = source.getSize();
    score = source.getScore();
    implementingClass = source.getClass();
    plates = new PlateState[source.getPlates().length];
    for (int i = 0;i < source.getPlates().length;i++ ) {
      plates[i] = (PlateState)source.getPlates()[i].toState();
    }
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
    

  }

  @Override
  public IGameComponent capturedState() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PlateState[] getPlates() {
    return plates;
  }

  @Override
  public int getScore() {
    return score;
  }

}
