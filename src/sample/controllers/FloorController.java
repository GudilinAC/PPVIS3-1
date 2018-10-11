package sample.controllers;

import sample.data.Context;
import sample.models.Dot;
import sample.models.Tools;
import sample.views.FloorView;

public class FloorController {
    private Context context = Context.getInstance();
    private Tools tool;
    private Dot previousDot;

    private static FloorController ourInstance = new FloorController();

    public static FloorController getInstance() {
        return ourInstance;
    }

    private FloorController() {
    }

    public void mousePress(Dot dot){
        if (previousDot == null){
            previousDot = dot;
        }
        else {
                context.getPlan().getFloors().get(/**/0/**/).getStructures().add(StructureController.getInstance().createStructure(tool, previousDot, dot));
                previousDot = null;
                tool = null;
                MainController.getInstance().update();
        }
    }

    public void update(int floorNumber) {
        FloorView.setInstance(context.getPlan().getFloors().get(floorNumber));
        FloorView.getInstance().redraw();
    }

    public void setTool(Tools tool) {
        this.tool = tool;
    }
}
