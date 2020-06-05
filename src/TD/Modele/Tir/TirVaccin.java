package TD.Modele.Tir;

import TD.Modele.Environnement;
import TD.Modele.Tourelle.TourelleVaccin;
import TD.Utilitaire.Position;

public class TirVaccin extends TirDirection {
    public TirVaccin(Position cible, Environnement env, TourelleVaccin t) {
        super(50, cible, 40, env, 20, t);
    }
}
