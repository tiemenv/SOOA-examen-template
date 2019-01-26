package data;

import domain.Consult;


public interface ConsultRepository {
    int addConsult(Consult c);
    Consult getConsult(String filename);
}

