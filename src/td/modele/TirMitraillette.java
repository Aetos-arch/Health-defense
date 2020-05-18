package td.modele;

import javafx.beans.property.IntegerProperty;

public class TirMitraillette extends Tir{
    int vitesse;

    public TirMitraillette (IntegerProperty x, IntegerProperty y, int v) {
        super(x, y, 10);
        this.vitesse = v;
    }

    public void toucher (Personnage p) {
        while (this.getX() != p.getX() && this.getY() != p.getY() || this.getX() > ) {

        }
    }

    public void calculerDirection (Personnage p) {

    }
}
