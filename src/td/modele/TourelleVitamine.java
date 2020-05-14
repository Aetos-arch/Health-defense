package td.modele;

public class TourelleVitamine extends Tourelle {
    public TourelleVitamine () {
        super(10, 3);
    }

    public void tir(Personnage p) {
        Tir tir = new Tir(this.xProperty(), this.yProperty(), 10, 4);


    }
}
