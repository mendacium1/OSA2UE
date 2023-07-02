package converter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Base class for class implementing {@link CsvConverter}.
 * <p>
 * This base class provides methods for reading and writing the file contents.
 *
 * @author Claudia
 */
public abstract class AbstractCsvConverter implements CsvConverter {

	/**
	 * The string path of the csv source file.
	 */
	private String source;
	/**
	 * The string path of the target file.
	 */
	private String target;
	/**
	 * The contents of the csv source file.
	 */
	protected String content;

	/**
	 * The transformation result in the target format;
	 */
	protected String result;

	/**
	 * Default constructor.
	 * <p>
	 * When the default constructor is used the source and target paths need to be set after object creation. Otherwise
	 * the convert operation will fail.
	 */
	protected AbstractCsvConverter() {
		// no op
	}

	/**
	 * Create a new csv converter with the given source and target file path.
	 *
	 * @param source
	 *            the source file path
	 * @param target
	 *            the target file path
	 */
	protected AbstractCsvConverter(String source, String target) {
		this.source = source;
		this.target = target;
	}

	/**
	 * @return the source file path
	 */
	protected String getSource() {
		return source;
	}

	/**
	 * @see CsvConverter#setSource(String)
	 */
	@Override
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the target file path
	 */
	protected String getTarget() {
		return target;
	}

	/**
	 * @see CsvConverter#setTarget(String)
	 */
	@Override
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * Read the file contents from the source file and store them to {@link AbstractCsvConverter#content}.
	 *
	 * @throws ConverterException
	 */
	protected void readFile() throws ConverterException {
		StringBuilder buffer = new StringBuilder();
		try (BufferedReader input = new BufferedReader(new FileReader(source))) {
			for (String line = input.readLine(); line != null; line = input.readLine()) {
				buffer.append(line).append("\n");
			}
		} catch (FileNotFoundException e) {
			throw new ConverterException("Could not find specified file", source, e);
		} catch (IOException e) {
			throw new ConverterException("Could not read specified file", source, e);
		}
		content = buffer.toString();
	}

	/**
	 * Write the transformation result to the target file.
	 *
	 * @throws ConverterException
	 */
	protected void writeFile() throws ConverterException {
		try {
			PrintWriter output = new PrintWriter(new FileWriter(target));
			output.write(result);
			output.close();
		} catch (IOException e) {
			throw new ConverterException("Could not write specified file", target, e);
		}
	}

	/**
	 * Reads the contents of the csv source file, transforms them to a new target format and writes the result to the
	 * target file.
	 * <p>
	 * The format of the target file is defined by the implementing subclass
	 * ({@link AbstractCsvConverter#handleConversion()}.
	 *
	 * @see CsvConverter#convert()
	 */
	@Override
	public void convert() {
		try {
			readFile();
			handleConversion();
			writeFile();
		} catch (ConverterException e) {
			System.out.print("Sorry, conversion cannot be executed. Cause: " + e.getMessage());
			if (e.getPath() == null) {
				System.out.println();
			} else {
				System.out.println(" (affected path " + e.getPath() + ")");
			}
		}
	}

	/**
	 * Implementing subclasses need to implement this method in order to transform the contents of the csv file to the
	 * desired format.
	 */
	protected abstract void handleConversion();

}
