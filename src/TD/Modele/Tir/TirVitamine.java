package TD.Modele.Tir;

import TD.Modele.Environnement;

public class TirVitamine extends TirDirection {

    public TirVitamine(Position p, Position cible, Environnement env) {
        super(p, 1, cible, 5, env, 19);
    }
}