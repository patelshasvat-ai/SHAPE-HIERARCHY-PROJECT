/**
 * Custom unchecked exception thrown when a shape dimension is invalid.
 *
 * CHECKED vs UNCHECKED decision:
 *   This is declared as UNCHECKED (extends RuntimeException) because dimension
 *   errors represent programming mistakes (passing bad values) rather than
 *   recoverable external conditions. Callers should validate input before
 *   constructing shapes, so forcing a checked exception would add boilerplate
 *   without benefit.
 */
public class InvalidShapeException extends RuntimeException {

    public InvalidShapeException(String message) {
        super(message);
    }
}
