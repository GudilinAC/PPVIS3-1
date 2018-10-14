package sample.models;

import sample.views.WallView;

public class Wall implements Structure {
    private Dot beginDot = new Dot();
    private Dot endDot = new Dot();

    public WallView getView() {
        return new WallView(beginDot, endDot);
    }

    public Wall(Dot beginDot, Dot endDot) {
        this.beginDot = beginDot;
        this.endDot = endDot;
    }

    public Wall(Dot... vars) {
        switch (vars.length) {
            case 2:
                beginDot = vars[0];
                endDot = vars[1];
                break;
            case 1:
                beginDot = vars[0];
                endDot = vars[0];
        }
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
