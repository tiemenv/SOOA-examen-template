package data;

import domain.Consult;
import domain.Doctor;
import util.ConsultException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ConsultRepositoryFlatFile implements ConsultRepository {

    @Override
    public int addConsult(Consult c) {

        File f = new File("src/main/resources/ser/" + c.getNamePatient() + ".ser");
        //if the consult exists already, don't overwrite it! Throw an exception instead
        if (!f.exists()) {
            try (
                    FileOutputStream fos = new FileOutputStream(f, false);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(c);
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new ConsultException("Unable to add consult to file ", ex);
            }
        }
        return 0;
    }


    @Override
    public Consult getConsult(String filename) {
        File f = new File("src/main/resources/ser/" + filename);

        try (
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            Consult c = (Consult) ois.readObject();
            return c;

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new ConsultException("Unable to get consult from file ", ex);
        }
    }


}
