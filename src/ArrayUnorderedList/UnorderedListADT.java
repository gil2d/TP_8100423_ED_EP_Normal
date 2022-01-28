/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayUnorderedList;
import BinaryTree.ListADT;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */

public interface UnorderedListADT<T> extends ListADT<T> 
{
    /**
     * Adds the specified element to the front of this list
     *
     * @param element
     */
    public void addToFront(T element);

    /**
     * Adds the specified element to the rear of this list
     *
     * @param element
     */
    public void addToRear(T element);

    /**
     * Adds the specified element after the specified target
     *
     * @param element
     * @param target
     */
    public void addAfter(T element, T target);
}
