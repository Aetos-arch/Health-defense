package td.modele;

import javafx.beans.property.IntegerProperty;

public class TirMitraillette extends Tir {
    int vitesse;
    int dx;
    int dy;

    public TirMitraillette (IntegerProperty x, IntegerProperty y, int xCible, int yCible, Environnement env) {
        super(x, y,10, xCible, yCible, env);
        this.vitesse = 20;
        calculerDirection(xCible, yCible);
    }

    public void agit () {
        int nouvellePositionX=this.getX()+(this.vitesse*dx);
        int nouvellePositionY=this.getY()+(this.vitesse*dy);

        // Si le sera dans la Map
        if (estDansMap(this.getX()+(this.vitesse*dx) , this.getY()+(this.vitesse*dx))) {
            // Si le tir a touché ça inflige les dégats sinon met à jour la position du tir
            if (!collision()) {
                this.xProperty().setValue(nouvellePositionX);
                this.yProperty().setValue(nouvellePositionY);
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