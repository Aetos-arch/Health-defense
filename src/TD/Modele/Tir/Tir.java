package TD.Modele.Tir;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.Objects;

public abstract class Tir {
    private static long idMax = 0;
    private long id;
    protected DoubleProperty xProperty, yProperty;
    protected int pointAttaque;
    protected int v;
    protected Vecteur direction;
    protected Environnement env;
    private double portee;

    public Tir(int x, int y, int pointAttaque, int v, Environnement env, double zone) {
        this.xProperty = new SimpleDoubleProperty(x);
        this.yProperty = new SimpleDoubleProperty(y);
        this.pointAttaque = pointAttaque;
        direction = new Vecteur();
        this.v = v;
        this.env = env;
        this.portee = zone; // refactor
        this.id = idMax++;
        env.tirs.add(this);
    }

    // A mettre dans une class static : massDataBulder, static function
    public static boolean estDansMap (double positionX, double positionY) {
        return (positionX > 0 && positionX < 800 && positionY > 0 && positionY < 480);
    }

    public boolean collision () {
        for (Personnage p : this.env.getPersos()) {
            if ((this.getY() - portee <= p.getY() && p.getY() <= this.getY() + portee) &&
                    (this.getX() - portee <=  p.getX() && p.getX() <= this.getX() + portee)) {
                p.seFaireSoigner(pointAttaque);
                return true;
            }
        }
        return false;
    }

    public void agit () {
        // Si dans la Map
        if (estDansMap(this.getX()+(direction.getX()) , this.getY()+(direction.getY()))) {
            // Si le tir a touché ça inflige les dégats sinon met à jour la position du tir
            if (!collision()) {
                this.xProperty().setValue(this.getX()+direction.getX());
                this.yProperty().setValue(this.getY()+(direction.getY()));
            } else {
                System.out.println("supprimer tir");
                env.tirs.remove(this);
            }
        }
    }


    /**** Getter et Setter ****/


    public double getX() {
        return xProperty.getValue();
    }

    public DoubleProperty xProperty() {
        return xProperty;
    }

    public void setX(int x) {
        this.xProperty.set(x);
    }

    public double getY() {
        return yProperty.getValue();
    }

    public DoubleProperty yProperty() {
        return yProperty;
    }

    public void setY(int y) {
        this.yProperty.set(y);
    }

    public int getPointAttaque() {
        return pointAttaque;
    }

    public void setPointAttaque(int pointAttaque) {
        this.pointAttaque = pointAttaque;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }


    // Verif l'égalité comme un ==
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tir tir = (Tir) o;
        return id == tir.id;
    }

    // fonction similaire au equals qui va verif l'égalité entre deux objects
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}