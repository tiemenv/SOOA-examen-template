package ui;

import data.Repositories;
import domain.Doctor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import util.ConsultException;

import java.io.IOException;
import java.net.URL;

public class Login {

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField pwdPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    void attemptLogin(ActionEvent event) {
        String loggedInDoctorName = null;
        Doctor d = new Doctor(txtLogin.getCharacters().toString(), pwdPassword.getCharacters().toString());
        //check user in db
        try {
            loggedInDoctorName = Repositories.getDoctorRepository().loginDoctor(d);
        } catch (ConsultException ex) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setContentText(ex.getMessage());
            al.showAndWait();
        }
        System.out.println("loggedInDoctorName: " + loggedInDoctorName);
        if(loggedInDoctorName != null){
            //logged in! proceed to main menu screen and show all consults for the logged in Doctor's name
            showConsults(d);
        }

    }

    private void showConsults(Doctor d){
        try {
            URL fxmlURL = ClassLoader.getSystemResource("fxml/MainGui.fxml");
            FXMLLoader detailLoader = new FXMLLoader(fxmlURL);

            SplitPane root = detailLoader.load();
            MainGui mainGui = detailLoader.getController();

            Scene scene = new Scene(root);

            Stage stage = new Stage();

            mainGui.setStage(stage);
            mainGui.initialize(d);
            stage.setScene(scene);

            stage.showAndWait();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void register(ActionEvent event) {
        Doctor d = new Doctor(txtLogin.getCharacters().toString(), pwdPassword.getCharacters().toString());
        System.out.println("Trying to add doctor " + d.getName() + " with hashed pw: " + d.getPassword());
        //todo: if this succeeds, display a message or smth? -> Nice To Have
        //TODO: check if user already exists and if not display message to user -> Nice To Have
        try {
            Repositories.getDoctorRepository().addDoctor(d);
        } catch (ConsultException ex) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setContentText(ex.getMessage());
            al.showAndWait();
        }
    }

}
