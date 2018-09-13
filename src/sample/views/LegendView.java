package sample.views;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

public class LegendView {
    private ScrollPane scrollPane;

    LegendView(){
        scrollPane = new ScrollPane();
    }

    public Node getLayout(){
        return scrollPane;
    }
}
