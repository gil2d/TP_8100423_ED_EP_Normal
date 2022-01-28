package Heap;

import BinaryTree.BinaryTreeNode;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public class HeapNode<T> extends BinaryTreeNode<T> {

    protected HeapNode<T> parent;

    /**
     * Creates a new heap node with the specified data
     *
     * @param obj
     */
    HeapNode(T obj) {
        super(obj);
        parent = null;
    }

}
