package td.modele;

import javafx.beans.property.IntegerProperty;

public class TirMitraillette extends Tir {

    public TirMitraillette (int x, int y, int xCible, int yCible, Environnement env) {
        super(x, y,10, xCible, yCible,20, env);
        calculerDirection(xCible, yCible);
    }

    public void agit () {
        // Si dans la Map
        if (estDansMap(this.getX()+(this.v*dx) , this.getY()+(this.v*dx))) {
            // Si le tir a touché ça inflige les dégats sinon met à jour la position du tir
            if (!collision()) {
                this.xProperty().setValue(this.getX()+(this.v*dx));
                this.yProperty().setValue(this.getY()+(this.v*dy));
            } // supprimer tir
        }
    }

    public void calculerDirection (int xCible, int yCible) {
        int tempX = this.xProperty.getValue() - xCible;
        int tempY = this.yProperty.getValue() - xCible;

        if (tempX < 0)
            this.dx = 1;
        else if (tempX == 0)
            this.dx = 0;
        else
            this.dx = -1;

        if (tempY < 0)
            this.dy = 1;
        else if (tempX == 0)
            this.dy = 0;
        else
            this.dy = -1;
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