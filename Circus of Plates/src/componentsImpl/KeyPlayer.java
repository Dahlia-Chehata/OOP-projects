package componentsImpl;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.Properties;

import listeners.GuiKeyListener;
import listeners.GuiListener;
import listeners.Observer;

public class KeyPlayer extends BasePlayer implements Observer {

  private int l, r;
  public static int leftArrowCode = KeyEvent.VK_LEFT;
  public static int rightArrowCode = KeyEvent.VK_RIGHT;

  public static int leftCharCode = KeyEvent.VK_A;
  public static int rightCharCode = KeyEvent.VK_D;
  private GuiKeyListener event;
  public KeyPlayer(int l, int r) {
    super();
    this.l = l;
    this.r = r;
    setSize(new Dimension(100,25));
    event = new GuiKeyListener();
    event.addObserver(this);
  }

  @Override
  public void handleEvent() {
    // TODO Auto-generated method stub

  }

  @Override
  public void handleEvent(Properties eventType) {
      if ( !eventType.containsKey("key"))
      return;

      System.out.println("move");
    
    if ((Integer) eventType.get("key") == l)
      moveLeft();
  
    if ((Integer) eventType.get("key") == r)
      moveRight();

  }
  @Override
  public GuiListener getEvent() {
    return event;
  }

}
