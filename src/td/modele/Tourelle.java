package td.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tourelle {
    private IntegerProperty x;
    private IntegerProperty y;
    private int pointAttaque;
    private int cadense;
    private int nbMunition;

    public Tourelle (int pointAttaque, int c, int m) {
        this.x = new SimpleIntegerProperty();
        this.y = new SimpleIntegerProperty();
        this.pointAttaque = pointAttaque;
        this.cadense = c;
        this.nbMunition = m;
    }

    public abstract void tir(Personnage p);

    public void recharger (int nbMunition) {
        this.nbMunition = nbMunition;
    }

    public double getX() {
        return x.get();
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
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

    public int getCadense() {
        return cadense;
    }

    public void setCadense(int cadense) {
        this.cadense = cadense;
    }
}