package sample.views;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

public class PlanView {
    private ScrollPane scrollPane;

    PlanView(){
        scrollPane = new ScrollPane();
    }

    public Node getLayout(){
        return scrollPane;
    }
}
