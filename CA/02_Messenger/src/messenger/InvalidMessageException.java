package messenger;

public class InvalidMessageException extends Exception {
    public InvalidMessageException() {
        super("Invalid message");
    }
}
