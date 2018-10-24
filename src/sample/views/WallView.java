package sample.views;

import javafx.scene.Node;
import javafx.scene.shape.Line;
import sample.controllers.StructureController;
import sample.data.Constants;
import sample.models.Dot;

public class WallView implements StructureView {
    private StructureController controller = StructureController.getInstance();
    private Line line = new Line();
    private boolean anchorSetted = false;

    public WallView(Dot begin, Dot end) {
        setBegin(begin);
        setEnd(end);
        line.setStrokeWidth(3);
    }

    public WallView(Dot[] dots) {
        switch (dots.length) {
            case 1:
                setBegin(dots[0]);
                setEnd(dots[0]);
                break;
            case 2:
                setBegin(dots[0]);
                setEnd(dots[1]);
                break;
            default:
                setBegin(Constants.OUT_DOT);
                setEnd(Constants.OUT_DOT);
        }
        line.setStrokeWidth(3);
    }

    public void followMouse(Dot dot) {
        if (anchorSetted) {
            this.setEnd(dot);
        }
    }

    @Override
    public boolean setAnchor(Dot dot) {
        if (anchorSetted) {
            setEnd(dot);
            return true;
        } else {
            setBegin(dot);
            setEnd(dot);
            anchorSetted = true;
            return false;
        }
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
