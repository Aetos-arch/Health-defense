package td.modele;

public class Vecteur implements Coordonnee {
    private double x;
    private double y;

    public Vecteur (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vecteur(Coordonnee start, Coordonnee end) {
        this(end.getX() - start.getX(), end.getY() - start.getY());
    }

    public Vecteur(Coordonnee coords) {
        this(coords.getX(), coords.getY());
    }

    public Vecteur add(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vecteur add(Vecteur vect) {
        return this.add(vect.getX(), vect.getY());
    }

    public Vecteur subtract(double x, double y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vecteur subtract(Vecteur vect) {
        return this.subtract(vect.getX(), vect.getY());
    }

    public Vecteur multiply(double factor) {
        this.x *= factor;
        this.y *= factor;
        return this;
    }

    public Vecteur divide(double factor) {
        this.x /= factor;
        this.y /= factor;
        return this;
    }

    public Vecteur negate() {
        return this.multiply(-1);
    }

    public Vecteur copy() {
        return new Vecteur(this);
    }

    public double normeVecteur () {
        return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
    }

    public double angle(boolean degrees) {
        double angle = Math.atan2(this.y, this.x);
        return degrees ? Math.toDegrees(angle) : angle;
    }

    public double angle() {
        return this.angle(false);
    }

    public Position toLocation() {
        return new Position(this);
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Vector [x=" + x + ", y=" + y + "]";
    }
}
