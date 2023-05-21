/**
 * The Point class represents a point in a two-dimensional Cartesian coordinate system.
 */
public class Point {

    private double x;
    private double y;

    /**
     * Constructs a point with the given x and y coordinates.
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Calculates the Euclidean distance between the current point and the specified point.
     * @param p
     * @return the distance
     */
    public double distance(Point p){
        double distance = Math.sqrt((p.y - y) * (p.y - y) + (p.x - x) * (p.x - x));
        return distance;
    }
}
