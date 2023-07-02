/**
 * Base class for {@link Quadrangle} implementations.
 *
 * @author Claudia
 * @version 1.0
 */
public abstract class AbstractQuadrangle implements Quadrangle {

	/*
	 * (non-Javadoc)
	 * @see Quadrangle#compareBySize(Quadrangle)
	 */
	@Override
	public int compareBySize(Quadrangle q) {
		double size = getArea();
		double otherSize = q.getArea();
		return size < otherSize ? -1 : size > otherSize ? 1 : 0;
	}

}