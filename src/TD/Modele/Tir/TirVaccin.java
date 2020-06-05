package TD.Modele.Tir;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Modele.Tourelle.TourelleVaccin;
import TD.Utilitaire.Position;

public class TirVaccin extends TirDirection {
    public TirVaccin(Position cible, Environnement env, TourelleVaccin t) {
        super(50, cible, 40, env, 20, t);
    }
    
    @Override
    public boolean collision() {
        for (Personnage p : this.env.getPersos()) {
            if ((p.getY() >= this.getY() - hitbox && p.getY() <= this.getY() + hitbox) &&
                    (p.getX() >= this.getX() - hitbox && p.getX() <= this.getX() + hitbox)) {
                p.prendreUnHoT(this.pointAttaque);
                return true;
            }
        }
        return false;
    }
}
