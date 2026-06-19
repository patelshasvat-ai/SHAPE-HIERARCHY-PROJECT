/**
 * A circle defined by its radius.
 */
public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        validateRadius(radius);
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        validateRadius(radius);
        this.radius = radius;
    }

    private void validateRadius(double r) {
        if (r <= 0) throw new InvalidShapeException(
                "Circle radius must be positive, got: " + r);
    }

    @Override public double getArea()      { return Math.PI * radius * radius; }
    @Override public double getPerimeter() { return 2 * Math.PI * radius; }

    @Override
    public void resize(double factor) {
        if (factor <= 0) throw new InvalidShapeException(
                "Resize factor must be positive, got: " + factor);
        radius *= factor;
    }

    public double getRadius() { return radius; }

    @Override
    public String toString() {
        return String.format("Circle[color=%s, filled=%s, radius=%.2f, area=%.2f, perimeter=%.2f]",
                color, filled, radius, getArea(), getPerimeter());
    }
}
