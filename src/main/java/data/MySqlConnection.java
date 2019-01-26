package data;

import util.ConsultException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static final String URL = "jdbc:mysql://localhost/doctordb?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "sooa";
    private static final String PWD = "sooa";

    public static Connection getConnection(){
        try {
            Connection con = DriverManager.getConnection(URL, USER, PWD);
            return con;
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new ConsultException("Can't connect to DB", ex);
        }
    }
}
