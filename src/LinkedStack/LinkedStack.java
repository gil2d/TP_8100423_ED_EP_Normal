package LinkedStack;

import Exceptions.*;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public class LinkedStack<T> implements StackADT<T> {

    private int count;  // indicates the next open slot
    private Node<T> top;

    /**
     * Creates an empty stack
     */
    public LinkedStack() {
        count = 0;
        top = null;
    }

    /**
     * Adds the specified element to the top of this stack
     *
     * @param element
     */
    @Override
    public void push(T element) {
        Node<T> temp = new Node<T>(element);

        temp.setNext(top);
        top = temp;
        count++;
    }

    /**
     * Removes the element at the top of this stack and returns a reference to
     * it. Throws an EmptyStackException if the stack is empty
     *
     * @return
     * @throws EmptyStackException
     */
    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack. The element
     * is not removed from the stack. Throws an EmptyStackException if the stack
     * is empty
     *
     * @return
     * @throws EmptyStackException
     */
    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.getElement();
    }

    /**
     * Returns true if this stack is empty and false otherwise
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns the number of elements in the stack
     *
     * @return
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of this stack
     *
     * @return
     */
    @Override
    public String toString() {
        String result = "";
        Node current = top;

        while (current != null) {
            result = result + (current.getElement()).toString() + "\n";
            current = current.getNext();
        }

        return result;
    }

}
