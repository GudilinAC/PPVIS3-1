package sample.views;

import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.controllers.MainController;

public class MainView {
    private MainController controller = MainController.getInstance();
    private Stage primaryStage;
    private Scene scene;

    private static MainView ourInstance = new MainView();

    public static MainView getInstance() {
        return ourInstance;
    }

    public static void initialize(Stage primaryStage) {
        ourInstance.primaryStage = primaryStage;
    }

    private MainView() {
    }

    public void start() {
        BorderPane mainBorderPane = new BorderPane();
        scene = new Scene(mainBorderPane, 1000, 700);

        VBox vBox = new VBox(MenuView.getInstance().getLayout(), ToolsView.getInstance().getLayout());
        mainBorderPane.setTop(vBox);

        SplitPane splitPane = new SplitPane(PlanView.getInstance().getLayout(), StatsView.getInstance().getLayout());
        splitPane.setDividerPositions(0.7f, 0.3f);
        mainBorderPane.setCenter(splitPane);

        mainBorderPane.setBottom(LegendView.getInstance().getLayout());

        primaryStage.setTitle("Police Office");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Scene getScene() {
        return scene;
    }
}
