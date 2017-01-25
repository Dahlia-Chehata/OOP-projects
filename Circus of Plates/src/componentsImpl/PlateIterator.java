package componentsImpl;

import java.util.ArrayList;

import components.APlate;
import components.IItem;
import components.Iterator;

public class PlateIterator implements Iterator<APlate> {

  private ArrayList<APlate> data;
  private int index;

  public PlateIterator() {
    index = 0;
    data = new ArrayList<APlate>();
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
  public Iterator<APlate> getNext() {
    if (!hasNext())
      return null;
    index++;
    return this;
  }

  @Override
  public Iterator<APlate> getPrev() {
    if (!hasPrev())
      return null;
    index--;
    return this;
  }

  @Override
  public void insert(APlate nwItem) {
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
  public APlate getval() {
    if (data.size() == 0)
      return null;
    return data.get(index);
  }

  @Override
  public APlate[] toArray() {
    APlate[] toret = new APlate[data.size()];
    for(int i=0;i<data.size() ; i++)
      toret[i] =(APlate)data.get(i);
    return toret;
  }
}
