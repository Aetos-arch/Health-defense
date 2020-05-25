package td.modele;

import javafx.beans.property.IntegerProperty;

public class TirVitamine extends TirAngle {

    public TirVitamine(int x, int y, int xCible, int yCible, Environnement env) {
        super(x, y,10, xCible, yCible,60, env, 5);
    }
}