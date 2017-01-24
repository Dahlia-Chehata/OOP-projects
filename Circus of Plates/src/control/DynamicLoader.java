package control;

import components.IDispenser;
import components.IGameMaster;
import components.IGamePlayer;
import components.IItem;
import components.Iterator;

/**
 * This class should load instances of each concrete class as its interfaces the
 * classes should all be loaded from a configuration file. clasees loaded should
 * be IGamePlayer, IGame Master, IDispenser , Iterator
 * 
 * @author Dahlia or Helana
 *
 */
public class DynamicLoader {

  public IGamePlayer getPlayer() {
    return null;
  }

  public IGameMaster getGame() {
    return null;
  }

  public IDispenser getDispenser() {
    return null;
  }

  public Iterator<IItem> getIterator() {
    return null;
  }

}
