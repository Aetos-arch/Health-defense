package Tower_Defense.Modele.Tir;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Personnage.Personnage;
import Tower_Defense.Modele.Tourelle.TourelleDegatUnique;
import Tower_Defense.Utilitaire.Position;
import Tower_Defense.Utilitaire.Vecteur;

public abstract class TirDirection extends Tir {
    protected TourelleDegatUnique tourelle;
    protected int vitesse;
    protected Vecteur direction;

    public TirDirection(int pointAttaque, Position cible, int v, Environnement env, int hitbox, TourelleDegatUnique tourelleDegatUnique) {
        super(tourelleDegatUnique.getPosition(), pointAttaque, hitbox, env);
        this.tourelle = tourelleDegatUnique;
        this.vitesse = v;
        this.direction = new Vecteur();
        this.calculerDirection(cible);
    }

    // Calcule la direction entre le tir et la cible
    public void calculerDirection(Position cible) {
        Position projectile = new Position(this.getX(), this.getY());
        Vecteur v = new Vecteur(projectile, cible);
        v.multiplier(this.vitesse / v.normeVecteur());
        this.direction.setX(v.getX());
        this.direction.setY(v.getY());
    }

    // Parcours les personnages pour vérifier si collision, si collision inflige les dégats et return true

    public boolean collision() {
        for (Personnage p : this.env.getPersos()) {
            if (((p.getY() >= this.getY() - hitbox && p.getY() <= this.getY() + hitbox) &&
                    (p.getX() >= this.getX() - hitbox && p.getX() <= this.getX() + hitbox))&& !p.estSain()&& p.estProtege().getValue() ==0) {
                p.seFaireSoigner(this.pointAttaque);
                return true;
            }
        }
        return false;
    }

    @Override
    public void agit() {
        // Si va être dans la Map
        if (estDansMap(this.getX() + (direction.getX()), this.getY() + (direction.getY()))) {
            // Si il est à une portée supérieur à la portée de la tourelle on supprime le tir
            if (this.getPositionProperty().distance(this.tourelle.getPosition()) > this.tourelle.getPortee()) {
                env.getTirs().remove(this);
            }
            // Si le tir a touché un ennemie, ça inflige les dégats, sinon met à jour la position du tir
            else if (!collision()) {
                this.getXProperty().setValue(this.getX() + direction.getX());
                this.getYProperty().setValue(this.getY() + direction.getY());
            } else {
                env.getTirs().remove(this);
            }
        } else
            env.getTirs().remove(this);
    }
}