package componentsImpl;

import java.awt.Dimension;
import java.awt.Point;

import components.GameState;
import components.IGameController;
import components.IGameMaster;
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
    implementingClass = source.getClass();
    players = new PlayerState[2];

    players[0] = source.getPlayer(0).toState();
    players[1] = source.getPlayer(1).toState();
  }

  @Override
  public void applyState(IGameMaster toApply) {
    BasePlayer p1 = null, p2 = null;
    try {
      p1 = (BasePlayer) players[0].getImplementation().newInstance();

      p2 = (BasePlayer) players[1].getImplementation().newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      p1 = new KeyPlayer(KeyPlayer.leftArrowCode, KeyPlayer.rightArrowCode);

      p2 = new KeyPlayer(KeyPlayer.leftCharCode, KeyPlayer.rightCharCode);
    }

    toApply.addPlayer(p1);
    toApply.addPlayer(p2);
    players[0].applyState(p1);

    players[1].applyState(p2);

  }

  @Override
  public IGameMaster capturedState() {

    return null;
  }

  @Override
  public PlateState[] getplates() {

    return null;
  }

  /**
   * get players
   * 
   * @return array of players.
   */
  @Override
  public PlayerState[] getplayers() {
    return players;
  }

  /**
   * @return time.
   */
  @Override
  public int getTime() {

    return (int) time;
  }

  @Override
  public int getLevel() {

    return level;
  }

}
