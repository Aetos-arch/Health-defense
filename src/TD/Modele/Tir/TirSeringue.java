package TD.Modele.Tir;

import TD.Modele.Environnement;
import TD.Modele.Tourelle.TourelleSeringue;
import TD.Utilitaire.Position;

public class TirSeringue extends TirDirection {
    public TirSeringue(Position cible, Environnement env, TourelleSeringue t) {
        super(100, cible, 20, env, 20, t);
    }
}