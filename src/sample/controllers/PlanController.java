package sample.controllers;

import sample.data.Data;

public class PlanController {
    private Data context = Data.getInstance();

    private static PlanController ourInstance = new PlanController();

    public static PlanController getInstance() {
        return ourInstance;
    }

    private PlanController() {
    }

    public void update(Integer floor){
        if (floor == null) { floor = FloorController.getInstance().getCurrentFloor(); }
        FloorController.getInstance().setFloor(floor);
        StatsController.getInstance().setFloor(floor);
    }
}
