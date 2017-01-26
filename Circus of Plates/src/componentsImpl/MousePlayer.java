package componentsImpl;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Properties;

import listeners.GuiListener;
import listeners.GuiMouseListener;
import listeners.Observer;

public class MousePlayer extends BasePlayer implements Observer {

  private GuiMouseListener event;

  public MousePlayer() {
    super();
    setSize(new Dimension(100, 25));
    event = new GuiMouseListener();
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

    if (!eventType.containsKey("start") || !eventType.containsKey("release")) {
      return;
    }

    if (((Point) eventType.get("start")).x > ((Point) eventType.get("release")).x) {
      moveLeft();
    }

    if (((Point) eventType.get("start")).x < ((Point) eventType.get("release")).x) {
      moveRight();
    }

  }

  public GuiListener getEvent() {
    return event;
  }

}
