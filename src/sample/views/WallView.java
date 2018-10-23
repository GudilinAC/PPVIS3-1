package sample.views;

import javafx.scene.Node;
import javafx.scene.shape.Line;
import sample.controllers.StructureController;
import sample.models.Dot;

public class WallView implements StructureView {
    private StructureController controller = StructureController.getInstance();
    private Line line = new Line();

    public WallView(Dot begin, Dot end) {
        setBegin(begin);
        setEnd(end);
        line.setStrokeWidth(3);
    }

    public WallView(Dot[] dots) {
        if (dots.length > 1) {
            setBegin(dots[0]);
        }
        if (dots.length > 0) {
            setEnd(dots[1]);
        }
        line.setStrokeWidth(3);
    }

    public void followMouse(Dot dot) {
        this.setEnd(dot);
    }

    @Override
    public Dot[] getDotMassive() {
        return new Dot[]{new Dot(line.getStartX(), line.getStartY()), new Dot(line.getEndX(), line.getEndY())};
    }

    public void setBegin(Dot dot) {
        line.setStartX(dot.getX());
        line.setStartY(dot.getY());
    }

    public void setEnd(Dot dot) {
        line.setEndX(dot.getX());
        line.setEndY(dot.getY());
    }

    public Node getLayout() {
        return line;
    }
}
