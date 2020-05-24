package td.modele;

public class TourelleVitamine extends Tourelle {
    Environnement env;

    public TourelleVitamine (Environnement env) {
        super(10, env);
    }

    public void tir(Personnage p) {
        // %
        Tir tir = new TirMitraillette(this.xProperty().getValue(), this.yProperty().getValue(), 10, 10, env);
    }

}