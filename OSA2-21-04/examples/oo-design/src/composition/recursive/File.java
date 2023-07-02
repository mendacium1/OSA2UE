package composition.recursive;

public class File implements Data {

	String path;

	public File(String path) {
		this.path = path;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		return "File [path=" + path + "]";
	}

}
