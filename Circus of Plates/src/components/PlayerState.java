package components;

public interface PlayerState extends Momento<IGamePlayer> {

  public PlateState[] getPlates();
  
  public int getScore();
}
