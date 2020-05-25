package td.modele.tir;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import td.modele.Environnement;
import td.modele.personnage.Personnage;

import java.util.Objects;

public abstract class Tir {
    private static long idMax = 0;
    private long id;
    protected DoubleProperty xProperty, yProperty;
    protected int pointAttaque;
    protected int v;
    protected double dx,dy;
    protected double xCible, yCible;
    protected Environnement env;
    private double portee;

    public Tir(int x, int y, int pointAttaque, int xCible, int yCible, int v, Environnement env, double zone) {
        this.xProperty = new SimpleDoubleProperty(x);
        this.yProperty = new SimpleDoubleProperty(y);
        this.pointAttaque = pointAttaque;
        this.xCible = xCible;
        this.yCible = yCible;
        this.v = v;
        this.env = env;
        this.portee = zone;
        this.id = idMax++;
        env.tirs.add(this);
    }

    // A mettre dans une class static : massDataBulder, static function
    public static boolean estDansMap (double positionX, double positionY) {
        return (positionX > 0 && positionX < 800 && positionY > 0 && positionY < 480);
    }

    public boolean collision () {
        for (Personnage p : this.env.getPersos()) {
            if ((this.getY() - portee <= yCible && yCible <= this.getY() + portee) &&
                    (this.getX() - portee <=  xCible && xCible <= this.getX() + portee)) {
                return true;
            }
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
        if (estDansMap(this.getX()+(dx) , this.getY()+(dy))) {
            // Si le tir a touché ça inflige les dégats sinon met à jour la position du tir
            if (!collision()) {
                this.xProperty().setValue(this.getX()+dx);
                this.yProperty().setValue(this.getY()+(dy));
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

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
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