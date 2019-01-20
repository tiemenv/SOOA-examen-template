package data;

import domain.PlaceholderObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlRepository implements Repository {

    //TODO: write SQL
    private static final String SQL_STATEMENT = "SQL statement";

    @Override
    public int addPlaceholderObject(PlaceholderObject po) {
        return 0;
    }

    @Override
    public void deletePlaceholderObject(PlaceholderObject po) {

    }

    @Override
    public void updatePlaceholderObject(PlaceholderObject po) {

    }

    @Override
    public PlaceholderObject getPlaceholderObject(int id) {
        return null;
    }

    @Override
    public ArrayList<PlaceholderObject> getPlaceholderObjects() {
        return null;
    }
}
