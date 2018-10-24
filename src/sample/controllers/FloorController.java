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
    private boolean isBindingWorking = false;
    private StructureView followingStructure;

    private static FloorController ourInstance = new FloorController();

    public static FloorController getInstance() {
        return ourInstance;
    }

    private FloorController() {
    }

    public void mousePress(Dot dot) {
        if (tool == null || followingStructure == null) return;
        Dot anotherDot = findDot(dot);
        if (anotherDot == null) { anotherDot = dot; }
        if (followingStructure.setAnchor(anotherDot)) {
            context.getFloors().get(indexFloor).getStructures().add(StructureController.getInstance().createStructure(followingStructure));
            cancelTool(true);
        }
        context.saveChanges();
    }

    public Dot findDot(Dot dot) {
        Dot resultDot = null;
        if(isBindingWorking) {
            resultDot = StructureController.getInstance().getBindingDot(dot);
        }
        return resultDot;
    }

    public void cancelTool(boolean success) {
        tool = null;
        followingStructure = null;
        FloorView.getInstance().cancelTool(success);
    }

    public void update(int floorNumber) {
        //TODO floorNumber
        FloorView.getInstance().redraw();
    }

    public void setTool(Tools tool) {
        if (this.tool != null) {
            cancelTool(false);
        }
        this.tool = tool;
        switch (tool) {
            case Wall:
                isBindingWorking = true;
                break;
            case Camera:
                isBindingWorking = false;
                break;
        }
        followingStructure = StructureController.getInstance().createStructureView(tool);
        FloorView.getInstance().setFollowingStructure(followingStructure);
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
