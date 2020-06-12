package Tower_Defense.Modele.Tir;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Utilitaire.Position;
import Tower_Defense.Utilitaire.PositionProperty;
import Tower_Defense.Utilitaire.Vecteur;
import javafx.beans.property.DoubleProperty;

public abstract class Tir {
    protected PositionProperty positionProperty;
    protected int pointAttaque;
    protected Vecteur direction;
    protected Environnement env;
    protected int hitbox;

    public Tir(Position p, int pointAttaque, int hitbox, Environnement env) {
        this.positionProperty = new PositionProperty(p.getX(), p.getY());
        this.pointAttaque = pointAttaque;
        direction = new Vecteur();
        this.env = env;
        this.hitbox = hitbox;
    }

    public static boolean estDansMap(double positionX, double positionY) {
        return (positionX > 0 && positionX < 800 && positionY > 0 && positionY < 480);
    }

    public abstract void agit();

    /**** Getter et Setter ****/

    public double getX() {
        return positionProperty.getX();
    }

    public DoubleProperty xProperty() {
        return positionProperty.getXProperty();
    }

    public void setX(int x) {
        this.positionProperty.setX(x);
    }

    public double getY() {
        return positionProperty.getY();
    }

    public DoubleProperty yProperty() {
        return positionProperty.getYProperty();
    }

    public void setY(int y) {
        this.positionProperty.setY(y);
    }

    public PositionProperty getPosition() {
        return positionProperty;
    }

}