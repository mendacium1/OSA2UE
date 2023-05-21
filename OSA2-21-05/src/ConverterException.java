/**
 *
 * A custom unchecked exception that represents an error that occurred during the conversion process.
 * @author Jakob Mayr
 */
public class ConverterException extends RuntimeException {

    /**
     * Constructs a new ConverterException with the specified error message and cause.
     * @param message the error message.
     * @param cause the cause of the error.
     */
    public ConverterException(String message, Throwable cause) {
        super(message, cause);
    }

}