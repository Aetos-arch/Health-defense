package td.modele;

public class TourelleVitamine extends Tourelle {
    Environnement env;

    // x
    public TourelleVitamine (int x, int y, Environnement env) {
        super(x, y, 3, env);
    }

    @Override
    public void tir(Personnage p) {
        // % idée
        Tir tir = new TirVitamine(this.xProperty().getValue(), this.yProperty().getValue(), 10, 10, env);
        env.tirs.add(tir);
    }

    //public Personnage viser () {

    //for (Personnage p : env.getPersos()) {

    //   }
    //}

}