package result;

/**
 * Generic container class for the result of service requests.
 * <p>
 * Each service response consists of a result object of type <code>R</code> and a service message of type <code>T</code>.
 *
 * @param <R> type of the service result object
 * @param <M> type of the service message object
 */
public record ServiceRecord<R, M extends ServiceMessage>(R result, M message) {
}
