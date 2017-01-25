package componentsImpl;

import java.util.ArrayList;

import components.APlate;
import components.IItem;
import components.Iterator;

public class ItemIterator implements Iterator<IItem> {

  private ArrayList<IItem> data;
  private int index;

  public ItemIterator() {
    index = 0;
    data = new ArrayList<IItem>();
  }

  @Override
  public boolean hasNext() {
    return index < data.size() - 1;
  }

  @Override
  public boolean hasPrev() {
    return index > 0;
  }

  @Override
  public Iterator<IItem> getNext() {
    if (!hasNext())
      return null;
    index++;
    return this;
  }

  @Override
  public Iterator<IItem> getPrev() {
    if (!hasPrev())
      return null;
    index--;
    return this;
  }

  @Override
  public void insert(IItem nwItem) {
    data.add(0, nwItem);
    // data.add(nwItem);

  }

  @Override
  public void remove(int index) {
    data.remove(index);

  }

  @Override
  public void reset() {
    index = 0;
  }


  @Override
  public void remove() {
    data.remove(index);
    // index --;

  }

  @Override
  public IItem getval() {
    if (data.size() == 0)
      return null;
    return data.get(index);
  }

  @Override
  public IItem[] toArray() {
    IItem[] toret = new IItem[data.size()];
    for(int i=0;i<data.size() ; i++)
      toret[i] =(APlate)data.get(i);
    return toret;
    
  }
}
