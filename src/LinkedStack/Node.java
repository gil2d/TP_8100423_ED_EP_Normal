package LinkedStack;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public class Node<T> {

    private Node<T> next;
    private T element;

    /**
     * Construtor de no vazio
     */
    public Node() {
        next = null;
        element = null;
    }

    /**
     * Construtor com elemento obtido por parametro
     *
     * @param elem
     */
    public Node(T elem) {
        next = null;
        element = elem;
    }

    /**
     * Devolve proximo no
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Faz um set do proximo no
     *
     * @param node
     */
    public void setNext(Node<T> node) {
        next = node;
    }

    /**
     * Devolve o elemento do no
     */
    public T getElement() {
        return element;
    }

    /**
     * Faz um set do elmento
     *
     * @param elem
     */
    public void setElement(T elem) {
        element = elem;
    }

}
