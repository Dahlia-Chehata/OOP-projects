package componentsImpl;

import java.util.ArrayList;

import components.Iterator;

public class Iteratee<T> implements Iterator<T> {

  private ArrayList<T> data;
  private int index;

  public Iteratee() {
    index = 0;
    data = new ArrayList<T>();
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
  public Iterator<T> getNext() {
    if (!hasNext())
      return null;
    index++;
    return this;
  }

  @Override
  public Iterator<T> getPrev() {
    if (!hasPrev())
      return null;
    index--;
    return this;
  }

  @Override
  public T getval() {
    if (data.size() == 0)
      return null;
    return data.get(index);
  }

  @Override
  public void insert(T nwItem) {
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

  @SuppressWarnings("unchecked")
  @Override
  public T[] toArray() {

    return (T[]) data.toArray();
  }

  @Override
  public void remove() {
    data.remove(index);
    // index --;

  }

}
