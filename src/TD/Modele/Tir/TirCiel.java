package TD.Modele.Tir;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Modele.Tourelle.TourelleDuCiel;
import TD.Utilitaire.Position;


public class TirCiel extends Tir {
    protected TourelleDuCiel tourelle;

    public TirCiel(int pointAttaque, Position cible, Environnement env, TourelleDuCiel t) {
        super(cible, pointAttaque, 32, env);
        this.tourelle = t;
    }

    @Override
    public void agit() {
        attaquer();
        env.getTirs().remove(this);
    }

    public void attaquer() {
        for (Personnage p : this.env.getPersos()) {
            if ((p.getY() >= this.getY() - hitbox && p.getY() <= this.getY() + hitbox) &&
                    (p.getX() >= this.getX() - hitbox && p.getX() <= this.getX() + hitbox)) {
                p.seFaireSoigner(this.pointAttaque);
            }
        }
    }
}