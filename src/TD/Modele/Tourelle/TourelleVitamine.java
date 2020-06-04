package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Modele.Tir.Tir;
import TD.Modele.Tir.TirVitamine;
import TD.Utilitaire.Position;

public class TourelleVitamine extends TourelleViser {
    private int delai;

    public TourelleVitamine(int x, int y, Environnement env) {
        super(x, y, 3, env);
        this.delai = 0;
    }

    @Override
    public void agit() {
        if (delai % 2 == 0) {
            Personnage p = viser();
            if (p != null) {
                Position positionCible = new Position(p.getX() + 8, p.getY() + 8);
                Tir tir = new TirVitamine(positionCible, env, this);
                env.ajouterTir(tir);
            }
        }
        delai++;
    }

    public int getPortee() {
        return this.portee;
    }

    public void setPortee(int portee) {
        this.portee = portee;
    }
}