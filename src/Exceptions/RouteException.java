package Exceptions;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public class RouteException extends Exception {

    public static String NO_ROUTE = "No route avaiable with that requirements";

    /**
     * Constructs an instance of <code>RouteException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public RouteException(String msg) {
        super(msg);
    }
}
