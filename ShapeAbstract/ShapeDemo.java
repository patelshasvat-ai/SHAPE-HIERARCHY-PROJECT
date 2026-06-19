/**
 * ShapeDemo -- demonstrates the Shape hierarchy.
 * Shows polymorphism, dynamic binding, exception handling, and the printAreas / largest methods.
 */
public class ShapeDemo {

    // ---------- Task: printAreas ----------
    /**
     * Prints the area of each shape using a superclass reference.
     * Dynamic binding ensures the correct subclass getArea() is called at runtime.
     *
     * DYNAMIC BINDING EXPLANATION:
     *   When we write  shapes[i].getArea()  the variable type is Shape (compile-time),
     *   but Java resolves the actual method at RUNTIME based on the real object type
     *   (Circle, Rectangle, or Triangle). This is dynamic (late) binding.
     *   Example output line:
     *     "Circle[...] -> Area = 78.54"
     *   Even though shapes[i] is declared as Shape, Java calls Circle.getArea(), not
     *   some hypothetical Shape.getArea(), proving polymorphism in action.
     */
    public static void printAreas(Shape[] shapes) {
        System.out.println("\n--- Areas (dynamic binding) ---");
        for (Shape s : shapes) {
            System.out.printf("  %-70s -> Area = %.2f%n", s.toString(), s.getArea());
        }
    }

    // ---------- Task: largest ----------
    public static Shape largest(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) return null;
        Shape max = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > max.getArea()) max = shapes[i];
        }
        return max;
    }

    // ---------- main ----------
    public static void main(String[] args) {

        // --- Valid shapes ---
        Shape[] shapes = {
            new Circle(5, "red", true),
            new Rectangle(4, 6, "blue", false),
            new Triangle(3, 4, 5, "green", true)
        };

        printAreas(shapes);

        Shape big = largest(shapes);
        System.out.println("\n--- Largest shape ---");
        System.out.println("  " + big);

        // --- Demonstrate resize ---
        System.out.println("\n--- Resize Circle by factor 2 ---");
        Circle c = (Circle) shapes[0];
        System.out.println("  Before: " + c);
        c.resize(2);
        System.out.println("  After:  " + c);

        // --- Demonstrate InvalidShapeException ---
        System.out.println("\n--- Exception: invalid triangle (1, 2, 10) ---");
        try {
            Triangle bad = new Triangle(1, 2, 10);   // violates triangle inequality
            System.out.println("  Created: " + bad);
        } catch (InvalidShapeException e) {
            System.out.println("  Caught InvalidShapeException: " + e.getMessage());
        }

        System.out.println("\n--- Exception: non-positive resize factor ---");
        try {
            shapes[1].resize(-3);
        } catch (InvalidShapeException e) {
            System.out.println("  Caught InvalidShapeException: " + e.getMessage());
        }

        // --- Demonstrate negative radius ---
        System.out.println("\n--- Exception: negative circle radius ---");
        try {
            new Circle(-1);
        } catch (InvalidShapeException e) {
            System.out.println("  Caught InvalidShapeException: " + e.getMessage());
        }
    }
}
