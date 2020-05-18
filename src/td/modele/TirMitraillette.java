package td.modele;

import javafx.beans.property.IntegerProperty;

public class TirMitraillette extends Tir {
    int vitesse;
    int dx;
    int dy;

    public TirMitraillette (IntegerProperty x, IntegerProperty y, int xC, int yC, Environnement env) {
        super(x, y,xC,yC,10, env);
        this.vitesse = 20;
        calculerDirection(xC, yC);
    }

    public void agit () {

                int nouvellePositionX=this.getX()+(this.vitesse*dx);
                int nouvellePositionY=this.getY()+(this.vitesse*dy);

       // this.getY() - 5 <= y && y <= this.getY() + 5) &&
        //(this.getX() - 5 <= x && x <= this.getX() + 5) && estDansMap(this.getX(), this.getY()

                if (estDansMap(this.getX()+(this.vitesse*dx) , this.getY()+(this.vitesse*dx))) {
                    this.xProperty().setValue(nouvellePositionX);
                    this.yProperty().setValue(nouvellePositionY);
                }
            }

    public void calculerDirection (int x, int y) {
        // test
        this.dx = 1;
        this.dy = 1;
    }
}
