package componentsImpl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import components.IGameComponent;
import components.IGamePlayer;
import components.PlateState;
import components.PlayerState;
import items.BaseShape;

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
    BasePlayer six = (BasePlayer) toApply;
    six.setLocation(location);
    six.setSize(size);
    six.moveLeft();
    for(int i = plates.length-1;i>=0;i--) {
      Plate nplate = null;
      try {
         nplate = (Plate) plates[i].getClass().newInstance();
      } catch (InstantiationException | IllegalAccessException e) {
        nplate = new Plate(Color.red);
      }
      nplate.drop();
      plates[i].applyState(nplate);
      six.addPlate(nplate);

      six.getParent().add(nplate);
    }

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
  @Override
  public Class<?> getImplementation(){
    return implementingClass;
  }

}
