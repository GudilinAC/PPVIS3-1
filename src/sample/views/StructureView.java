package sample.views;

import javafx.scene.Node;
import sample.models.Dot;

public interface StructureView {
    void followMouse(Dot dot);
    boolean setAnchor(Dot dot);
    Dot[] getDotMassive();
    Node getLayout();
    void demo();
}
