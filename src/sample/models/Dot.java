package sample.models;

import java.util.Collection;

public class Dot{
    private double xCoordinate;
    private double yCoordinate;

    private Dot closestDot;
    private double distance;

    public Dot(){
    }

    public Dot(double xCoordinate, double yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getX() {
        return xCoordinate;
    }

    public void setX(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getY() {
        return yCoordinate;
    }

    public void setY(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double distance(Dot dot){
        return Math.sqrt(Math.pow((this.getX() - dot.getX()),2) + Math.pow((this.getY() - dot.getY()),2));
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Dot)) return false;
        Dot otherDot = (Dot)other;
        return (this.xCoordinate == otherDot.xCoordinate && this.yCoordinate == otherDot.yCoordinate);
    }

    public Dot nearest(Collection<Dot> dots) {
        distance = Double.MAX_VALUE;
        dots.forEach(d -> {
            if (this.distance(d) < distance){
                closestDot =  d;
                distance = this.distance(d);
            }
        });
        return closestDot;
    }
}
