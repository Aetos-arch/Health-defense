package td.modele;

import javafx.beans.property.IntegerProperty;

public class TirMitraillette extends Tir {
    int dx;
    int dy;

    public TirMitraillette (IntegerProperty x, IntegerProperty y, int xCible, int yCible, Environnement env) {
        super(x, y,10, xCible, yCible,20, env);
        calculerDirection(xCible, yCible);
    }

    public void agit () {
        // Si le sera dans la Map
        if (estDansMap(this.getX()+(this.v*dx) , this.getY()+(this.v*dx))) {
            // Si le tir a touché ça inflige les dégats sinon met à jour la position du tir
            if (!collision()) {
                this.xProperty().setValue(this.getX()+(this.v*dx));
                this.yProperty().setValue(this.getY()+(this.v*dy));
            }
        }
    }

    public void calculerDirection (int x, int y) {
        this.dx = 1;
        this.dy = 1;
    }

    public boolean collision () {
        for (Personnage p : this.env.getPersos()) {
            if ((this.getY() - 5 <= p.getY() && p.getY() <= this.getY() + 5) &&
                (this.getX() - 5 <=  p.getX() && p.getX() <= this.getX() + 5)) {
                p.seFaireSoigner(10);
                return true;
            }
        }
        return false;
    }
}