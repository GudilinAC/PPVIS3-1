package sample.views;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import sample.controllers.FloorController;
import sample.models.Dot;
import sample.models.Floor;

public class FloorView {
    private FloorController controller = FloorController.getInstance();
    private Pane pane = new Pane();

    private static FloorView ourInstance = new FloorView();

    public static FloorView getInstance() {
        return ourInstance;
    }

    private FloorView() {
        pane.setOnMousePressed(event -> ourInstance.controller.mousePress(new Dot(event.getX(), event.getY())));
        pane.setMinSize(696, 536);
    }

    public static void setInstance(Floor floor){
        ourInstance.pane.getChildren().clear();
        floor.getStructures().forEach(structure -> ourInstance.pane.getChildren().add(structure.getLayout()));
    }

    public Node getLayout(){
        return pane;
    }

    public void redraw() {

    }
}
