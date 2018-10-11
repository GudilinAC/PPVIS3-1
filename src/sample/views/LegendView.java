package sample.views;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

public class LegendView {
    private ScrollPane scrollPane = new ScrollPane();

    private static LegendView ourInstance = new LegendView();

    public static LegendView getInstance() {
        return ourInstance;
    }

    private LegendView() {
    }

    public Node getLayout(){
        return scrollPane;
    }
}
