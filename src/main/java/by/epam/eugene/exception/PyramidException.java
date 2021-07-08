package by.epam.eugene.exception;

public class PyramidException extends Exception{
    public PyramidException() {
        super();
    }

    public PyramidException(String message) {
        super(message);
    }

    public PyramidException(String message, Throwable cause) {
        super(message, cause);
    }

    public PyramidException(Throwable cause) {
        super(cause);
    }
}
