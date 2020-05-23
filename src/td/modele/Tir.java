package td.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Objects;

public abstract class Tir {
    private static long idMax = 0;
    private long id;
    protected IntegerProperty xProperty, yProperty;
    protected int pointAttaque;
    protected int v;
    protected int dx,dy;
    protected int xCible, yCible;
    protected Environnement env;
    private double portee;

    public Tir(int x, int y, int pointAttaque, int xCible, int yCible, int v, Environnement env, double zone) {
        this.xProperty = new SimpleIntegerProperty(x);
        this.yProperty = new SimpleIntegerProperty(y);
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
    public static boolean estDansMap (int positionX, int positionY) {
        return (positionX > 0 && positionX < 800 && positionY > 0 && positionY < 480);
    }

    public void agit () {
        System.out.println("Methode agit");
        // Si dans la Map
        if (estDansMap(this.getX()+(this.v*dx) , this.getY()+(this.v*dy))) {
            System.out.println("est dans la map");
            // Si le tir a touché ça inflige les dégats sinon met à jour la position du tir
            if (!collision()) {
                System.out.println("pas de collision");
                this.xProperty().setValue(this.getX()+(this.v*dx));
                this.yProperty().setValue(this.getY()+(this.v*dy));
            } else {
                System.out.println("supprimer tir");
                env.tirs.remove(this);
            }
        }
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


    /**** Getter et Setter ****/


    public int getX() {
        return xProperty.getValue();
    }

    public IntegerProperty xProperty() {
        return xProperty;
    }

    public void setX(int x) {
        this.xProperty.set(x);
    }

    public int getY() {
        return yProperty.getValue();
    }

    public IntegerProperty yProperty() {
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

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
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