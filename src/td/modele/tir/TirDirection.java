package td.modele.tir;

import javafx.geometry.Pos;
import td.modele.Environnement;

public abstract class TirDirection extends Tir {

    public TirDirection(int x, int y, int pointAttaque, Position cible, int v, Environnement env, double portee) {
        super(x, y, pointAttaque, v, env, portee);
        this.calculerDirection(cible);
    }

    public void calculerDirection (Position cible) {
        Position projectile = new Position(this.getX(), this.getY());
        Vecteur v = new Vecteur(projectile, cible);
        v.multiplier(this.v / v.normeVecteur());
        this.direction.setX(v.getX());
        this.direction.setY(v.getY());
    }
}