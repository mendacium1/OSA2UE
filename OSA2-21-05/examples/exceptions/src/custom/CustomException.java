package custom;

public class CustomException extends Exception {
	private static final long serialVersionUID = -409139839276334264L;

	private Object context;

	public CustomException() {
		super();
	}

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message, Object context) {
		super(message);
		this.context = context;
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomException(String message, Object context, Throwable cause) {
		super(message, cause);
		this.context = context;
	}

	public CustomException(Object context, Throwable cause) {
		super(cause);
		this.context = context;
	}

	public Object getContext() {
		return context;
	}
}
