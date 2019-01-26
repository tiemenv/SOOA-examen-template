package data;


public class Repositories {

    private static DoctorRepositoryMySql doctorRepository = new DoctorRepositoryMySql();
    private static ConsultRepositoryFlatFile consultRepository = new ConsultRepositoryFlatFile();

    private Repositories() {

    }

    public static DoctorRepositoryMySql getDoctorRepository() {
        return doctorRepository;
    }

    public static ConsultRepositoryFlatFile getConsultRepository(){
        return consultRepository;
    }


}
