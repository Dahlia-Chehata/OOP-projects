package componentsImpl;

import java.util.Properties;

import gui.Observer;

public class KeyPlayer extends BasePlayer implements Observer {

  private Character l, r;

  public KeyPlayer(char l, char r) {
    super();
    this.l = l;
    this.r = r;
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
      //System.out.println("A7a");
      moveLeft();
  
    if ( eventType.get("key") == r)
      moveRight();
      

  }

}
