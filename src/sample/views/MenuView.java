package sample.views;

import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuView {
    private MenuBar menuBar;

    public MenuView(){
        menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem openFileItem = new MenuItem("Open");
        MenuItem saveFileItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(event -> System.exit(0));
        fileMenu.getItems().addAll(openFileItem, saveFileItem, exitItem);
        menuBar.getMenus().addAll(fileMenu);
    }

    public Node getLayout(){
        return menuBar;
    }
}
