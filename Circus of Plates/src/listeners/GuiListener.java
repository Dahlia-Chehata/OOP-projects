package listeners;

import java.awt.Component;

public interface GuiListener {
  public void attachListener(Component source);

  /**
   * component equal null.
   */
  public void dettachListener();

  /**
   * check if component equal null or not.
   * 
   * @return true if component not equal null.
   */
  public boolean isAttached();

  /**
   * add observer to list.
   */
  public void addObserver(Observer observer);

  /**
   * remove observer from list.
   */
  public void removeObserver(Observer observer);
}
