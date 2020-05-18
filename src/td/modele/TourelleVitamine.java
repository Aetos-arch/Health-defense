package td.modele;

public class TourelleVitamine extends Tourelle {
    int nbMunitions;
    Environnement env;

    public TourelleVitamine () {
        super(10, 20);
    }

    public void tir(Personnage p) {
        Tir tir = new TirMitraillette(this.xProperty(), this.yProperty(), 10, 10, env);
    }

    //public Personnage viser () {

        //for (Personnage p : env.getPersos()) {

     //   }
    //}
}