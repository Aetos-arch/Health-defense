package Tower_Defense.Modele.Tir;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Tourelle.TourelleVitamine;
import Tower_Defense.Utilitaire.Position;

public class TirVitamine extends TirDirection {

    public TirVitamine(Position cible, Environnement env, TourelleVitamine t) {
        super(15, cible, 15, env, 10, t);
    }
}