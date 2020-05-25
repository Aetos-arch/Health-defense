package td.modele.tir;

import td.modele.Environnement;

public class TirVitamine extends TirDirection {

    public TirVitamine(int x, int y, Position cible, Environnement env) {
        super(x, y,10, cible,30, env, 5);
    }
}