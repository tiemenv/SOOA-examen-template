import data.MySqlRepository;
import domain.PlaceholderObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class MySqlRepositoryTest {

    private MySqlRepository repo;

    @Before
    public void initRepoAndDb() throws IOException {
        initDb();
        repo = new MySqlRepository();
    }

    private static void initDb() throws IOException {
        Process process = Runtime.getRuntime().exec("./src/test/resources/resetDb.sh");
        java.util.Scanner s = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
        System.out.println(s.hasNext() ? s.next() : "");
        s = new java.util.Scanner(process.getErrorStream()).useDelimiter("\\A");
        System.out.println(s.hasNext() ? s.next() : "");
    }

    @Test
    public void getObjects() {
        //check length
        List<PlaceholderObject> ProductsInDB = repo.getPlaceholderObjects();
        assertEquals(16, ProductsInDB.size());
    }

    @Test
    public void getObject(){
        //TODO: construct our object
        PlaceholderObject po = new PlaceholderObject();
        //TODO: add right id
        assertEquals(po, repo.getPlaceholderObject(1));
    }

    @Test
    public void addObject(){
        PlaceholderObject po = new PlaceholderObject ();
        repo.addPlaceholderObject(po);
        //TODO: insert actual numbers
        assertEquals(16+1, repo.getPlaceholderObjects().size());
    }

    @Test
    public void updatePlaceholderObject(){
        //TODO: insert actual numbers
        PlaceholderObject po = repo.getPlaceholderObject(1);
        //update po with something
        repo.updatePlaceholderObject(po);
        assertEquals(po, repo.getPlaceholderObject(1));
    }

    @AfterClass
    public static void resetDb() throws IOException{
        initDb();
    }
}