package data;

public class Repositories {
    private static Repository instance = new MySqlRepository();

    private Repositories() {
    }

    public static Repository getInstance() {
        return instance;
    }

//    /**
//     * buggy code, making a new repository each time this function gets called can cause problems with concurrency
//     */
//    public Repository getRepository() {
//
//        return new MySqlRepository();
//    }
}
