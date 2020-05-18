package td.modele;

import javafx.beans.property.IntegerProperty;

public class TirMitraillette extends Tir {
    int vitesse;
    int dx;
    int dy;


    public TirMitraillette (IntegerProperty x, IntegerProperty y, Environnement env) {
        super(x, y, 10, env);
        this.vitesse = 20;
    }

    public void agit (int x, int y) {
        calculerDirection(x, y);

        while ((this.getY() - 5 <= y && y <= this.getY() + 5) &&
                (this.getX() - 5 <= x && x <= this.getX() + 5) && estDansMap(this.getX(), this.getY())) {

                int nouvellePositionX=this.getX()+(this.vitesse*dx);
                int nouvellePositionY=this.getY()+(this.vitesse*dy);
                if (estDansMap(this.getX()+(this.vitesse*dx) , this.getY()+(this.vitesse*dx))) {
                    this.xProperty().setValue(nouvellePositionX);
                    this.yProperty().setValue(nouvellePositionY);
                }
            }
        }

    public void calculerDirection (int x, int y) {
        // test
        this.dx = 1;
        this.dy = 1;
    }
}
