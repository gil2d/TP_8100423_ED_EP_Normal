package Exceptions;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public class NetworkException extends Exception {

    public static final String verticeNotFound = "Vertice not found";

    /**
     * Constructs an instance of <code>NetworkException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NetworkException(String msg) {
        super(msg);
    }
}
