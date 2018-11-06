package sample.models;

import sample.data.Constants;

public class Camera implements Structure {
    private Dot dot = new Dot();
    private int id = Constants.INIT_ID;

    @Override
    public Dot[] getDots() {
        return new Dot[]{dot};
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public Camera(Dot... vars) {
        if (vars.length == 1){
            dot = vars[0];
        }
    }

    public Dot getDot() {
        return dot;
    }

    public void setDot(Dot dot) {
        this.dot = dot;
    }
}
