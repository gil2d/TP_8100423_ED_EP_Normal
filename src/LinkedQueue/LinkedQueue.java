package LinkedQueue;

import Exceptions.*;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private int count;
    private LinkedNode<T> front, rear;

    /**
     * Creates an empty queue
     */
    public LinkedQueue() {
        count = 0;
        front = rear = null;
    }

    /**
     *
     * Adds the specified element to the rear of the queue
     *
     * @param element
     */
    @Override
    public void enqueue(T element) {
        LinkedNode<T> node = new LinkedNode<T>(element);

        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }

        rear = node;
        count++;
    }

    /**
     *
     * Removes the element at the front of the queue and returns a reference to
     * it. Throws an EmptyCollectionException if the queue is empty
     *
     * @return result
     * @throws EmptyCollectionException
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        T result = front.getElement();
        front = front.getNext();
        count--;

        if (isEmpty()) {
            rear = null;
        }

        return result;
    }

    /**
     *
     * Returns a reference to the element at the front of the queue. The element
     * is not removed from the queue. Throws an EmptyCollectionException if the
     * queue is empty
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        return front.getElement();
    }

    /**
     * Returns true if this queue is empty and false otherwise
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns the number of elements currently in this queue
     *
     * @return count
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of this queue
     *
     * @return result
     */
    @Override
    public String toString() {
        String result = "";
        LinkedNode<T> current = front;

        while (current != null) {
            result = result + (current.getElement()).toString() + "\n";
            current = current.getNext();
        }

        return result;
    }
}
