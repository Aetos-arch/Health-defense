package Tower_Defense.Utilitaire;

public class Vecteur implements Coordonnee {
    private double x;
    private double y;

    public Vecteur(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vecteur () {
        this.x = 0;
        this.y = 0;
    }

    public Vecteur(Coordonnee a, Coordonnee b) {
        this(b.getX() - a.getX(), b.getY() - a.getY());
    }

    public Vecteur(Coordonnee coords) {
        this(coords.getX(), coords.getY());
    }

    public Vecteur ajouter(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vecteur soustraire(double x, double y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vecteur multiplier (double nbr) {
        this.x *= nbr;
        this.y *= nbr;
        return this;
    }

    public double normeVecteur () {
        return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
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
        return "Vecteur [x=" + x + ", y=" + y + "]";
    }
}