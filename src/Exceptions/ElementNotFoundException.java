package Exceptions;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public class ElementNotFoundException extends RuntimeException {

    /**
     * Sets up this exception with an appropriate message
     *
     * @param collection
     */
    public ElementNotFoundException(String collection) {
        super("The target element is not in this " + collection);
    }

}
