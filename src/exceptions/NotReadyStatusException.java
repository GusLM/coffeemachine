package exceptions;

public class NotReadyStatusException extends RuntimeException {
    public NotReadyStatusException(String message) {
        super(message);
    }
}
