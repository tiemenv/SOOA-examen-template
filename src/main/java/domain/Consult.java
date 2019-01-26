package domain;

import java.io.Serializable;

public class Consult implements Serializable {

        private String namePatient;
        private String birthDatePatient;
        private String addressPatient;
        private String nameICE;
        private String phoneICE;
        private String addressICE;
        private String nameDoctor;
        private String symptoms;
        private String diagnostics;
        private String drugs;
        private String notes;


    public Consult(String namePatient, String birthDatePatient, String addressPatient, String nameICE, String phoneICE, String addressICE, String nameDoctor, String symptoms, String diagnostics, String drugs, String notes) {
        this.namePatient = namePatient;
        this.birthDatePatient = birthDatePatient;
        this.addressPatient = addressPatient;
        this.nameICE = nameICE;
        this.phoneICE = phoneICE;
        this.addressICE = addressICE;
        this.nameDoctor = nameDoctor;
        this.symptoms = symptoms;
        this.diagnostics = diagnostics;
        this.drugs = drugs;
        this.notes = notes;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public String getBirthDatePatient() {
        return birthDatePatient;
    }

    public String getAddressPatient() {
        return addressPatient;
    }

    public String getNameICE() {
        return nameICE;
    }

    public String getPhoneICE() {
        return phoneICE;
    }

    public String getAddressICE() {
        return addressICE;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getDiagnostics() {
        return diagnostics;
    }

    public String getDrugs() {
        return drugs;
    }

    public String getNotes() {
        return notes;
    }


    @Override
    public String toString() {
        return
                "Name: " + namePatient;
    }
}
