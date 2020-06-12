package Tower_Defense.Modele.Tir;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Personnage.Personnage;
import Tower_Defense.Modele.Tourelle.TourelleVaccin;
import Tower_Defense.Utilitaire.Position;

public class TirVaccin extends TirDirection {
    public TirVaccin(Position cible, Environnement env, TourelleVaccin t) {
        super(130, cible, 50, env, 20, t);
    }

    // Parcours les personnages pour vérifier si collision, si collision inflige les dégats
    @Override
    public boolean collision() {
        for (Personnage p : this.env.getPersos()) {
            if (((p.getY() >= this.getY() - hitbox && p.getY() <= this.getY() + hitbox) &&
                    (p.getX() >= this.getX() - hitbox && p.getX() <= this.getX() + hitbox))&& !p.estSain() && p.estProtege().getValue() ==0) {
                p.prendreUnHoT(this.pointAttaque);
                return true;
            }
        }
        return false;
    }
}