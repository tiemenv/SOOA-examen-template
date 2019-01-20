package data;

public class Secret {
    private static String connString = "jdbc:sqlserver://java-todo.database.windows.net:1433;database=Todo;user=paus@java-todo;password=06iDjxbG4dCjhwgcSy3P;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    public static String getConnString() {
        return connString;
    }
}
