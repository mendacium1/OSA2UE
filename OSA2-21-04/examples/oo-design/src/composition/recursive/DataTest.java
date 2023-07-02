package composition.recursive;

public class DataTest {

	public static void main(String[] args) {
		File file1 = new File("test.txt");
		File file2 = new File("example.pdf");
		File file3 = new File("sun.jpg");
		Folder folder1 = new Folder("alpha", 2);
		Folder folder2 = new Folder("beta", 4);

		folder1.addData(file1);
		folder1.addData(file2);

		folder2.addData(file3);
		folder2.addData(folder1);

		System.out.println(folder2);
	}

}
