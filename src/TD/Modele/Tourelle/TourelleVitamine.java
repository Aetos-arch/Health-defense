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
        Position cible = new Position(p.getX(), p.getY());
        Tir tir = new TirVitamine(this.getPosition(), cible, env);
        env.tirs.add(tir);
    }

    public Personnage viser() {
        Personnage persoPlusProche = env.getPersos().get(0);
        Position positionPersonnageEnCours = new Position(persoPlusProche.getX(), persoPlusProche.getY());

        for (Personnage p : env.getPersos()) {

        }
    }

}