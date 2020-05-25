package td.modele.tourelle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import td.modele.Environnement;
import td.modele.personnage.Personnage;

public abstract class Tourelle {
    private IntegerProperty x;
    private IntegerProperty y;
    private int cadence;
    private int portee; // Pour viser
    Environnement env;


    public Tourelle (int x, int y, int c, Environnement env) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.cadence = c;
        this.env = env;
        env.tours.add(this);
    }

    public String toString () {
        return "Tourelle : " + this.getX() + "   "+ this.getY();
    }

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