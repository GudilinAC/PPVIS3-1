package sample.controllers;

import sample.data.Context;
import sample.models.Plan;

public class PlanController {
    private Context context = Context.getInstance();

    private static PlanController ourInstance = new PlanController();

    public static PlanController getInstance() {
        return ourInstance;
    }

    private PlanController() {
    }

    public Plan getPlan(){
        return context.getPlan();
    }
}
