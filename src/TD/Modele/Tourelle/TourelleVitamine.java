package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Modele.Tir.Position;
import TD.Modele.Tir.Tir;
import TD.Modele.Tir.TirVitamine;

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