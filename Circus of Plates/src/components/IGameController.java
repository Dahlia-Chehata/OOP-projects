package components;

public interface IGameController {

  /**
   * gets plate dispenser.
   * @return plate dispenser.
   */
  public IDispenser<IItem> getDispenser();
  
  /**
   * returns player indicated.
   * @param id id of player, currently only 1 or 2.
   * @return the stated player.
   * @throws ArrayIndexOutOfBoundsException if the player doesn't exist.
   */
  public IGamePlayer getPlayer(int id) throws ArrayIndexOutOfBoundsException;
  
  /**
   * gets time since start of the game.
   * @return time in ms, -1 if the game hasn't started.
   */
  public long getTime();

  public IItem[] getplates();
  
  public int getLevel();
  
  public int getScoreOf(int playerId) throws ArrayIndexOutOfBoundsException; 
  
  public Momento<IGameController> toState();
}
