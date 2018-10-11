package sample.views;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import sample.controllers.ToolsController;
import sample.models.Tools;

public class ToolsView {
    private ToolsController controller = ToolsController.getInstance();
    private ToolBar toolBar;

    private static ToolsView ourInstance = new ToolsView();

    public static ToolsView getInstance() {
        return ourInstance;
    }

    private ToolsView() {
        Button wallButton = new Button("Wall");
        wallButton.setOnAction(event -> controller.setTool(Tools.Wall));
        toolBar = new ToolBar(wallButton);
    }

    public Node getLayout(){
        return toolBar;
    }
}
