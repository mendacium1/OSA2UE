package composition.recursive;

public class Folder implements Data {

	String path;
	Data[] data;
	int dataCounter;
	int maxItems;

	public Folder(String path, int maxItems) {
		this.path = path;
		data = new Data[10];
		dataCounter = 0;
		this.maxItems = maxItems;
	}

	void addData(Data data) {
		if (dataCounter < maxItems) {
			this.data[dataCounter++] = data;
		}
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Folder [path=").append(path);
		if (dataCounter > 0) {
			builder.append(", contents: ");
			for (int i = 0; i < dataCounter; i++) {
				builder.append(data[i]);
				if (i < (dataCounter - 1)) {
					builder.append(", ");
				}
			}
		}
		builder.append("]");
		return builder.toString();
	}

}
