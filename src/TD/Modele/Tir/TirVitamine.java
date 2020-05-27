package TD.Modele.Tir;

import TD.Modele.Environnement;

public class TirVitamine extends TirDirection {

    public TirVitamine(int x, int y, Position cible, Environnement env) {
        super(x, y, 10, cible, 5, env, 5);
    }
}