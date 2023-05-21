import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 *
 * This class represents a CsvToXmlConverter object that can convert a CSV file to an XML file.
 *
 * It extends the CsvConverter class and implements the Convertible interface.
 * @author Jakob Mayr
 */
public class CsvToXmlConverter extends CsvConverter implements Convertible {

    private String inWrapper = "";
    private String outWrapper = "";
    private String rootTag = "rows";
    private String rowTag = "row";
    private String elementTag = "element";

    /**
     * Constructs a CsvToXmlConverter object with the specified input and output file paths and delimiter.
     * @param inputFile The input file path as a string.
     * @param outputFile The output file path as a string.
     * @param delimiter The delimiter to be used in the CSV file.
     */
    public CsvToXmlConverter(String inputFile, String outputFile, String delimiter) {
        super(inputFile, outputFile, delimiter);
    }

    /**
     * Converts the CSV file to an XML file.
     * Each row in the CSV file is wrapped in a row tag, and each field in the row is wrapped in an element tag.
     */
    @Override
    public void convert() {
        String input = super.readFile();
        String output = inWrapper;
        output += "<" + rootTag + ">\n";
        try (BufferedReader bufReader = new BufferedReader(new StringReader(input))) {
            String line;
            while ((line = bufReader.readLine()) != null) {
                String[] fields = line.split(this.getDelimiter());
                output += "<" + rowTag + ">\n";
                for (String field : fields) {
                    output += "<" + elementTag + ">" + field + "</" + elementTag + ">\n";
                }
                output += "</" + rowTag + ">\n";
            }
            output += "</" + rootTag + ">\n";
            output += outWrapper;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        super.writeFile(output);
    }

    /**
     * Sets the input wrapper for the XML file.
     * @param inWrapper The input wrapper as a string.
     */
    public void setInWrapper(String inWrapper) {
        this.inWrapper = inWrapper;
    }

    /**
     * Sets the output wrapper for the XML file.
     * @param outWrapper The output wrapper as a string.
     */
    public void setOutWrapper(String outWrapper) {
        this.outWrapper = outWrapper;
    }

    /**
     * Sets the root tag for the XML file.
     * @param rootTag The root tag as a string.
     */
    public void setRootTag(String rootTag) {
        this.rootTag = rootTag;
    }

    /**
     * Sets the row tag for the XML file.
     * @param rowTag The row tag as a string.
     */
    public void setRowTag(String rowTag) {
        this.rowTag = rowTag;
    }

    /**
     * Sets the element tag for the XML file.
     * @param elementTag The element tag as a string.
     */
    public void setElementTag(String elementTag) {
        this.elementTag = elementTag;
    }

}