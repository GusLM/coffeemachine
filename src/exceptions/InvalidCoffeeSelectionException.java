package exceptions;

public class InvalidCoffeeSelectionException extends RuntimeException {
    public InvalidCoffeeSelectionException(String message) {
        super(message);
    }
}
