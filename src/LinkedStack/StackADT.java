package LinkedStack;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public interface StackADT<T> {

    /**
     * Adds one element to the top of this stack.
     *
     * @param element
     */
    public void push(T element);

    /**
     * Removes and returns the top element from this stack.
     *
     * @return
     */
    public T pop();

    /**
     * Returns without removing the top element of this stack.
     *
     * @return
     */
    public T peek();

    /**
     * Returns true if this stack contains no elements.
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this stack.
     *
     * @return
     */
    public int size();

    /**
     * Returns a string representation of this stack.
     *
     * @return
     */
    @Override
    public String toString();

}
