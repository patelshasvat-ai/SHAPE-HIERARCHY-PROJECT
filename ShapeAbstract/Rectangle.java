/**
 * A rectangle defined by width and height.
 */
public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        validateDimensions(width, height);
        this.width  = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        validateDimensions(width, height);
        this.width  = width;
        this.height = height;
    }

    private void validateDimensions(double w, double h) {
        if (w <= 0 || h <= 0) throw new InvalidShapeException(
                "Rectangle dimensions must be positive, got width=" + w + " height=" + h);
    }

    @Override public double getArea()      { return width * height; }
    @Override public double getPerimeter() { return 2 * (width + height); }

    @Override
    public void resize(double factor) {
        if (factor <= 0) throw new InvalidShapeException(
                "Resize factor must be positive, got: " + factor);
        width  *= factor;
        height *= factor;
    }

    public double getWidth()  { return width; }
    public double getHeight() { return height; }

    @Override
    public String toString() {
        return String.format(
                "Rectangle[color=%s, filled=%s, width=%.2f, height=%.2f, area=%.2f, perimeter=%.2f]",
                color, filled, width, height, getArea(), getPerimeter());
    }
}
