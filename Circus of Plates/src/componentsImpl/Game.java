package componentsImpl;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.util.Random;

import javax.swing.JPanel;

import components.APlate;
import components.IDispenser;
import components.IGameComponent;
import components.IGameController;
import components.IGameMaster;
import components.IGamePlayer;
import components.IItem;
import components.Iterator;
import components.Momento;
import items.BaseShape;

public class Game implements IGameMaster {
  private boolean pause;
  private IDispenser<IItem> pool;
  private IGamePlayer[] players;
  private long startTime;
  protected Iterator<IItem> freePlates;
  protected Iterator<IGameComponent> components;
  private Dimension bounds;
  private JPanel gui;

  private int level;

  public Game(JPanel gui) {
    bounds = gui.getSize();
    this.gui = gui;
    level = 0;
    pause = true;
    // TODO fix these
    freePlates = new Iteratee<IItem>();
    components = new Iteratee<IGameComponent>();
    players = new IGamePlayer[2];
    pool = new PlatePool();
    Thread runner = new RunningThread();
    runner.start();

  }

  @Override
  public IDispenser<IItem> getDispenser() {
    return pool;

  }

  @Override
  public IGamePlayer getPlayer(int id) throws ArrayIndexOutOfBoundsException {

    return players[id];
  }

  @Override
  public long getTime() {

    return System.currentTimeMillis() - startTime;
  }

  @Override
  public IItem[] getplates() {

    return freePlates.toArray();
  }

  @Override
  public int getLevel() {

    return level;
  }

  @Override
  public int getScoreOf(int playerId) throws ArrayIndexOutOfBoundsException {
    return players[playerId].getScore();
  }

  @Override
  public Momento<IGameController> toState() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public synchronized void updatePlates() {
    Iterator<IItem> it = freePlates;
    if (it.getval() != null) {

      while (it != null) {
        it.getval().acceptRequest();
        
        for (int i = 0; i < players.length; i++) {
          if (it.getval() != null)
          if (players[i].intersects(it.getval())) {
            players[i].addPlate((APlate) it.getval());
            it.remove();
          } else if (it.getval().getActualPosition().y >= bounds.height) {
            pool.dispose(it.getval());
            it.remove();
          }

        }
        it = it.getNext();
      }
      freePlates.reset();
    }
  }

  @Override
  public synchronized void updatePlayers() {
    for (int i = 0; i < players.length; i++) {
      Iterator<IGameComponent> it = components;
      boolean intersects = false;
      if (it.getval() != null) {
        while (it != null) {
          if (it.getval() != players[i] && players[i].intersects(it.getval())) {
            intersects = true;
          }
          it = it.getNext();
        }
      }
      //System.out.println((players[i] == null) + " " + i);
      if (!intersects) {
        players[i].acceptRequest();
      } else {
        players[i].declineRequest(players[i].requestedPosition());
      }
      components.reset();
    }

  }

  @Override
  public void run() {
    pause = false;
  }

  @Override
  public void pause() {
    pause = true;
  }

  @Override
  public void addPlayer(IGamePlayer player) {
    if (players[0] == null) {
      players[0] = player;
      gui.add((BaseShape) player);
      components.insert(player);
      return;
    } else if (players[1] == null) {
      players[1] = player;

      gui.add((BaseShape) player);
      components.insert(player);
    }
    pause = false;

  }

  @Override
  public void save(File destination) {
    // TODO Auto-generated method stub

  }

  @Override
  public void upgradeLevel() {
    level++;

  }

  @Override
  public void setLevel(int level) {
    this.level = level;

  }

  @Override
  public void insertplates(double prob) {
    int rn = new Random().nextInt(100);
    if (rn > prob * 100) {
      return;

    }
    IItem nwItem = pool.getNewInstance();
    freePlates.insert(nwItem);
    
    BaseShape bs = (BaseShape) nwItem; // TODO Find better method
    int x = new Random().nextInt(bounds.width);
    bs.setLocation(new Point(x, 0));
    nwItem.drop();
    gui.add(bs);

  }

  private void dropPlates() {
    pause = true;
    Iterator<IItem> it = freePlates;

    if (it.getval() != null) {

      while (it != null) {
        it.getval().drop();
        it = it.getNext();
      }
    }
    freePlates.reset();
    pause = false;
  }

  private void doGame() throws InterruptedException {

    int i = 0;
    while (true)
      if (!pause || players[1] != null) {
        //System.out.println("her");
        updatePlayers();
         updatePlates();

         if(i%50==0)
         insertplates((level + 10) / 10.0);
        Thread.sleep(50);
        dropPlates();
        i++;
      }
  }

  private class RunningThread extends Thread {
    public RunningThread() {

    }

    public void run() {
      try {
        doGame();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
