package Heap;

import BinaryTree.BinaryTreeADT;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public interface HeapADT<T> extends BinaryTreeADT<T> {

    /**
     * Adds the specified object to this heap
     *
     * @param obj
     */
    public void addElement(T obj);

    /**
     * Removes and returns a reference to the element with the lowest value in
     * this heap
     *
     * @return
     */
    public T removeMin();

    /**
     * Removes the element with the lowest value in this heap
     *
     * @return
     */
    public T findMin();
}
