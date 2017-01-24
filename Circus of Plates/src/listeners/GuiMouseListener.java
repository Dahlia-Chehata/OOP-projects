package listeners;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GuiMouseListener implements GuiListener, MouseListener,MouseMotionListener {
  private Component source;
  private List<Observer> observers;
  private Point pressPoint, releasePoint, exitPoint, entryPoint;

  public GuiMouseListener() {
    this.source = null;
    observers = new ArrayList<Observer>();
  }

  public GuiMouseListener(Component source) {
    observers = new ArrayList<Observer>();
    attachListener(source);
  }

  @Override
  public void attachListener(Component source) {
    this.source = source;
    source.addMouseListener(this);

  }

  private void fireEvent() {
    Properties info = new Properties();
    if (pressPoint != null)
      info.put("start", pressPoint);
    if (exitPoint != null)
      info.put("exit", exitPoint);
    if (entryPoint != null)
      info.put("entry", entryPoint);
    if (releasePoint != null)
      info.put("release", releasePoint);
    for (Observer obs : observers) {
      obs.handleEvent(info);
    }
  }

  @Override
  public void dettachListener() {
    source.removeMouseListener(this);
    source = null;

  }

  @Override
  public boolean isAttached() {
    return source != null;
  }

  @Override
  public void mouseClicked(MouseEvent arg0) {
    fireEvent();
  }

  @Override
  public void mouseEntered(MouseEvent arg0) {
    entryPoint = arg0.getPoint();
    
  }

  @Override
  public void mouseExited(MouseEvent arg0) {
    exitPoint = arg0.getPoint();

  }

  @Override
  public void mousePressed(MouseEvent arg0) {
    pressPoint = arg0.getPoint();
    return;

  }

  @Override
  public void mouseReleased(MouseEvent arg0) {
    releasePoint = arg0.getPoint();
    return;

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
  public void mouseDragged(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseMoved(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
  }

}
