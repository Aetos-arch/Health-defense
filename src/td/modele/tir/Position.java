package td.modele.tir;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleDoubleProperty;

public class Position implements Coordonnee {
    private double x;
    private double y;

    public Position(Coordonnee coords) {
        this(coords.getX(), coords.getY());
    }

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position multiplier(double nbr) {
        this.setX(this.getX() * nbr);
        this.setY(this.getY() * nbr);
        return this;
    }

    //public double distance(Position loc) {
      //  return Math.sqrt(Math.pow(this.getX() - loc.getX(), 2) + Math.pow(this.getY() - loc.getY(), 2));
    //}


    @Override
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}