package Tower_Defense.Utilitaire;

import javafx.beans.property.SimpleDoubleProperty;

public class PositionProperty implements CoordonneProperty {
    private SimpleDoubleProperty xProperty;
    private SimpleDoubleProperty yProperty;

    public PositionProperty(CoordonneProperty coords) {
        this(coords.getX(), coords.getY());
    }

    public PositionProperty(double xProperty, double yProperty) {
        this.xProperty = new SimpleDoubleProperty(xProperty);
        this.yProperty = new SimpleDoubleProperty(yProperty);
    }

    public PositionProperty multiplier(double nbr) {
        this.setX(this.getX() * nbr);
        this.setY(this.getY() * nbr);
        return this;
    }

    public double distance(Position loc) {
        return Math.sqrt(Math.pow(this.getX() - loc.getX(), 2) + Math.pow(this.getY() - loc.getY(), 2));
    }

    @Override
    public double getX() {
        return xProperty.doubleValue();
    }

    @Override
    public double getY() {
        return yProperty.doubleValue();
    }

    public void setX(double x) {
        this.xProperty.setValue(x);
    }

    public void setY(double y) {
        this.yProperty.setValue(y);
    }

    @Override
    public SimpleDoubleProperty getXProperty() {
        return xProperty;
    }

    @Override
    public SimpleDoubleProperty getYProperty() {
        return yProperty;
    }
}
