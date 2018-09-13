package sample.views;

import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {
    private Stage primaryStage;
    private MenuView menuView;
    private ToolsView toolsView;
    private PlanView planView;
    private StatsView statsView;
    private LegendView legendView;

    public MainView(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public void start() {
        BorderPane mainBorderPane = new BorderPane();
        Scene scene = new Scene(mainBorderPane, 1000, 700);

        menuView = new MenuView();
        toolsView = new ToolsView();
        VBox vBox = new VBox(menuView.getLayout(), toolsView.getLayout());
        mainBorderPane.setTop(vBox);

        planView = new PlanView();
        statsView = new StatsView();
        SplitPane splitPane = new SplitPane(planView.getLayout(), statsView.getLayout());
        splitPane.setDividerPositions(0.7f, 0.3f);
        mainBorderPane.setCenter(splitPane);

        legendView = new LegendView();
        mainBorderPane.setBottom(legendView.getLayout());

        primaryStage.setTitle("Police Office");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
