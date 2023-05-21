public class Triangle {

    private Point pointA;
    private Point pointB;
    private Point pointC;

    /**
     * Cunstructor for the Triangle class. Throws exception if the triangle is not valid.
     * @param a
     * @param b
     * @param c
     */
    public Triangle(Point a, Point b, Point c) {
        if (!isValid(a, b, c))
            throw new IllegalArgumentException("No valid triangle possible with given points!");
        this.pointA = a;
        this.pointB = b;
        this.pointC = c;
    }

    /**
     * Calculate the perimeter of the triangle.
     *
     * @return perimeter
     */
    public double perimeter(){
        double perimeter = 0;
        perimeter += pointA.distance(pointB);
        perimeter += pointB.distance(pointC);
        perimeter += pointA.distance(pointC);
        return perimeter;
    }

    /**
     * Calculate the area of the triangle with the heron formula.
     *
     * @return the area
     */
    public double area() {
        double semiPerimeter = perimeter() / 2;
        double area = Math.sqrt(semiPerimeter * (semiPerimeter - pointA.distance(pointB))
                * (semiPerimeter - pointB.distance(pointC)) * (semiPerimeter - pointA.distance(pointC)));
        return area;
    }

    /**
     * Since there a geometrical rules for a triangle you need to validate it.
     * This function checks if no points share the same coordinates.
     * This function also checks if the sum of the two shorter sides is shorter than the longest side.
     *
     * @return true if valid triangle and false otherwise
     */
    private boolean isValid(Point a, Point b, Point c) {
        return (a.distance(b) > 0 && b.distance(c) > 0 && a.distance(c) > 0)
                && a.distance(b) + b.distance(c) > a.distance(c)
                && b.distance(c) + a.distance(c) > a.distance(b)
                && a.distance(b) + a.distance(c) > b.distance(c);
    }
}
