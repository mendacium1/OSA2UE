package good;

import java.io.IOException;

import util.Util;

public class GoodApp {

	public static void main(String[] args) throws IOException {
		if (System.getSecurityManager() == null) {
			System.err.println("Security manager is not activated!");
		}

		Util util = new Util();

		util.readSystemProperties("os.name", "user.home", "java.version");

		util.readFile("app/work/README.md");
		util.createOrAppendFile("app/work/output.txt");
		util.deleteFile("app/work/output.txt");

		util.readFile("app/config/config.properties");

		util.writeToFile("app/logs/app.log");
	}

}
