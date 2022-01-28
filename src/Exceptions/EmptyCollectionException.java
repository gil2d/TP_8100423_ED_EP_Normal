package Exceptions;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public class EmptyCollectionException extends RuntimeException {

    /**
     * Sets up this exception with an appropriate message
     *
     * @param collection
     */
    public EmptyCollectionException(String collection) {
        super("The " + collection + " is empty.");
    }

}
