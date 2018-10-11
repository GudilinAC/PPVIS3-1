package sample.views;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

public class StatsView {
    private ScrollPane scrollPane = new ScrollPane();

    private static StatsView ourInstance = new StatsView();

    public static StatsView getInstance() {
        return ourInstance;
    }

    private StatsView() {
    }

    public Node getLayout(){
        return scrollPane;
    }
}
