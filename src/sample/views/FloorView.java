package sample.views;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import sample.controllers.FloorController;
import sample.models.Dot;
import sample.models.Floor;

public class FloorView {
    private FloorController controller = FloorController.getInstance();
    private Pane pane = new Pane();

    public FloorView(Floor floor){
        pane = new Pane();
        pane.setOnMousePressed(event -> controller.mousePress(new Dot(event.getX(), event.getY())));
        pane.setMinSize(696, 536);
    }

    public Node getLayout(){
        return pane;
    }
}
