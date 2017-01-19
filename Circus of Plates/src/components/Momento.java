package components;

/**
 * 
 * @author Ahmed Hamdy class resembles a snapshot of a given object state. The
 *         class should be immutable(has no setters) and the given state should
 *         be ready for saving and regaining.
 * @param <T>
 *          The class to apply momento.
 */
public interface Momento<T> {

  /**
   * applying the momento on a certain object.
   * 
   * @param toApply
   *          object to apply momento on.
   */
  public void applyState(T toApply);

  /**
   * regains the momento captured.
   * 
   * @return the momento captured.
   */
  public T capturedState();

  // TODO: add to XML function.

}
