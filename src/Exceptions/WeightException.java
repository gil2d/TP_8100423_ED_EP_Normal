package Exceptions;

/**
 *
 * @author Joaquim Sousa 8100423
 * 
 * @param T
 */
public class WeightException extends Exception {

    public static String EXIST_HOUSE = "Already have that house";

    /**
     * Constructs an instance of <code>WeightException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public WeightException(String msg) {
        super(msg);
    }
}
