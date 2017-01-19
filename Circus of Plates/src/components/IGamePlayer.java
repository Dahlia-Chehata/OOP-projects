package components;

public interface IGamePlayer extends IGameComponent {
  
  public int getScore();
  
  public void incrementScore();
  
  public void decrementScore();
  
  public void addPlate(IItem nwItem);
  
  public IItem[] getPlates();

}
