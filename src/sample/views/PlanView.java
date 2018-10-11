package sample.views;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import sample.controllers.PlanController;
import sample.models.Plan;

public class PlanView {
    private PlanController controller = PlanController.getInstance();
    private ScrollPane scrollPane;

    private static PlanView ourInstance = new PlanView();

    public static PlanView getInstance() {
        return ourInstance;
    }

    private PlanView() {
        FloorView.setInstance(controller.getPlan().getFloors().get(0));
        scrollPane = new ScrollPane(FloorView.getInstance().getLayout());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    public Node getLayout(){
        return scrollPane;
    }

    public void update(Plan plan){
    }
}
