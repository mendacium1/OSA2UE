/**
 *
 * A class that encapsulates the result of a service operation and a corresponding service message.
 * @param <T> the type of the result data
 *
 * @author Jakob Mayr
 */
public class ServiceResult<T> implements ServiceMessage {

    private final T result;
    private final String serviceMessage;

    /**
     * Constructs a new {@code ServiceResult} object with the given result and service message.
     * @param result the result of the service operation
     * @param serviceMessage the message representing the service operation's status or outcome
     */
    public ServiceResult(T result, String serviceMessage) {
        this.result = result;
        this.serviceMessage = serviceMessage;
    }

    public T getResult() {
        return this.result;
    }

    @Override
    public String getMessage() {
        return this.serviceMessage;
    }

}