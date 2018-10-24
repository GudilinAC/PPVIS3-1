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
        FloorView.getInstance().redraw();
        scrollPane = new ScrollPane(FloorView.getInstance().getLayout());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }

    public Node getLayout(){
        return scrollPane;
    }

    public void update(Plan plan){
    }
}
