package sample.controllers;

import sample.data.Context;

public class PlanController {
    private Context context = Context.getInstance();

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
