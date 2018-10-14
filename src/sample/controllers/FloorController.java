package sample.controllers;

import sample.data.Context;
import sample.models.Dot;
import sample.models.Tools;
import sample.views.FloorView;
import sample.views.StructureView;

import java.util.ArrayList;
import java.util.List;

public class FloorController {
    private Context context = Context.getInstance();
    private int indexFloor = 0;
    private Tools tool = null;
    private Dot previousDot;

    private static FloorController ourInstance = new FloorController();

    public static FloorController getInstance() {
        return ourInstance;
    }

    private FloorController() {
    }

    private void pressToWall(Dot dot){
        if (previousDot == null) {
            previousDot = dot;
        } else {
            context.getFloors().get(indexFloor).getStructures().add(StructureController.getInstance().createStructure(tool, previousDot, dot));
            cancelTool();
            MainController.getInstance().update();
        }
    }

    public void mousePress(Dot dot) {
        if (tool == null) return;
        switch (tool) {
            case Wall:
                pressToWall(dot);
                break;
        }
    }

    public void cancelTool(){
        tool = null;
        previousDot = null;
        FloorView.getInstance().cancelTool();
    }

    public void update(int floorNumber) {
        //TODO floorNumber
        FloorView.getInstance().redraw();
    }

    public void setTool(Tools tool) {
        this.tool = tool;
    }

    public Tools getTool() {
        return tool;
    }

    public List<StructureView> getStructureViewsList() {
        List<StructureView> list = new ArrayList<>();
        context.getFloors().get(indexFloor).getStructures().forEach(structure -> list.add(structure.getView()));
        return list;
    }
}
