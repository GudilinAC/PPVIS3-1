package sample.models;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private String name = "New floor";
    private List<Structure> structures= new ArrayList<>();

    public List<Structure> getStructures() {
        return structures;
    }

    public void setStructures(List<Structure> structures) {
        this.structures = structures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
