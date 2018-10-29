package sample.models;

import java.util.ArrayList;

public class Plan {
    private ArrayList<Floor> floors;

    public Plan(){
        floors = new ArrayList<>();
        floors.add(new Floor());
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }
}
