package sample.views;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import sample.controllers.StatsController;
import sample.controllers.StructureController;

import java.util.ArrayList;
import java.util.Map;

public class StatsView {
    private StatsController controller = StatsController.getInstance();
    private ScrollPane scrollPane = new ScrollPane();
    private VBox vBox = new VBox();
    private ComboBox<String> floors = new ComboBox<>();

    private static StatsView ourInstance = new StatsView();

    public static StatsView getInstance() {
        return ourInstance;
    }

    private StatsView() {
        scrollPane.setContent(vBox);
        vBox.setSpacing(10);

        HBox floorBox = new HBox();
        Button addFloorButton = new Button("+");
        addFloorButton.setOnAction(event -> controller.addFloor());
        floorBox.getChildren().addAll(floors, addFloorButton);
        vBox.getChildren().add(floorBox);

        floors.setCellFactory(lv ->
                new ListCell<>() {
                    private HBox graphic;

                    {
                        Label label = new Label();
                        label.textProperty().bind(itemProperty());
                        label.setMaxWidth(Double.POSITIVE_INFINITY);
                        label.setOnMouseClicked(event -> floors.hide());
                        Hyperlink xLink = new Hyperlink("x");
                        xLink.setVisited(true);
                        xLink.setOnAction(event -> controller.removeFloor(getIndex()));
                        graphic = new HBox(label, xLink);
                        HBox.setHgrow(label, Priority.ALWAYS);
                    }

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(graphic);
                        }
                    }
                });

        floors.getItems().setAll(controller.getFloorNames());
        floors.getSelectionModel().selectFirst();
        floors.setEditable(true);
        floors.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                Platform.runLater(() -> controller.changeFloor(floors.getSelectionModel().getSelectedIndex()));
            }
        });
        floors.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                controller.renameFloor(
                        floors.getEditor().getText(),
                        floors.getSelectionModel().getSelectedIndex()
                );
            }
        });

        Map<Class<? extends StructureView>, Integer> stats = controller.getStatistics();
        for (Map.Entry<Class<? extends StructureView>, Integer> entry : stats.entrySet()) {
            Label label =  new Label(entry.getValue().toString());
            HBox.setMargin(label, new Insets(0,0,0,20));
            HBox hBox = new HBox(
                    StructureController.getInstance().getDemoView(entry.getKey()).getLayout(),
                    label);
            vBox.getChildren().add(hBox);
        }

        vBox.setPadding(new Insets(20));
    }

    public Node getLayout() {
        return scrollPane;
    }

    public void update(int floorNumber) {
        floors.getItems().clear();
        floors.getItems().addAll(controller.getFloorNames());
        floors.getSelectionModel().select(floorNumber);
    }

    public void setStats(ArrayList<Integer> stats) {
        for (int i = 0; i < stats.size(); i++){
           ((Label)((HBox)vBox.getChildren().get(i+1)).getChildren().get(1)).setText(stats.get(i).toString());
        }
    }
}
