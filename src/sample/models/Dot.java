package sample.models;

public class Dot {
    private double xCoordinate;
    private double yCoordinate;

    public Dot(){
    }

    public Dot(double xCoordinate, double yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Dot)) return false;
        Dot otherDot = (Dot)other;
        return (this.xCoordinate == otherDot.xCoordinate && this.yCoordinate == otherDot.yCoordinate);
    }
}
