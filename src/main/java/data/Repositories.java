package data;

public class Repositories {
    private static Repositories instance = new Repositories();

    public static Repositories getInstance(){
        return instance;
    }

    public Repository getRepository(){
        return new MySqlRepository();
    }
}
