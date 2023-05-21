import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * This class represents a CsvConverter object that can read from and write to files.
 * @author Jakob Mayr
 */
public class CsvConverter {

    private Path inputPath;
    private Path outputPath;
    private String delimiter = ";";

    /**
     * Constructs a CsvConverter object with the specified input and output file paths and delimiter.
     * @param inputPath The input file path as a string.
     * @param outputPath The output file path as a string.
     * @param delimiter The delimiter to be used in the CSV file.
     */
    public CsvConverter(String inputPath, String outputPath, String delimiter) {
        this.inputPath = Path.of(inputPath);
        this.outputPath = Path.of(outputPath);
        this.delimiter = delimiter;
    }

    /**
     * Reads the content of the input file.
     * @return A string containing the content of the input file.
     * @throws ConverterException If there is an error reading the file.
     */
    public String readFile() {
        String input;
        try {
            input = Files.readString(inputPath);
        } catch (IOException e) {
            throw new ConverterException(inputPath.toString(), e);
        }
        return input;
    }

    /**
     * Writes the given content to the output file.
     * @param content The content to be written to the output file.
     * @throws ConverterException If there is an error writing to the file.
     */
    public void writeFile(String content) {
        try {
            Files.writeString(outputPath, content);
        } catch (IOException e) {
            throw new ConverterException(outputPath.toString(), e);
        }
    }

    /**
     * Returns the delimiter used in the CSV file.
     * @return A string representing the delimiter used in the CSV file.
     */
    public String getDelimiter() {
        return this.delimiter;
    }

}
