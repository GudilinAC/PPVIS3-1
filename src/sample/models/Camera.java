package sample.models;

public class Camera implements Structure {
    private Dot dot = new Dot();

    @Override
    public Dot[] getDotMassive() {
        return new Dot[]{dot};
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
