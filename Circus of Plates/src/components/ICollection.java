package components;

public interface ICollection<T> {
  
  public Iterator<T> getFirst();
  
  public Iterator<T> getAt(int index) throws IndexOutOfBoundsException;
  
  public void insert(T newElement);
  
  T[] toArray();

}
