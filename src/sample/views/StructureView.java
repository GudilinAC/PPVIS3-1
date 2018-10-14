package sample.views;

import javafx.scene.Node;
import sample.models.Dot;

public interface StructureView {
    void followMouse(Dot dot);
    Node getLayout();
}
