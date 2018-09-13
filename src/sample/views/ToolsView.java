package sample.views;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class ToolsView {
    private ToolBar toolBar;

    ToolsView(){
        toolBar = new ToolBar(new Button());
    }

    public Node getLayout(){
        return toolBar;
    }
}
