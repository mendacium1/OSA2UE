package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Util {

	public void readSystemProperties(final String... propertynames) {
		for (String propertyname : propertynames) {
			readSystemProperty(propertyname);
		}
		System.out.println();
	}

	private void readSystemProperty(final String propertyname) {
		System.out.println(propertyname + ": " + System.getProperty(propertyname));
	}

	public void readFile(final String path) throws IOException {
		System.out.println("Read " + path);
		System.out.println(String.join(System.lineSeparator(), Files.readAllLines(Path.of(path))));
		System.out.println();
	}

	public void createOrAppendFile(final String path) throws IOException {
		System.out.println("Create or append " + path);
		Files.writeString(Path.of(path), "my output", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		System.out.println();
	}

	public void deleteFile(final String path) throws IOException {
		System.out.println("Deleted " + path + ": " + Files.deleteIfExists(Path.of(path)));
		System.out.println();
	}

	public void writeToFile(final String path) throws IOException {
		System.out.println("Write " + path);
		Files.writeString(Path.of(path), "[info] my log\n", StandardOpenOption.APPEND);
		System.out.println();
	}
}
