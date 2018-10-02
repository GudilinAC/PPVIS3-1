package sample.controllers;

import sample.data.Context;
import sample.models.Tools;

public class ToolsController {
    private Context context = Context.getInstance();
    private Tools tool;

    private static ToolsController ourInstance = new ToolsController();

    public static ToolsController getInstance() {
        return ourInstance;
    }

    private ToolsController() {
    }

    public void setTool(Tools tool){
        this.tool = tool;
    }

    public Tools getTool() {
        return tool;
    }
}


