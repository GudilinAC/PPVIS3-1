package sample.controllers;

import sample.data.Context;
import sample.models.Dot;
import sample.models.Tools;

public class FloorController {
    private Context context = Context.getInstance();
    private ToolsController toolsController = ToolsController.getInstance();
    private StructureController structureController = StructureController.getInstance();
    private Tools previousUsedTool;
    private Dot previousDot;

    private static FloorController ourInstance = new FloorController();

    public static FloorController getInstance() {
        return ourInstance;
    }

    private FloorController() {
    }

    public void mousePress(Dot dot){
        Tools tool = toolsController.getTool();
        if (previousUsedTool == null){
            previousDot = dot;
            previousUsedTool = tool;
        }
        else {
            if (previousUsedTool != tool) toolsController.setTool(null);
            else {
                context.getPlan().getFloors().get(0).getStructures().add(structureController.createStructure(tool));
                previousDot = null;
                previousUsedTool = null;
            }
        }
    }
}
