package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Utilitaire.Position;

public abstract class Tourelle {
    private Position position;
    protected Environnement env;
    protected int delai;
    protected int portee;
    private int prix;


    public Tourelle(int x, int y, int delai, Environnement env, int portee, int prix) {
        position = new Position(x, y);
        this.env = env;
        this.delai = delai;
        this.portee = portee;
        this.prix = prix;
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
    
    public int getPrix() {
    	return this.prix;
    }
}