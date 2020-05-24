package td.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tourelle {
    private IntegerProperty x;
    private IntegerProperty y;
    Environnement env;
    private int cadence;
    private int portee; // a finir


    public Tourelle (int c, Environnement env) {
        this.x = new SimpleIntegerProperty();
        this.y = new SimpleIntegerProperty();

        x.setValue(30);
        y.setValue(30);
        this.cadence = c;
    }

    public String toString () {
        return "Tourelle : " + this.getX() + "   "+ this.getY();
    }


    //public Personnage viser () {

    //for (Personnage p : env.getPersos()) {

    //   }
    //}

    public abstract void tir(Personnage p);

    public int getX() {
        return x.getValue();
    }


    public int getY() {
        return y.getValue();
    }


    public IntegerProperty xProperty() {
        return x;
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public void setY(int y) {
        this.y.set(y);
    }


    public int getCadence() {
        return cadence;
    }

    public void setCadence(int cadence) {
        this.cadence = cadence;
    }
}