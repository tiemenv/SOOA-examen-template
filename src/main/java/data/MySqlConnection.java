package data;

import util.PlaceholderException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    //TODO: change credentials
    private static final String URL = "jdbc:mysql://localhost/shop?useSSL=false";
    private static final String USER = "jdbc";
    private static final String PWD = "jdbcdemo";

    public static Connection getConnection(){
        try {
            Connection con = DriverManager.getConnection(URL, USER, PWD);
            return con;
        } catch (SQLException ex){
            throw new PlaceholderException("Can't connect to DB", ex);
        }
    }
}
