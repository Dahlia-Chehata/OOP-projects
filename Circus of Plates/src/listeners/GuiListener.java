package listeners;

import java.awt.Component;

import gui.Observer;

public interface GuiListener {
  public void attachListener(Component source);

  public void dettachListener();

  public boolean isAttached();

  public void addObserver(Observer observer);

  public void removeObserver(Observer observer);
}
