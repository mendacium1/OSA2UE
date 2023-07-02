public class QuadrangleTest {

	public static void main(String[] args) {
		Quadrangle[] quadrangles = new Quadrangle[3];

		quadrangles[0] = new Square(4);
		quadrangles[1] = new Parallelogram(5, 7, 20);
		quadrangles[2] = new Rectangle(8, 3);

		int area = 0;
		for (int i = 0; i < quadrangles.length; i++) {
			area += quadrangles[i].getArea();
		}
	}

}
