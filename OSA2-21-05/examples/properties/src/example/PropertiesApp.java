package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesApp {

	public static void main(String[] args) {
		File file = new File("example.properties");
		Properties props = new Properties();

		try (InputStream in = new FileInputStream(file)) {
			props.load(in);
		} catch (IOException e) {
			System.err.println("Error while reading properties file: " + e.getMessage());
		}

		System.out.println(String.format("The value for the key \"%s\" is \"%s\".\n", "two", props.get("two")));
		System.out.println(String.format("The value for the key \"%s\" is \"%s\".\n", "foo", props.get("foo")));

		for (Entry<Object, Object> entry : props.entrySet()) {
			System.out.println(String.format("[%s] %s", entry.getKey(), entry.getValue()));
		}

		props.put("now", LocalDateTime.now().toString());

		try (OutputStream out = new FileOutputStream(file)) {
			props.store(out, "Just to show you how it works.");
		} catch (IOException e) {
			System.err.println("Error while writing properties file: " + e.getMessage());
		}

	}

}
