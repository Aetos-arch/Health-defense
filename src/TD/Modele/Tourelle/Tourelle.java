package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Utilitaire.Position;

public abstract class Tourelle {
    private Position position;
    private int cadence;
    protected Environnement env;

    public Tourelle(int x, int y, int c, Environnement env) {
        position = new Position(x, y);
        this.cadence = c;
        this.env = env;
    }

    public abstract void agit();

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getCadence() {
        return cadence;
    }

    public void setCadence(int cadence) {
        this.cadence = cadence;
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

}