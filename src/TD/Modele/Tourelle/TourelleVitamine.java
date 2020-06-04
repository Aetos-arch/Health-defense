package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Modele.Tir.Tir;
import TD.Modele.Tir.TirVitamine;
import TD.Utilitaire.Position;

public class TourelleVitamine extends TourelleDegatUnique {

    public TourelleVitamine(int x, int y, Environnement env) {
        super(x, y, env, 100, 10);
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
}