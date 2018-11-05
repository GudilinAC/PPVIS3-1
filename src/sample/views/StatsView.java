package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import sample.controllers.StatsController;
import sample.controllers.StructureController;

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
                if (floors.getSelectionModel().getSelectedIndex() != -1) {
                    controller.changeFloor(floors.getSelectionModel().getSelectedIndex());
                } else {
                    controller.renameFloor(oldVal, newVal);
                    floors.getItems().set(floors.getItems().indexOf(oldVal), newVal);
                }
            }
        });

        Map<Class<? extends StructureView>, Integer> stats = controller.getStatistics();
        for (Map.Entry<Class<? extends StructureView>, Integer> entry : stats.entrySet()) {
            Label label =  new Label(entry.getValue().toString());
            HBox.setMargin(label, new Insets(0,0,0,20));
            label.setUserData(entry.getKey());
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

    public void setStats(Map<Class<? extends StructureView>, Integer> map) {
        for (Node node: vBox.getChildren()){
            if (node instanceof HBox){
                if (((HBox) node).getChildren().size() > 1){
                    Node label = ((HBox) node).getChildren().get(1);
                    if (label instanceof Label) {
                        if (label.getUserData() instanceof Class){
                            ((Label) label).setText(map.get(label.getUserData()).toString());
                        }
                    }
                }
            }
        }
    }
}
