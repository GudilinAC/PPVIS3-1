package sample.controllers;

public class MainController {
    private static MainController ourInstance = new MainController();

    public static MainController getInstance() {
        return ourInstance;
    }

    private MainController() {
    }
}
