package sample.models;

import sample.data.Constants;

public class Wall implements Structure {
    private Dot beginDot = new Dot();
    private Dot endDot = new Dot();
    private int id = Constants.INIT_ID;

    @Override
    public Dot[] getDots() {
        return new Dot[]{beginDot, endDot};
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
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
