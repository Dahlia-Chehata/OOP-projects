package components;

public interface PlayerState extends ComponentState {

  public PlateState[] getPlates();
  
  public int getScore();
}
