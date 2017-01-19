package listeners;

import gui.Observer;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class GuiKeyListener implements GuiListener, KeyListener {

  private Component source;
  private List<Observer> observers;
  private char key;

  public GuiKeyListener() {
    this.source = null;
    observers = new ArrayList<Observer>();
  }

  public GuiKeyListener(Component source) {
    observers = new ArrayList<Observer>();
    attachListener(source);
  }

  @Override
  public void attachListener(Component source) {
    this.source = source;
    source.addKeyListener(this);

  }

  private void fireEvent() {
    Properties info = new Properties();
    info.put("Key", key);
    for (Observer obs : observers) {
      obs.handleEvent(info);
    }
  }

  @Override
  public void dettachListener() {
    source.removeKeyListener(this);
    source = null;

  }

  @Override
  public boolean isAttached() {
    return source != null;
  }

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);

  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);

  }

  @Override
  public void keyPressed(KeyEvent arg0) {
    key = arg0.getKeyChar();
    fireEvent();

  }

  @Override
  public void keyReleased(KeyEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyTyped(KeyEvent arg0) {
    // TODO Auto-generated method stub

  }

}
