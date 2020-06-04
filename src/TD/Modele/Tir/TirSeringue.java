package TD.Modele.Tir;

import TD.Modele.Environnement;
import TD.Modele.Tourelle.TourelleSeringue;
import TD.Utilitaire.Position;

public class TirSeringue extends TirDirection {
    private TourelleSeringue tourelle;

    public TirSeringue(Position cible, Environnement env, TourelleSeringue t) {
        super(t.getPosition(), 20, cible, 10, env);
        this.tourelle = t;
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