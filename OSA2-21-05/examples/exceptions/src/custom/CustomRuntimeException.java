package custom;

public class CustomRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 4401095146087360016L;

	private Object context;

	public CustomRuntimeException() {
		super();
	}

	public CustomRuntimeException(String message) {
		super(message);
	}

	public CustomRuntimeException(String message, Object context) {
		super(message);
		this.context = context;
	}

	public CustomRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomRuntimeException(String message, Object context, Throwable cause) {
		super(message, cause);
		this.context = context;
	}

	public CustomRuntimeException(Object context, Throwable cause) {
		super(cause);
		this.context = context;
	}

	public Object getContext() {
		return context;
	}
}
