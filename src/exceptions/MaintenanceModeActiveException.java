package exceptions;

public class MaintenanceModeActiveException extends RuntimeException {
    public MaintenanceModeActiveException(String message) {
        super(message);
    }
}
