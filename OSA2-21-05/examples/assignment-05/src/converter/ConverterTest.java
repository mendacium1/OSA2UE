package converter;

public class ConverterTest {

	public static void main(String... args) {
		CsvConverter c = new CsvToTextConverter();
		c.setSource("comic.csv");
		c.setTarget("comic.txt");

		c.convert();

		c = new CsvToTextConverter();
		c.setSource("comic.csv");
		c.setTarget("comic.txt");

		c.convert();

		c = new CsvToHtmlConverter();
		c.setSource("comic.csv");
		c.setTarget("comic.htm");

		c.convert();

		c = new CsvToXmlConverter();
		c.setSource("comic.csv");
		c.setTarget("comic.xml");

		c.convert();
	}

}
