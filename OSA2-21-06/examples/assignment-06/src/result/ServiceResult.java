package result;

/**
 * Generic container class for the result of service requests.
 *
 * Each service response consists of a result object of type <code>R</code> and a service message of type <code>T</code>.
 *
 * @param <R> type of the service result object
 * @param <M> type of the service message object
 */
public class ServiceResult<R, M extends ServiceMessage> {

	private final R result;

	private final M message;

	public ServiceResult(R result, M message) {
		this.result = result;
		this.message = message;
	}

	public R getResult() {
		return result;
	}

	public M getMessage() {
		return message;
	}
}
