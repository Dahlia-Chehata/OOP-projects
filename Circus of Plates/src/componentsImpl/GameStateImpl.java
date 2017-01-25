package componentsImpl;

import java.awt.Dimension;
import java.awt.Point;

import components.GameState;
import components.IGameController;
import components.PlateState;
import components.PlayerState;

public class GameStateImpl implements GameState {
  private long time;
  private PlayerState[] players;
  private PlateState[] plates;
  private int level;
  private Class<?> implementingClass;

  public GameStateImpl(IGameController source) {
    time = source.getTime();
    level = source.getLevel();
    implementingClass= source.getClass();
   // plates = new PlateState[source.getplates().length];
    players = new PlayerState[2];
//    for (int i = 0;i < source.getplates().length;i++ ) {
//      plates[i] = (PlateState)source.getplates()[i].toState();
//    }
    
    players[0] = source.getPlayer(0).toState();
    players[1] = source.getPlayer(1).toState();
  }
  
  @Override
  public void applyState(IGameController toApply) {
    

  }

  @Override
  public IGameController capturedState() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PlateState[] getplates() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PlayerState[] getplayers() {
    return players;
  }

  @Override
  public int getTime() {

    return (int)time;
  }

  @Override
  public int getLevel() {
   
    return level;
  }

}
