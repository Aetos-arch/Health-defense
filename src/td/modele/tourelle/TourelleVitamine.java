package td.modele.tourelle;

import td.modele.Environnement;
import td.modele.personnage.Personnage;
import td.modele.tir.Position;
import td.modele.tir.Tir;
import td.modele.tir.TirVitamine;

public class TourelleVitamine extends Tourelle {
    public TourelleVitamine (int x, int y, Environnement env) {
        super(x, y, 3, env);
    }

    @Override
    public void tir(Personnage p) {
        // % idée
        Position cible = new Position(100, 229);
        Tir tir = new TirVitamine(this.xProperty().getValue(), this.yProperty().getValue(), cible, env);
        env.tirs.add(tir);
    }

    //public Personnage viser () {

    //for (Personnage p : env.getPersos()) {

    //   }
    //}

}