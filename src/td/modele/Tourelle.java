package td.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tourelle {
    private IntegerProperty x;
    private IntegerProperty y;
    private int pointAttaque;
    private int cadence;
    private int nbMunition;

    public Tourelle (int pointAttaque, int c, int m) {
        this.x = new SimpleIntegerProperty();
        this.y = new SimpleIntegerProperty();
        this.pointAttaque = pointAttaque;
        this.cadence = c;
        this.nbMunition = m;
    }

    public abstract void tir(Personnage p);

    public void recharger (int nbMunition) {
        this.nbMunition = nbMunition;
    }

    public double getX() {
        return x.getValue();
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public double getY() {
        return y.getValue();
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public int getPointAttaque() {
        return pointAttaque;
    }

    public void setPointAttaque(int pointAttaque) {
        this.pointAttaque = pointAttaque;
    }

    public int getCadence() {
        return cadence;
    }

    public void setCadence(int cadence) {
        this.cadence = cadence;
    }
}