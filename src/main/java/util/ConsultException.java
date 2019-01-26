package util;

public class ConsultException extends RuntimeException {
    public ConsultException(String msg) {
        super(msg);
    }

    public ConsultException(String msg, java.lang.Exception ex) {
        super(msg, ex);

    }
}
