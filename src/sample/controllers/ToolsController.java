package sample.controllers;

import sample.data.Data;
import sample.models.Tools;

public class ToolsController {
    private Data context = Data.getInstance();

    private static ToolsController ourInstance = new ToolsController();

    public static ToolsController getInstance() {
        return ourInstance;
    }

    private ToolsController() {
    }

    public void setTool(Tools tool){
        FloorController.getInstance().setTool(tool);
    }

    public void setBinding(boolean binding) {
        FloorController.getInstance().setBinding(binding);
    }
}


