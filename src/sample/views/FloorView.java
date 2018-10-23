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
    private VioletSquareView square;
    private Dot outDot = new Dot(-10,-10);

    private static FloorView ourInstance = new FloorView();

    public static FloorView getInstance() {
        return ourInstance;
    }

    private FloorView() {
        square = new VioletSquareView(outDot);
        square.getLayout().setVisible(false);
        pane.getChildren().add(square.getLayout());
        pane.setOnMousePressed(event -> {
            if (event.isSecondaryButtonDown()) controller.cancelTool();
            if (event.isPrimaryButtonDown()) {
                if (followingStructure != null) {
                    controller.mousePress(followingStructure);
                } else {
                    controller.mousePress(new Dot(event.getX(), event.getY()));
                    followingStructure = followMouse(event);
                    if (followingStructure != null) {
                        square.getLayout().setVisible(true);
                        pane.getChildren().add(followingStructure.getLayout());
                        pane.setOnMouseMoved(event1 -> {
                            Dot eventDot = new Dot(event1.getX(), event1.getY());
                            Dot dot = StructureController.getInstance().getBindingDot(eventDot);
                            if (dot != null) {
                                square.move(dot);
                                followingStructure.followMouse(dot);
                            } else {
                                square.move(outDot);
                                followingStructure.followMouse(eventDot);
                            }
                        });
                    }
                }
            }
        });
        pane.setMinSize(696, 536);
    }

    private StructureView followMouse(MouseEvent event) {
        Tools tool = controller.getTool();
        if (tool == null) return null;
        return StructureController.getInstance().createView(tool, new Dot(event.getX(), event.getY()));
    }

    public Node getLayout() {
        return pane;
    }

    public void redraw() {
        pane.getChildren().clear();
        pane.getChildren().add(square.getLayout());
        controller.getStructureViewsList().forEach(s -> pane.getChildren().add(s.getLayout()));
    }

    public void cancelTool() {
        if (followingStructure != null) {
            pane.setOnMouseMoved(null);
            pane.getChildren().remove(followingStructure.getLayout());
            followingStructure = null;
        }
        square.move(outDot);
        square.getLayout().setVisible(false);
    }
}
