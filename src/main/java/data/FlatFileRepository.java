package data;

import domain.PlaceholderObject;
import util.PlaceholderException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FlatFileRepository implements Repository {

    //TODO: rename json file to reflect objects stored
    //TODO: mixmatch of serialization and flatfile storage

    private File f = new File("placeholder.json");

    @Override
    public int addPlaceholderObject(PlaceholderObject po) {
        File f = new File(po.getName() + ".ser");

        try (
                FileOutputStream fos = new FileOutputStream(f, false);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(po);
        } catch (IOException ex) {
            throw new PlaceholderException("Unable to add placeholderObject ", ex);
        }

        return 0;
    }

    @Override
    public void deletePlaceholderObject(PlaceholderObject po) {
        //TODO: implement if needed
    }

    @Override
    public void updatePlaceholderObject(PlaceholderObject po) {
        //TODO implement if needed
    }

    @Override
    public PlaceholderObject getPlaceholderObject(String name) {
        File f = new File(name + ".ser");

        try (
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis)
                ) {
            PlaceholderObject po = (PlaceholderObject) ois.readObject();
            return po;

        } catch (IOException | ClassNotFoundException ex){
            throw new PlaceholderException("Unable to get object from file ", ex);
        }
    }

    @Override
    public ArrayList<PlaceholderObject> getPlaceholderObjects() {
        ArrayList<PlaceholderObject> pos = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream(f);
                Scanner s = new Scanner(fis)
        ) {
            while (s.hasNextLine()) {
                String poName = s.nextLine();
                int poId = parseInt(s.nextLine());
                pos.add(new PlaceholderObject(poName, poId));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pos;
    }
}
