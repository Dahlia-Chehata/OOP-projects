package componentsImpl;

import java.awt.Dimension;
import java.util.Properties;

import listeners.Observer;

public class KeyPlayer extends BasePlayer implements Observer {

  private Character l, r;

  public KeyPlayer(char l, char r) {
    super();
    this.l = l;
    this.r = r;
    setSize(new Dimension(100,25));
  }

  @Override
  public void handleEvent() {
    // TODO Auto-generated method stub

  }

  @Override
  public void handleEvent(Properties eventType) {
      if ( !eventType.containsKey("key"))
      return;
      
    
    if ( eventType.get("key") == l)
      moveLeft();
  
    if ( eventType.get("key") == r)
      moveRight();
      

  }

}
