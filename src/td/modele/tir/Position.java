package td.modele.tir;

import javafx.beans.property.ReadOnlyDoubleWrapper;

public class Position implements Coordonnee {
    private ReadOnlyDoubleWrapper xProperty;
    private ReadOnlyDoubleWrapper yProperty;

    public Position(Coordonnee coords) {
        this(coords.getX(), coords.getY());
    }

    public Position(double x, double y) {
        this.xProperty = new ReadOnlyDoubleWrapper(x);
        this.yProperty = new ReadOnlyDoubleWrapper(y);
    }


    public Position multiply(double factor) {
        this.setX(this.getX() * factor);
        this.setY(this.getY() * factor);
        return this;
    }

    //public double distance(Position loc) {
      //  return Math.sqrt(Math.pow(this.getX() - loc.getX(), 2) + Math.pow(this.getY() - loc.getY(), 2));
    //}

    @Override
    public final double getX() {
        return this.xProperty.get();
    }

    @Override
    public final double getY() {
        return this.yProperty.get();
    }

    public final double getRoundX() {
        return Math.floor(this.getX());
    }

    public final double getRoundY() {
        return Math.floor(this.getY());
    }

    public final double getCenterX() {
        return this.getRoundX() + 0.5;
    }

    public final double getCenterY() {
        return this.getRoundY() + 0.5;
    }

    public final Position setX(double x) {
        this.xProperty.set(x);
        return this;
    }

    public final Position setY(double y) {
        this.yProperty.set(y);
        return this;
    }

    public final ReadOnlyDoubleWrapper xProperty() {
        return this.xProperty;
    }

    public final ReadOnlyDoubleWrapper yProperty() {
        return this.yProperty;
    }

    public boolean egal (Position loc) {
        return this.getX() == loc.getX() && this.getY() == loc.getY();
    }

    @Override
    public String toString() {
        return "Location [x=" + xProperty.get() + ", y=" + yProperty.get() + "]";
    }
}