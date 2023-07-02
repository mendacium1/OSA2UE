package converter;

/**
 * Converts csv files to html files.
 *
 * @author Claudia
 *
 */
public class CsvToHtmlConverter extends AbstractCsvConverter {

	/**
	 * Takes the contents of the csv file and converts them to a html file.
	 * <p>
	 * The contents of the csv file are transformed to an html table.
	 *
	 * @see AbstractCsvConverter#handleConversion()
	 */
	@Override
	protected void handleConversion() {
		StringBuilder builder = new StringBuilder();
		builder.append(htmlHeader());
		builder.append(tableHeader());

		String[] lines = content.split("\n");
		for (String line : lines) {
			builder.append("<tr>").append("\n");
			String[] elements = line.split(";");
			for (String element : elements) {
				builder.append("<td>").append(element).append("</td>").append("\n");
			}
			builder.append("</tr>").append("\n");
		}
		builder.append(tableFooter());
		builder.append(htmlFooter());

		result = builder.toString();
	}

	/**
	 * @return the html header including the opening body tag
	 */
	private String htmlHeader() {
		StringBuilder builder = new StringBuilder();
		builder.append("<html>").append("\n");
		builder.append("<head>").append("<title>CsvToHtml</title>").append("</head>").append("\n");
		builder.append("<body>");
		return builder.toString();
	}

	/**
	 * @return the opening html table tag
	 */
	private String tableHeader() {
		StringBuilder builder = new StringBuilder();
		builder.append("<table>").append("\n");
		return builder.toString();
	}

	/**
	 * @return the closing html table tag
	 */
	private String tableFooter() {
		StringBuilder builder = new StringBuilder();
		builder.append("</table>").append("\n");
		return builder.toString();
	}

	/**
	 * @return the closing body and html tag
	 */
	private String htmlFooter() {
		StringBuilder builder = new StringBuilder();
		builder.append("</body>").append("\n");
		builder.append("</html>");
		return builder.toString();
	}

}
