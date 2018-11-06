package sample.views;

import javafx.scene.Node;
import sample.models.Dot;

public interface StructureView {
    void followMouse(Dot dot);
    boolean setAnchor(Dot dot);
    Dot[] getDots();
    Node getLayout();
    void demo();

    void select();
    void unselect();
    boolean isSelected();

    void setId(int id);
    int getId();
}
