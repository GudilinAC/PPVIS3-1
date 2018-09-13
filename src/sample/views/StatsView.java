package sample.views;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

public class StatsView {
    private ScrollPane scrollPane;

    StatsView(){
        scrollPane = new ScrollPane();
    }

    public Node getLayout(){
        return scrollPane;
    }
}
