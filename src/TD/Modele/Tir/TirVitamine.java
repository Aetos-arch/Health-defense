package TD.Modele.Tir;

import TD.Modele.Environnement;
import TD.Modele.Tourelle.TourelleVitamine;
import TD.Utilitaire.Position;

public class TirVitamine extends TirDirection {

    private TourelleVitamine tourelle;


    public TirVitamine(Position p, Position cible, Environnement env, TourelleVitamine t) {
        super(p, 1, cible, 5, env);
        this.tourelle = t;
    }

    public void agit() {
        // Si va être dans la Map
        if (estDansMap(this.getX() + (direction.getX()), this.getY() + (direction.getY()))) {
            // Si il est pas à portée on supprime le tir
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