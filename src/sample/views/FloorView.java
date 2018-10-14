package sample.views;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.controllers.FloorController;
import sample.controllers.StructureController;
import sample.models.Dot;
import sample.models.Tools;

public class FloorView {
    private FloorController controller = FloorController.getInstance();
    private Pane pane = new Pane();
    private StructureView followingStructure;

    private static FloorView ourInstance = new FloorView();

    public static FloorView getInstance() {
        return ourInstance;
    }

    private FloorView() {
        pane.setOnMousePressed(event -> {
            if (event.isSecondaryButtonDown()) controller.cancelTool();
            if (event.isPrimaryButtonDown()) {
                controller.mousePress(new Dot(event.getX(), event.getY()));
                followingStructure = followMouse(event);
                if (followingStructure != null) {
                    pane.getChildren().add(followingStructure.getLayout());
                    pane.setOnMouseMoved(event1 -> followingStructure.followMouse(new Dot(event1.getX(), event1.getY())));
                }
            }
        });
        pane.setMinSize(696, 536);
    }

    private StructureView followMouse(MouseEvent event) {
        Tools tool = controller.getTool();
        if (tool == null) return null;
        return StructureController.getInstance().createStructure(tool, new Dot(event.getX(), event.getY())).getView();
    }

    public Node getLayout() {
        return pane;
    }

    public void redraw() {
        pane.getChildren().clear();
        controller.getStructureViewsList().forEach(s -> pane.getChildren().add(s.getLayout()));
    }

    public void cancelTool() {
        if (followingStructure != null) {
            pane.setOnMouseMoved(null);
            pane.getChildren().remove(followingStructure.getLayout());
            followingStructure = null;
        }
    }
}
