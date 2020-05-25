package td.modele;

import javafx.beans.property.ReadOnlyDoubleWrapper;

public class Position implements Coordonnee {
    private ReadOnlyDoubleWrapper xProperty;
    private ReadOnlyDoubleWrapper yProperty;

    public Position(Coordonnee coords) {
        this(coords.getX(), coords.getY());
    }

    public Position(double x, double y) {
        this.xProperty = new ReadOnlyDoubleWrapper(x);
        this.yProperty = new ReadOnlyDoubleWrapper(y);
    }

    public Position add(double x, double y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
        return this;
    }

    public Position add(Coordonnee coords) {
        return this.add(coords.getX(), coords.getY());
    }

    public Position subtract(double x, double y) {
        this.setX(this.getX() - x);
        this.setY(this.getY() - y);
        return this;
    }

    public Position subtract(Coordonnee coords) {
        return this.subtract(coords.getX(), coords.getY());
    }

    public Position multiply(double factor) {
        this.setX(this.getX() * factor);
        this.setY(this.getY() * factor);
        return this;
    }

    public Position round() {
        this.setX(this.getRoundX());
        this.setY(this.getRoundY());
        return this;
    }

    public Position center() {
        this.setX(this.getCenterX());
        this.setY(this.getCenterY());
        return this;
    }

    public Position zero() {
        this.setX(0);
        this.setY(0);
        return this;
    }

    public Position copy() {
        return new Position(this);
    }

    public double distance(Position loc) {
        return Math.sqrt(Math.pow(this.getX() - loc.getX(), 2) + Math.pow(this.getY() - loc.getY(), 2));
    }

	/*public boolean isInMap() {
		return this.getX() >= 0 && this.getX() < GameMap.WIDTH && this.getY() >= 0 && this.getY() < GameMap.HEIGHT;
	}*/

    public Vecteur toVector() {
        return new Vecteur(this);
    }

    @Override
    public final double getX() {
        return this.xProperty.get();
    }

    @Override
    public final double getY() {
        return this.yProperty.get();
    }

	/*public final double getPixelX() {
		return this.getX() * GameMap.TILE_SIZE;
	}

	public final double getPixelY() {
		return this.getY() * GameMap.TILE_SIZE;
	}*/

    public final double getRoundX() {
        return Math.floor(this.getX());
    }

    public final double getRoundY() {
        return Math.floor(this.getY());
    }

    public final double getCenterX() {
        return this.getRoundX() + 0.5;
    }

    public final double getCenterY() {
        return this.getRoundY() + 0.5;
    }

    public final Position setX(double x) {
        this.xProperty.set(x);
        return this;
    }

    public final Position setY(double y) {
        this.yProperty.set(y);
        return this;
    }

    public final ReadOnlyDoubleWrapper xProperty() {
        return this.xProperty;
    }

    public final ReadOnlyDoubleWrapper yProperty() {
        return this.yProperty;
    }

    public boolean equals(Position loc) {
        return this.getX() == loc.getX() && this.getY() == loc.getY();
    }

    public boolean equalsCenter(Position loc) {
        return this.copy().center().equals(loc.copy().center());
    }

    @Override
    public String toString() {
        return "Location [x=" + xProperty.get() + ", y=" + yProperty.get() + "]";
    }
}