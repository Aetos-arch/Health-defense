package TD.Modele.Tir;

import TD.Modele.Environnement;
import TD.Utilitaire.Position;
import TD.Utilitaire.Vecteur;

public abstract class TirDirection extends Tir {

    public TirDirection(Position p, int pointAttaque, Position cible, int v, Environnement env) {
        super(p, pointAttaque, v, 8, env);
        this.calculerDirection(cible);
    }

    public void calculerDirection(Position cible) {
        Position projectile = new Position(this.getX(), this.getY());
        Vecteur v = new Vecteur(projectile, cible);
        v.multiplier(this.vitesse / v.normeVecteur());
        this.direction.setX(v.getX());
        this.direction.setY(v.getY());
    }
}