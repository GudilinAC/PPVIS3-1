package sample.views;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import sample.controllers.FloorController;
import sample.data.Constants;
import sample.models.Dot;

public class FloorView {
    private FloorController controller = FloorController.getInstance();
    private Pane pane = new Pane();
    private StructureView followingStructure;
    private VioletSquareView square;

    private static FloorView ourInstance = new FloorView();

    public static FloorView getInstance() {
        return ourInstance;
    }

    private FloorView() {
        square = new VioletSquareView();
        pane.getChildren().add(square.getLayout());
        pane.setOnMousePressed(event -> {
            if (event.isSecondaryButtonDown()) controller.cancelTool(false);
            if (event.isPrimaryButtonDown()) {
                    controller.mousePress(new Dot(event.getX(), event.getY()));
                }
        });
        pane.setMinSize(696, 536);
    }

    public Node getLayout() {
        return pane;
    }

    public void redraw() {
        pane.getChildren().clear();
        pane.getChildren().add(square.getLayout());
        controller.getStructureViewsList().forEach(s -> pane.getChildren().add(s.getLayout()));
    }

    public void cancelTool(boolean success) {
        if (followingStructure != null) {
            pane.setOnMouseMoved(null);
            if (success){
                //TODO Ivent adding
            } else { pane.getChildren().remove(followingStructure.getLayout()); }
            followingStructure = null;
        }
        square.move(Constants.OUT_DOT);
    }

    public void setFollowingStructure(StructureView followingStructure) {
        this.followingStructure = followingStructure;
        pane.getChildren().add(followingStructure.getLayout());
        pane.setOnMouseMoved(event -> {
            Dot eventDot = new Dot(event.getX(), event.getY());
            Dot dot = controller.findDot(eventDot);
            if (dot != null) {
                square.move(dot);
                followingStructure.followMouse(dot);
            } else {
                square.move(Constants.OUT_DOT);
                followingStructure.followMouse(eventDot);
            }
        });
    }
}
