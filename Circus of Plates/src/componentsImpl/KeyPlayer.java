package componentsImpl;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.Properties;

import listeners.GuiKeyListener;
import listeners.GuiListener;
import listeners.Observer;

@SuppressWarnings("serial")
public class KeyPlayer extends BasePlayer implements Observer {

  private int left;
  private int right;
  public static int leftArrowCode = KeyEvent.VK_LEFT;
  public static int rightArrowCode = KeyEvent.VK_RIGHT;

  public static int leftCharCode = KeyEvent.VK_A;
  public static int rightCharCode = KeyEvent.VK_D;
  private GuiKeyListener event;

  public KeyPlayer(int l, int r) {
    super();
    this.left = l;
    this.right = r;
    setSize(new Dimension(100, 25));
    event = new GuiKeyListener();
    event.addObserver(this);
  }

  /**
   * handles known event.
   */
  @Override
  public void handleEvent() {
    return;

  }

  /**
   * handles event.
   */
  @Override
  public void handleEvent(Properties eventType) {
    if (!eventType.containsKey("key"))
      return;
    if ((Integer) eventType.get("key") == left)
      moveLeft();

    if ((Integer) eventType.get("key") == right)
      moveRight();

  }

  @Override
  public GuiListener getEvent() {
    return event;
  }

}
