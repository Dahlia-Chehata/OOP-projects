package components;

public interface GameState extends Momento<IGameMaster> {

  public PlateState[] getplates();
  
  public PlayerState[] getplayers();
  
  public int getTime();
  
  public int getLevel();
}
