package sample.models;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    private List<Floor> floors;

    public Plan(){
        floors = new ArrayList<>();
        floors.add(new Floor());
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
