package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.views.MainView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MainView.initialize(primaryStage);
        MainView.getInstance().start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


//TODO choosing and deleiting element