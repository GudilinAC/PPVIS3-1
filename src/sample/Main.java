package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.views.MainView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new MainView(primaryStage).start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
