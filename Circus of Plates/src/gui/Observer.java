package gui;

import java.util.Properties;

public interface Observer {
  public void handleEvent();

  public void handleEvent(Properties eventType);

}
