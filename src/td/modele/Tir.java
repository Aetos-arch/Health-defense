package td.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tir {
    protected IntegerProperty xProperty, yProperty;
    private int pointAttaque;
    protected int v;
    protected int dx,dy;
    int xCible, yCible;
    protected Environnement env;

    public Tir(int x, int y, int pointAttaque, int xCible, int yCible, int v, Environnement env) {
        this.xProperty = new SimpleIntegerProperty();
        this.yProperty = new SimpleIntegerProperty();
        this.xProperty.setValue(x);
        this.yProperty.setValue(y);
        this.pointAttaque = pointAttaque;
        this.xCible = xCible;
        this.yCible = yCible;
        this.v = v;
        this.env = env;
    }

    public boolean estDansMap (int positionX, int positionY) {
        return (positionX > 0 && positionX < 800 && positionY > 0 && positionY < 480);
    }

    public abstract void agit ();

    // Getter et Setter à voir

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
}