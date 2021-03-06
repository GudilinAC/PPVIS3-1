package sample.views;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import sample.data.Constants;
import sample.models.Dot;

public class WallView implements StructureView {
    private Line line = new Line();
    private boolean anchorSetted = false;
    private boolean select = false;
    private int id = Constants.INIT_ID;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

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
    public Dot[] getDots() {
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

    @Override
    public void demo() {
        setBegin(new Dot(0,25));
        setEnd(new Dot(30,0));
    }

    @Override
    public void select() {
        select = true;
        line.setStroke(Color.GREEN);
    }

    @Override
    public void unselect() {
        select = false;
        line.setStroke(Color.BLACK);
    }

    @Override
    public boolean isSelected() {
        return select;
    }
}
