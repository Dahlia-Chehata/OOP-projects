package components;

public interface IDispenser<T> {
 
  /**
   * returns new instance of T.
   * @return new instance of class T.
   */
  public T getNewInstance();
  
  /**
   * disposes an object to be pooled.
   * @param disposable Object to throw away.
   */
  public void dispose(T disposable);
  
}
