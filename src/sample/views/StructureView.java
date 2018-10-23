package sample.views;

import javafx.scene.Node;
import sample.models.Dot;

public interface StructureView {
    void followMouse(Dot dot);
    Dot[] getDotMassive();
    Node getLayout();
}
