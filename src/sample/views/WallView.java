package sample.views;

import javafx.scene.Node;
import javafx.scene.shape.Line;
import sample.models.Dot;

public class WallView extends Line implements StructureView{
    public WallView(Dot begin, Dot end){
        setBegin(begin);
        setEnd(end);
        setStrokeWidth(3);
    }

    public void followMouse(Dot dot) {
        this.setEnd(dot);
    }

    public void setBegin(Dot dot){
        this.setStartX(dot.getX());
        this.setStartY(dot.getY());
    }

    public void setEnd(Dot dot){
        this.setEndX(dot.getX());
        this.setEndY(dot.getY());
    }

    public Node getLayout() {
        return this;
    }
}
