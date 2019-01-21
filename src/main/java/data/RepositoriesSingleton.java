package data;

public class RepositoriesSingleton {
    private static RepositoriesSingleton ourInstance = new RepositoriesSingleton();

    public static RepositoriesSingleton getInstance() {
        return ourInstance;
    }

    private RepositoriesSingleton() {
    }
}
