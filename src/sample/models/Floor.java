package sample.models;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Structure> structures= new ArrayList<>();

    public List<Structure> getStructures() {
        return structures;
    }

    public void setStructures(List<Structure> structures) {
        this.structures = structures;
    }
}
