/**
 *
 * This class represents a CsvToTextConverter object that can convert a CSV file to a text file.
 *
 * It extends the CsvConverter class and implements the Convertible interface.
 * @author Jakob MAyr
 */
public class CsvToTextConverter extends CsvConverter implements Convertible {

    /**
     * Constructs a CsvToTextConverter object with the specified input and output file paths and delimiter.
     * @param inputFile The input file path as a string.
     * @param outputFile The output file path as a string.
     * @param delimiter The delimiter to be used in the CSV file.
     */
    public CsvToTextConverter(String inputFile, String outputFile, String delimiter) {
        super(inputFile, outputFile, delimiter);
    }

    /**
     * Converts the CSV file to a text file by replacing the delimiter with a tab character.
     */
    @Override
    public void convert() {
        super.writeFile(super.readFile().replace(this.getDelimiter(), "\t"));
    }
}