/**
 * Abstract base class for all geometric shapes.
 *
 * WHY ABSTRACT?
 *   "Shape" is a concept — there is no meaningful standalone shape without
 *   a specific geometry (circle, rectangle, etc.). Declaring it abstract
 *   prevents anyone from calling  new Shape()  directly.
 *   If you attempt  new Shape()  the compiler immediately gives:
 *     "Shape is abstract; cannot be instantiated"
 */
public abstract class Shape {

    protected String  color  = "white";
    protected boolean filled;

    /** No-arg constructor — defaults to white, unfilled. */
    public Shape() { }

    /** Full constructor. */
    public Shape(String color, boolean filled) {
        this.color  = color;
        this.filled = filled;
    }

    // ---------- Abstract methods ----------
    public abstract double getArea();
    public abstract double getPerimeter();

    /**
     * Scales every linear dimension of the shape by the given factor.
     * Throws InvalidShapeException if factor <= 0.
     */
    public abstract void resize(double factor);

    // ---------- Getters / Setters ----------
    public String  getColor()           { return color; }
    public boolean isFilled()           { return filled; }
    public void    setColor(String c)   { this.color  = c; }
    public void    setFilled(boolean f) { this.filled = f; }

    @Override
    public String toString() {
        return String.format("Shape[color=%s, filled=%s, area=%.2f, perimeter=%.2f]",
                color, filled, getArea(), getPerimeter());
    }
}
