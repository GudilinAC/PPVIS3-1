package sample.views;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.models.Dot;

public class VioletSquareView {
    private Rectangle rectangle;

    VioletSquareView(Dot dot) {
        rectangle = new Rectangle(10,10);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.VIOLET);
        rectangle.setStrokeWidth(2);
        move(dot);
    }

    public void move(Dot dot) {
        rectangle.setX(dot.getX()-5);
        rectangle.setY(dot.getY()-5);
    }

    public Node getLayout(){
        return rectangle;
    }
}
