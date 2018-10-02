package sample.views;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import sample.controllers.PlanController;

import java.util.ArrayList;
import java.util.List;

public class PlanView {
    private PlanController planController = PlanController.getInstance();
    private ScrollPane scrollPane;

    PlanView() {
        List<FloorView> floors = new ArrayList<>();
        planController.getPlan().getFloors().forEach(floor -> floors.add(new FloorView(floor)));
        scrollPane = new ScrollPane(floors.get(0).getLayout());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    public Node getLayout(){
        return scrollPane;
    }
}
