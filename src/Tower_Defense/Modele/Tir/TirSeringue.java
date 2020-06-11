package Tower_Defense.Modele.Tir;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Tourelle.TourelleSeringue;
import Tower_Defense.Utilitaire.Position;

public class TirSeringue extends TirDirection {
    public TirSeringue(Position cible, Environnement env, TourelleSeringue t) {
        super(60, cible, 40, env, 20, t);
    }
}