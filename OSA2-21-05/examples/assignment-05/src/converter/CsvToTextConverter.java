package converter;

/**
 * Converts csv files to tab separated text files.
 *
 * @author Claudia
 *
 */
public class CsvToTextConverter extends AbstractCsvConverter {

	/**
	 * Transform every row in the csv file to a tab separated line in a text file.
	 *
	 * @see AbstractCsvConverter#handleConversion()
	 */
	@Override
	protected void handleConversion() {
		result = content.replaceAll(";", "\t");
	}

}
