/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

import java.util.Iterator;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */

public interface ListADT<T> {
    /**
     * Removes and returns the first element from this list
     *
     * @return
     */
    public T removeFirst();

    /**
     * Removes and returns the last element from this list
     *
     * @return
     */
    public T removeLast();

    /**
     * Removes and returns the specified element from this list
     *
     * @param element
     * @return
     */
    public T remove(T element);

    /**
     * Returns a reference to the first element on this list
     *
     * @return
     */
    public T first();

    /**
     * Returns a reference to the last element on this list
     *
     * @return
     */
    public T last();

    /**
     * Returns true if this list contains the specified target element
     *
     * @param target
     * @return
     */
    public boolean contains(T target);

    /**
     * Returns true if this list contains no elements
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this list
     *
     * @return
     */
    public int size();

    /**
     * Returns an iterator for the elements in this list
     *
     * @return
     */
    public Iterator<T> iterator();

    /**
     * Returns a string representation of this list
     *
     * @return
     */
    @Override
    public String toString();

}
