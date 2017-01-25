package components;

public interface GameState extends Momento<IGameController> {

  public PlateState[] getplates();
  
  public PlayerState[] getplayers();
  
  public int getTime();
  
  public int getLevel();
}
