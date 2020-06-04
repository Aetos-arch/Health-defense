package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Utilitaire.Position;

public abstract class Tourelle {
    private Position position;
    protected Environnement env;
    protected int delai;

    public Tourelle(int x, int y, int delai, Environnement env) {
        position = new Position(x, y);
        this.env = env;
        this.delai = delai;
    }

    public abstract void agit();

    public Position getPosition() {
        return position;
    }

    public double getX() {
        return position.getX();
    }

    public double getY() {
        return position.getY();
    }

}