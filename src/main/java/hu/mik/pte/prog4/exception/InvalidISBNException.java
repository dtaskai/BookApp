package hu.mik.pte.prog4.exception;

public class InvalidISBNException extends RuntimeException{
    public InvalidISBNException() {
    }

    public InvalidISBNException(String message) {
        super(message);
    }

    public InvalidISBNException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidISBNException(Throwable cause) {
        super(cause);
    }

    public InvalidISBNException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
