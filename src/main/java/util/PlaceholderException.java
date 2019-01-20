package util;

public class PlaceholderException extends RuntimeException {
    public PlaceholderException(String msg) {
        super(msg);
    }

    public PlaceholderException(String msg, java.lang.Exception ex) {
        super(msg, ex);

    }
}
