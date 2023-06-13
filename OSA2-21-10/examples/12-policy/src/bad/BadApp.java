package bad;

import java.io.IOException;

import util.Util;

public class BadApp {

	public static void main(String[] args) throws IOException {
		Util util = new Util();

		util.readSystemProperties("os.name", "user.home", "java.version", "user.name", "java.vendor", "file.encoding");

		util.readFile("app/work/README.md");
		util.createOrAppendFile("app/work/output.txt");
		util.deleteFile("app/work/output.txt");

		util.readFile("app/config/config.properties");
		util.createOrAppendFile("app/config/payload.txt");

		util.writeToFile("app/logs/app.log");
		util.readFile("app/logs/app.log");
		util.deleteFile("app/logs/app.log");
	}

}
