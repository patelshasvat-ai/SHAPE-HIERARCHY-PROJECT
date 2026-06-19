/**
 * A triangle defined by three side lengths.
 * Validates the triangle inequality: each side must be less than the sum of the other two.
 */
public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double a, double b, double c) {
        validateSides(a, b, c);
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    public Triangle(double a, double b, double c, String color, boolean filled) {
        super(color, filled);
        validateSides(a, b, c);
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    private void validateSides(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new InvalidShapeException(
                    "All triangle sides must be positive, got: " + a + ", " + b + ", " + c);
        if (a + b <= c || a + c <= b || b + c <= a)
            throw new InvalidShapeException(
                    "Triangle inequality violated: sides " + a + ", " + b + ", " + c);
    }

    /** Heron's formula for area. */
    @Override
    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override public double getPerimeter() { return sideA + sideB + sideC; }

    @Override
    public void resize(double factor) {
        if (factor <= 0) throw new InvalidShapeException(
                "Resize factor must be positive, got: " + factor);
        sideA *= factor;
        sideB *= factor;
        sideC *= factor;
    }

    @Override
    public String toString() {
        return String.format(
                "Triangle[color=%s, filled=%s, sides=(%.2f,%.2f,%.2f), area=%.2f, perimeter=%.2f]",
                color, filled, sideA, sideB, sideC, getArea(), getPerimeter());
    }
}
