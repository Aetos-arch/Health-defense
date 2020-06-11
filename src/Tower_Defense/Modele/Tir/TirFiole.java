package Tower_Defense.Modele.Tir;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Personnage.Personnage;
import Tower_Defense.Modele.Tourelle.TourelleFiole;
import Tower_Defense.Utilitaire.Position;


public class TirFiole extends Tir {
    protected TourelleFiole tourelle;
    private int delai;

    public TirFiole(int pointAttaque, Position cible, Environnement env, TourelleFiole t) {
        super(cible, pointAttaque, 32, env);
        this.tourelle = t;
        this.delai = 20;
    }

    @Override
    public void agit() {
        attaquer();

        if (delai % 40 == 0) {
            this.env.getTirs().remove(this);
        }
        delai++;
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