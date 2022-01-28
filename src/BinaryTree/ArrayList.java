/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

import java.util.Iterator;
import Exceptions.*;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */

public class ArrayList<T> implements ListADT<T> {
    protected final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;
    protected int rear;
    protected T[] list;

    /**
     * Creates an empty list using the default capacity
     */
    public ArrayList() {
        rear = 0;
        list = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty list using the specified capacity
     *
     * @param initialCapacity
     */
    public ArrayList(int initialCapacity) {
        rear = 0;
        list = (T[]) (new Object[initialCapacity]);
    }

    /**
     * Removes and return the first element in the list
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        T result = list[0];
        rear--;
        for (int scan = 0; scan < rear; scan++) {
            list[scan] = list[scan + 1];
        }
        list[rear] = null;
        return result;
    }

    /**
     * Removes and return the last element in the list
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        T result;

        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        rear--;
        result = list[rear];
        list[rear] = null;
        return result;
    }

    /**
     * Removes and returns the specified element
     *
     * @param element
     * @return
     */
    @Override
    public T remove(T element) {
        T result;
        int index = find(element);
        if (index == NOT_FOUND) {
            throw new ElementNotFoundException("list");
        }
        result = list[index];
        rear--;
        for (int scan = index; scan < rear; scan++) {
            list[scan] = list[scan + 1];
        }
        list[rear] = null;
        return result;

    }

    /**
     * Returns a reference to the element at the front of the list
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        return list[0];
    }

    /**
     * Returns a reference to the element at the rear of the list
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        return list[rear - 1];
    }

    /**
     * Returns true if this list contains the specified element
     *
     * @param target
     * @return
     */
    @Override
    public boolean contains(T target) {
        return (find(target) != NOT_FOUND);
    }

    /**
     * Returns the array index of the specified element, or the constant
     * NOT_FOUND if it is not found
     *
     * @param target
     * @return
     */
    private int find(T target) {
        int scan = 0, result = NOT_FOUND;
        boolean found = false;

        if (!isEmpty()) {
            while (!found && scan < rear) {
                if (target.equals(list[scan])) {
                    found = true;
                } else {
                    scan++;
                }
            }
        }

        if (found) {
            result = scan;
        }
        return result;
    }

    /**
     * Returns true if this list is empty or false
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (rear == 0);
    }

    /**
     * Returns the number of elements currently in this list
     *
     * @return
     */
    @Override
    public int size() {
        return rear;
    }

    /**
     * Returns an iterator for the elements currently in this list
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(list, rear);
    }

    /**
     * Returns a string representation of this list
     *
     * @return
     */
    @Override
    public String toString() {
        String result = "";
        for (int scan = 0; scan < rear; scan++) {
            result = result + list[scan].toString() + "\n";
        }
        return result;
    }

    /**
     * Creates a new array to store the contents of the list with twice the
     * capacity of the old one
     */
    protected void expandCapacity() {
        T[] larger = (T[]) (new Object[list.length * 2]);
        for (int scan = 0; scan < list.length; scan++) {
            larger[scan] = list[scan];
        }
        list = larger;
    }
}
