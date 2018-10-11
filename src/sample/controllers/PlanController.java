package sample.controllers;

import sample.data.Context;
import sample.models.Plan;
import sample.views.PlanView;

public class PlanController {
    private Context context = Context.getInstance();
    private int floorNumber = 0;

    private static PlanController ourInstance = new PlanController();

    public static PlanController getInstance() {
        return ourInstance;
    }

    private PlanController() {
    }

    public void update(){
        PlanView.getInstance().update(context.getPlan());
        FloorController.getInstance().update(floorNumber);
    }

    public Plan getPlan(){
        return context.getPlan();
    }
}
