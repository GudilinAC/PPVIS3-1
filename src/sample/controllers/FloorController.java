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
    private boolean binding = false;
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
            context.saveChanges();
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
        context.saveChanges();
    }

    public void mousePress(StructureView view) {
        if (tool != null && view.getClass().getSimpleName().equals(tool.name()+"View")){
            context.getFloors().get(indexFloor).getStructures().add(StructureController.getInstance().createStructure(view));
            context.saveChanges();
            cancelTool();
            MainController.getInstance().update();
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
        context.getFloors().get(indexFloor).getStructures().forEach(structure ->
                list.add(StructureController.getInstance().createView(structure)));
        return list;
    }

    public void setBinding(boolean binding) {
        this.binding = binding;
        //TODO binding logic
    }

    public boolean getBinding() {
        return binding;
    }

    public int getCurrentFloor() {
        return indexFloor;
    }
}
