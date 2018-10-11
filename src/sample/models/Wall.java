package sample.models;

import javafx.scene.Node;
import javafx.scene.shape.Line;

public class Wall implements Structure{
    private Dot beginDot;
    private Dot endDot;

    public Node getLayout(){
        Line line = new Line(beginDot.getX(), beginDot.getY(), endDot.getX(), endDot.getY());
        return line;
    }

    public Wall(Dot beginDot, Dot endDot){
        this.beginDot = beginDot;
        this.endDot = endDot;
    }

    public Dot getEndDot() {
        return endDot;
    }

    public void setEndDot(Dot endDot) {
        this.endDot = endDot;
    }

    public Dot getBeginDot() {
        return beginDot;
    }

    public void setBeginDot(Dot beginDot) {
        this.beginDot = beginDot;
    }
}
