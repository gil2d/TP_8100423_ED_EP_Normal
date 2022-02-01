/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

import java.util.Iterator;
import ArrayUnorderedList.ArrayUnorderedList;
import Exceptions.*;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
    public int count;
    public BinaryTreeNode<T> root;

    /**
     * Creates an empty binary tree
     */
    public LinkedBinaryTree() {
        count = 0;
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root
     *
     * @param element the element that will become the root of the new binary
     * tree
     */
    public LinkedBinaryTree(T element) {
        count = 1;
        root = new BinaryTreeNode<T>(element);
    }

    /**
     * Constructs a binary tree from the two specified binary trees
     *
     * @param element
     * @param leftSubtree
     * @param rightSubtree
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> leftSubtree,
            LinkedBinaryTree<T> rightSubtree) {

        root = new BinaryTreeNode<T>(element);
        count = 1;
        if (leftSubtree != null) {
            count = count + leftSubtree.size();
            root.left = leftSubtree.root;
        } else {
            root.left = null;
        }
        if (rightSubtree != null) {
            count = count + rightSubtree.size();
            root.right = rightSubtree.root;
        } else {
            root.right = null;
        }

    }

    /**
     * Removes the left subtree of this binary tree
     */
    public void removeLeftSubtree() {
        if (root.left != null) {
            count = count - root.left.numChildren() - 1;
        }
        root.left = null;
    }

    /**
     * Removes the right subtree of this binary tree
     */
    public void removeRightSubtree() {
        if (root.right != null) {
            count = count - root.right.numChildren() - 1;
        }
        root.right = null;
    }

    /**
     * Deletes all nodes from the binary tree
     */
    public void removeAllElements() {
        count = 0;
        root = null;
    }

    /**
     * Returns a reference to the element at the root
     *
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T getRoot() throws EmptyCollectionException {
        if (root == null) {
            throw new EmptyCollectionException("binary tree");
        }
        return (root.element);
    }

    /**
     * Returns a string representation of the binary tree
     *
     * @return
     */
    @Override
    public String toString() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
        preorder(root, templist);
        return templist.toString();
    }

    /**
     * Returns true if the binary tree is empty and false otherwise
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns true if the binary tree is empty and false otherwise
     *
     * @return
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns true if the tree contains an element that matches the specified
     * target element and false otherwise
     *
     * @param targetElement
     * @return
     */
    @Override
    public boolean contains(T targetElement) {
        T temp;
        boolean found = false;

        try {
            temp = find(targetElement);
            found = true;
        }//try
        catch (ElementNotFoundException ElementNotFoundException) {
            found = false;
        }//catch

        return found;

    }

    /**
     * Returns a reference to the specified target element if it is found in
     * this binary tree. Throws a NoSuchElementException if the specified target
     * element is not found in the binary tree
     *
     * @param targetElement the element being sought in this tree
     * @return a reference to the specified target
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, root);
        if (current == null) {
            throw new ElementNotFoundException("binary tree");
        }
        return (current.element);
    }

    /**
     * Returns a reference to the specified target element if it is found in
     * this binary tree
     *
     * @param targetElement the element being sought in this tree
     * @param next the element to begin searching from
     */
    private BinaryTreeNode<T> findAgain(T targetElement,
            BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }
        if (next.element.equals(targetElement)) {
            return next;
        }
        BinaryTreeNode<T> temp = findAgain(targetElement, next.left);
        if (temp == null) {
            temp = findAgain(targetElement, next.right);
        }
        return temp;
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with the root
     *
     * @return an in order iterator over this binary tree
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inorder(root, tempList);
        return tempList.iterator();
    }

    /**
     * Performs a recursive inorder traversal
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inorder(BinaryTreeNode<T> node,
            ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inorder(node.left, tempList);
            tempList.addToRear(node.element);
            inorder(node.right, tempList);
        }
    }

    /**
     * Performs an preorder traversal on the binary tree by calling an
     * overloaded, recursive preorder method that starts with the root
     *
     * @return
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
        preorder(root, templist);
        return templist.iterator();
    }

    /**
     * Performs a recursive preorder traversal
     *
     * @param node
     * @param templist
     */
    protected void preorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) {
        if (node != null) {
            templist.addToRear(node.element);
            preorder(node.left, templist);
            preorder(node.right, templist);
        }
    }

    /**
     * Performs an postorder traversal on the binary tree by calling an
     * overloaded, recursive postorder method that starts with the root
     *
     * @return
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
        postorder(root, templist);
        return templist.iterator();
    }

    //  Performs a recursive postorder traversal
    protected void postorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) {
        if (node != null) {
            postorder(node.left, templist);
            postorder(node.right, templist);
            templist.addToRear(node.element);
        }
    }

    /**
     * Performs a levelorder traversal on the binary tree, using a templist
     *
     * @return
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayUnorderedList<T> nodes = new ArrayUnorderedList<T>();
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
        BinaryTreeNode<T> current;

        nodes.addToRear(root.element);

        while (!nodes.isEmpty()) {
            current = (BinaryTreeNode<T>) nodes.removeFirst();
            if (current != null) {
                templist.addToRear(current.element);
                nodes.addToRear(current.left.element);
                nodes.addToRear(current.right.element);
            } else {
                templist.addToRear(null);
            }
        }
        return templist.iterator();
    }
}
