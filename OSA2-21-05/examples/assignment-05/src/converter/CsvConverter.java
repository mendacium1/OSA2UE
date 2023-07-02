package converter;

/**
 * A converter reads the contents of a csv file, transforms them and writes the result to another file.
 *
 * @author Claudia
 *
 */
public interface CsvConverter {

	/**
	 * @param source
	 *            the path string of the source file
	 */
	void setSource(String source);

	/**
	 * Define the target file for the converter result.
	 * <p>
	 * If the file for the given path does not exist, the file will be created. If the file already exisits it will be
	 * replaced with the results.
	 *
	 * @param target
	 *            the path string of the target file
	 */
	void setTarget(String target);

	/**
	 * Read the contents of the source file and converts them to a new format. The result will be written to the target
	 * file.
	 * <p>
	 * Implementing classes define which format the csv data will be converted to.
	 */
	void convert();

}
