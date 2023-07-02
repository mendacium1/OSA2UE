package converter;

/**
 * This indicates problems during the convertion of csv files.
 *
 * @author Claudia
 *
 */
public class ConverterException extends RuntimeException {
	private static final long serialVersionUID = -675543633600479173L;

	private String path;

	/**
	 * @param message
	 *            the description of the exception
	 */
	public ConverterException(String message) {
		super(message);
	}

	/**
	 * @param message
	 *            the description of the exception
	 * @param path
	 *            the path of the affected file
	 */
	public ConverterException(String message, String path) {
		super(message);
		this.path = path;
	}

	/**
	 * @param message
	 *            the description of the exception
	 * @param path
	 *            the path of the affected file
	 * @param cause
	 *            the causing exception
	 */
	public ConverterException(String message, String path, Throwable cause) {
		super(message, cause);
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}
