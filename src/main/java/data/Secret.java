package data;

public class Secret {
    private static String connString = "connString";

    private Secret() {
    }

    public static String getConnString() {
        return connString;
    }
}
