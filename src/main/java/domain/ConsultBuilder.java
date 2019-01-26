package domain;

public class ConsultBuilder {
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

    public ConsultBuilder setNamePatient(String namePatient) {
        this.namePatient = namePatient;
        return this;
    }

    public ConsultBuilder setBirthDatePatient(String birthDatePatient) {
        this.birthDatePatient = birthDatePatient;
        return this;
    }

    public ConsultBuilder setAddressPatient(String addressPatient) {
        this.addressPatient = addressPatient;
        return this;
    }

    public ConsultBuilder setNameICE(String nameICE) {
        this.nameICE = nameICE;
        return this;
    }

    public ConsultBuilder setPhoneICE(String phoneICE) {
        this.phoneICE = phoneICE;
        return this;
    }

    public ConsultBuilder setAddressICE(String addressICE) {
        this.addressICE = addressICE;
        return this;
    }

    public ConsultBuilder setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
        return this;
    }

    public ConsultBuilder setSymptoms(String symptoms) {
        this.symptoms = symptoms;
        return this;
    }

    public ConsultBuilder setDiagnostics(String diagnostics) {
        this.diagnostics = diagnostics;
        return this;
    }

    public ConsultBuilder setDrugs(String drugs) {
        this.drugs = drugs;
        return this;
    }

    public ConsultBuilder setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Consult createConsult() {
        return new Consult(namePatient, birthDatePatient, addressPatient, nameICE, phoneICE, addressICE, nameDoctor, symptoms, diagnostics, drugs, notes);
    }
}