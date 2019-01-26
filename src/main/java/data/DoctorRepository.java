package data;

import domain.Doctor;

import java.util.ArrayList;
import java.util.HashMap;

public interface DoctorRepository {
    int addDoctor(Doctor d);
    String loginDoctor(Doctor d);
    ArrayList<String> getConsultFilenames(Doctor d);
    int addConsultFilename(String filename, String doctorName);
}
