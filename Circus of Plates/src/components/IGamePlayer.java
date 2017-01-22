package components;

import componentsImpl.Plate;

public interface IGamePlayer extends IGameComponent {
  
  public int getScore();
  
  public void incrementScore();
  
  public void decrementScore();
  
  public void addPlate(APlate nwItem);
  
  public APlate[] getPlates();

}
