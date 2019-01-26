package ui;

import data.Repositories;
import domain.Consult;
import domain.ConsultBuilder;
import domain.Doctor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import util.ConsultException;
import java.util.*;

public class MainGui {

    //TODO: Detail view of selected consultation -> Out of time!
    //On click I would have fetched the selected serialized object and deserialize it, fill in the JavaFX textFields
    //with all the fields from the deserialized object and would have added a "back" button taking you back
    //to the main GUI

    @FXML
    private ListView<Consult> consults;

    @FXML
    private TextField namePatient;

    @FXML
    private TextField birthDatePatient;

    @FXML
    private TextField nameICE;

    @FXML
    private TextField phoneICE;

    @FXML
    private TextField nameDoctor;

    @FXML
    private TextArea symptomps;

    @FXML
    private TextArea diagnostics;

    @FXML
    private TextArea drugs;

    @FXML
    private TextArea notes;

    @FXML
    private Button btnDone;

    @FXML
    private TextField addressPatient1;

    @FXML
    private TextField addressPatient2;

    @FXML
    private TextField addressICE1;

    @FXML
    private TextField addressICE2;


    private Stage stage;

    public static ObservableList<Consult> consultObservableList;

    @FXML
    void initialize(Doctor d) {
        //TODO: make the first login window disappear! -> Nice To Have
        ArrayList<String> filenames = Repositories.getDoctorRepository().getConsultFilenames(d);
        getAllConsults(filenames);
    }

    private void getAllConsults(ArrayList<String> filenames) {
        //initialize listview by fetching all filenames returned by get_all_filenames in data
        ArrayList<Consult> consultObjects = new ArrayList<>();

        for(String filename: filenames){
            try {
                Consult consult = Repositories.getConsultRepository().getConsult(filename);
                consultObjects.add(consult);
            } catch (ConsultException ex) {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setContentText(ex.getMessage());
                al.showAndWait();
            }
        }
        consultObservableList = FXCollections.observableList(consultObjects);
        consults.setItems(consultObservableList);
    }

    @FXML
    void addConsult(ActionEvent event) {
        System.out.println("attempting to add consult as file");
        //extract values from textFields
        //TODO: extract all other values -> No more time
        //TODO: Crashes when we enter on of those multi-textbox fields, no more time to figure it out tho :(
        //TODO: didn't see some fields had 4 textboxes! -> Doesn't render right in SceneBuilder tho, let's leave them, out of time
        String patientName = namePatient.getCharacters().toString();
        String patientBirthDate = birthDatePatient.getCharacters().toString();
//        String patientAddress = addressPatient1.getCharacters().toString() + "\n" + addressPatient2.getCharacters().toString();
        String nameIce = nameICE.getCharacters().toString();
        String phoneIce = phoneICE.getCharacters().toString();
//        String ICEAddress = addressICE1.getCharacters().toString() + "\n" + addressICE2.getCharacters().toString();
        String doctorName = nameDoctor.getCharacters().toString();
        String symptoms = symptomps.getText();
        //construct a Consult object with the Builder
        Consult consult = new ConsultBuilder()
                .setNamePatient(patientName)
                .setBirthDatePatient(patientBirthDate)
//                .setAddressPatient(patientAddress)
                .setNameICE(nameIce)
                .setPhoneICE(phoneIce)
//                .setAddressICE(ICEAddress)
                .setNameDoctor(doctorName)
                .setSymptoms(symptoms)
                .createConsult();
        //serialize and store to file
        try {
            Repositories.getConsultRepository().addConsult(consult);
            //keep observable listview up to date
            consultObservableList.add(consult);
        } catch (ConsultException ex) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setContentText(ex.getMessage());
            al.showAndWait();
        }
        //store filename + doctors name to db table
        try {
            Repositories.getDoctorRepository().addConsultFilename(patientName + ".ser", doctorName);
        } catch (ConsultException ex) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setContentText(ex.getMessage());
            al.showAndWait();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


}
