package data;

import domain.PlaceholderObject;

import java.util.ArrayList;

public interface Repository {
    //TODO: update interface to reflect required methods
    int addPlaceholderObject(PlaceholderObject po);
    void deletePlaceholderObject(PlaceholderObject po);
    void updatePlaceholderObject(PlaceholderObject po);
    PlaceholderObject getPlaceholderObject(int id);
    ArrayList<PlaceholderObject> getPlaceholderObjects();
}

