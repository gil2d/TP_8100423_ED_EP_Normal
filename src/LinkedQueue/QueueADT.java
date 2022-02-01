
package LinkedQueue;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public interface QueueADT<T> {

    /**
     * Adds one element to the rear of the queue
     * 
     * @param element 
     */
    public void enqueue(T element);

    /**
     * Removes and returns the element at the front of the queue
     * 
     * @return 
     */
    public T dequeue();

    /**
     * Returns without removing the element at the front of the queue
     * 
     * @return 
     */
    public T first();

    /**
     * Returns true if the queue contains no elements
     * 
     * @return 
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the queue
     * 
     * @return 
     */
    public int size();

    /**
     * Returns a string representation of the queue
     * 
     * @return 
     */
    @Override
    public String toString();
}
