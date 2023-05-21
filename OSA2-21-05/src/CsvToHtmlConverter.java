/**
 * CsvToHtmlConverter class represents a converter that converts CSV data to HTML format.
 * @author Jakob Mayr
 */
public class CsvToHtmlConverter extends CsvToXmlConverter implements Convertible {

    /**
     * Constructor to initialize the CSV to HTML converter.
     * @param inputFile the input file to be converted
     * @param outputFile the output file to write the converted data to
     * @param delimiter the delimiter used to separate CSV fields
     * @param inWrapper the wrapper element for input XML data
     * @param rootTag the name of the root tag element
     * @param rowTag the name of the row tag element
     * @param elementTag the name of the element tag element
     * @param outWrapper the wrapper element for output XML data
     */
    public CsvToHtmlConverter(String inputFile, String outputFile, String delimiter, String inWrapper, String rootTag, String rowTag, String elementTag, String outWrapper) {
        super(inputFile, outputFile, delimiter);
        super.setInWrapper(inWrapper);
        super.setRootTag(rootTag);
        super.setRowTag(rowTag);
        super.setElementTag(elementTag);
        super.setOutWrapper(outWrapper);
    }

    /**
     * Converts CSV data to HTML format.
     */
    @Override
    public void convert() {
        super.convert();
    }
}
