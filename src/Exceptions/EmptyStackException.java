package Exceptions;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public class EmptyStackException extends RuntimeException {

    /**
     * Creates a new instance of <code>EmptyStackException</code> without detail
     * message.
     */
    public EmptyStackException() {
        super("The stack is empty.");
    }

    /**
     * Constructs an instance of <code>EmptyStackException</code> with the
     * specified detail message.
     *
     * @param message the detail message.
     */
    public EmptyStackException(String message) {
        super(message);
    }
}
