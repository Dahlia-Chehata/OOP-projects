package components;

public interface Iterator<T> {

  public boolean hasNext();

  public boolean hasPrev();

  public Iterator<T> getNext();

  public Iterator<T> getPrev();

  public T getval();

  public void insert(T nwItem);

  public void remove(int index);
  
  public void reset();

}
