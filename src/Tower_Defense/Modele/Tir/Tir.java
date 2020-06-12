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
        this.direction = new Vecteur();
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

    public DoubleProperty getXProperty() {
        return positionProperty.getXProperty();
    }

    public double getY() {
        return positionProperty.getY();
    }

    public DoubleProperty getYProperty() {
        return positionProperty.getYProperty();
    }

    public PositionProperty getPosition() {
        return positionProperty;
    }
}