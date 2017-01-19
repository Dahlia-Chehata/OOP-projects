package components;

public interface GameState extends Momento<IGameController> {

  public Momento<IItem>[] getplates();
  
  public Momento<IGamePlayer>[] getplayers();
  
  public int getTime();
  
  public int getLevel();
}
