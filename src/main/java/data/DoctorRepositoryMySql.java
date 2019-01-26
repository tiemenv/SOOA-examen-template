package data;

import domain.Doctor;
import org.mindrot.jbcrypt.BCrypt;
import util.ConsultException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DoctorRepositoryMySql implements DoctorRepository {

    private static final String SQL_ADD_DOCTOR = "INSERT INTO `doctordb`.`doctor` (`login`, `password`) VALUES (?, ?);";
    private static final String SQL_GET_DOCTOR = "SELECT login, password FROM `doctordb`.`doctor` WHERE `login` = ?;";
    private static final String SQL_ADD_FILENAME = "INSERT INTO `doctordb`.`consult` (`doctor_login`, `filename`) VALUES (?, ?);";
    private static final String SQL_GET_FILENAMES = "SELECT id, filename FROM `doctordb`.`consult` WHERE `doctor_login` = ?;";


    @Override
    public int addDoctor(Doctor d) {
        try (
                Connection con = MySqlConnection.getConnection();
                PreparedStatement prep = con.prepareStatement(SQL_ADD_DOCTOR);
                ) {
            System.out.println("adding doctor");
            prep.setString(1, d.getName());
            prep.setString(2, BCrypt.hashpw(d.getPassword(),BCrypt.gensalt(11)));
            prep.executeUpdate();
        } catch (SQLException ex){
            throw new ConsultException("Unable to add doctor to db ", ex);
        }
        return 0;
    }

    @Override
    public String loginDoctor(Doctor d) {
        try (
                Connection con = MySqlConnection.getConnection();
                PreparedStatement prep = con.prepareStatement(SQL_GET_DOCTOR);
        ) {
            System.out.println("checking if doctor credentials exist for name: " + d.getName());
            prep.setString(1, d.getName());
            try (ResultSet rs = prep.executeQuery()) {
                //check if it returns a result
                if (rs.next()) {
                    String login = rs.getString("login");
                    String password = rs.getString("password");
                    System.out.println("Found a login! login: "+ login + " password: " + password);
                    if(BCrypt.checkpw(d.getPassword(), password)){
                        return d.getName();
                    }
                }
            }
        } catch (SQLException ex){
            throw new ConsultException("Wrong login ", ex);
        }
        return null;
    }

    @Override
    public ArrayList<String> getConsultFilenames(Doctor d) {

        ArrayList<String> filenames = new ArrayList<>();
        try (
                Connection con = MySqlConnection.getConnection();
                PreparedStatement prep = con.prepareStatement(SQL_GET_FILENAMES);
        ) {
            prep.setString(1,loginDoctor(d));
            try (ResultSet rs = prep.executeQuery()) {
                while (rs.next()) {
                    String filename = rs.getString("filename");
                    filenames.add(filename);
                }
                return filenames;
            }
        } catch (SQLException ex) {
            throw new ConsultException("Can't fetch filenames from DB", ex);
        }
    }

    @Override
    public int addConsultFilename(String filename, String doctorName) {
        try (
                Connection con = MySqlConnection.getConnection();
                PreparedStatement prep = con.prepareStatement(SQL_ADD_FILENAME);
        ) {
            System.out.println("adding filename to doctor's list");
            //switched the arguments around at first, let's fix that here
            prep.setString(1, doctorName);
            prep.setString(2, filename);
            prep.executeUpdate();
        } catch (SQLException ex){
            throw new ConsultException("Unable to add filename to db ", ex);
        }
        return 0;
    }


}
