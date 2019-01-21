package data;

import util.PlaceholderException;


public class Repositories {

    private static MySqlRepository mySqlRepository = new MySqlRepository();

    private Repositories(){

    }

    public static MySqlRepository getMySqlRepository() {return mySqlRepository;}


}
