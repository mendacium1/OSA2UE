package converter;

/**
 * Converts csv files to xml files.
 *
 * @author Claudia
 *
 */
public class CsvToXmlConverter extends AbstractCsvConverter {

	/**
	 * Takes the contents of a csv file and converts them to an xml file.
	 * <p>
	 * Each line in the csv file forms a new row element. Every value in the line is wrapped in an element tag.
	 *
	 * @see AbstractCsvConverter#handleConversion()
	 */
	@Override
	protected void handleConversion() {
		StringBuilder builder = new StringBuilder();

		builder.append("<rows>").append("\n");

		String[] lines = content.split("\n");
		for (String line : lines) {
			builder.append("<row>").append("\n");
			String[] elements = line.split(";");
			for (String element : elements) {
				builder.append("<element>").append(element).append("</element>").append("\n");
			}
			builder.append("</row>").append("\n");
		}
		builder.append("</rows>");

		result = builder.toString();
	}

}
