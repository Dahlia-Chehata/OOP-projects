package listeners;

import java.util.Properties;

public interface Observer {
  
  /**
   * handles known event.
   */
  public void handleEvent();


  /**
   * handles event.
   */
  public void handleEvent(Properties eventType);

}
