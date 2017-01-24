package components;

import java.io.File;

public interface IGameMaster extends IGameController {

  public void updatePlates();
  
  public void updatePlayers();
  
  public void run();
  
  public void pause();
  
  public void addPlayer(IGamePlayer player );
  
  public void save(File destination);
  
  public void upgradeLevel();
  
  public void setLevel(int level);
  
  public void insertplates(double prob);
  
  
  
}
