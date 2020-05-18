package td.modele;

import javafx.beans.property.IntegerProperty;

public abstract class Tir {
    private IntegerProperty x;
    private IntegerProperty y;
    private int pointAttaque;
    private int v; // vitesse de deplacement
    private int dx,dy ; // direction
    private Environnement env;

    public Tir(IntegerProperty x, IntegerProperty y, int pointAttaque, Environnement env) {
        this.x = x;
        this.y = y;
        this.pointAttaque = pointAttaque;
        this.env = env;
    }


    public boolean estDansMap (int x, int y) {
        return (x > 0 && x < 800 && y > 0 && y < 480);
    }

    public abstract void agit (int x, int y);


    // Getter et Setter

    public int getX() {
        return x.getValue();
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public int getY() {
        return y.getValue();
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public void setY(int y) {
        this.y.set(y);
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
}
