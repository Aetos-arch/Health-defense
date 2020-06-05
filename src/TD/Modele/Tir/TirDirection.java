package TD.Modele.Tir;

import TD.Modele.Environnement;
import TD.Modele.Tourelle.TourelleDegatUnique;
import TD.Utilitaire.Position;
import TD.Utilitaire.Vecteur;

public abstract class TirDirection extends Tir {
    private TourelleDegatUnique tourelle;

    public TirDirection(Position p, int pointAttaque, Position cible, int v, Environnement env, TourelleDegatUnique t) {
        super(p, pointAttaque, v, 8, env);
        this.calculerDirection(cible);
        this.tourelle = t;
    }

    public void calculerDirection(Position cible) {
        Position projectile = new Position(this.getX(), this.getY());
        Vecteur v = new Vecteur(projectile, cible);
        v.multiplier(this.vitesse / v.normeVecteur());
        this.direction.setX(v.getX());
        this.direction.setY(v.getY());
    }

    public void agit() {
        // Si va être dans la Map
        if (estDansMap(this.getX() + (direction.getX()), this.getY() + (direction.getY()))) {
            // Si il est à une portée supérieur on supprime le tir
            if (this.getPosition().distance(this.tourelle.getPosition()) > this.tourelle.getPortee()) {
                env.getTirs().remove(this);
            }
            // Si le tir a touché ça inflige les dégats sinon met à jour la position du tir
            else if (!collision()) {
                this.xProperty().setValue(this.getX() + direction.getX());
                this.yProperty().setValue(this.getY() + (direction.getY()));
            } else {
                env.getTirs().remove(this);
            }
        } else
            env.getTirs().remove(this);
    }
}