package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.InfecteGrave;
import TD.Modele.Personnage.Personnage;
import TD.Utilitaire.Position;

import java.util.ArrayList;

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

    public ArrayList<Personnage> getListePersosAPortee() {
        ArrayList<Personnage> listePersosAPortee = new ArrayList<>();

        for (Personnage p : env.getPersos()) {
            Position positionPersoActuel = new Position(p.getX(), p.getY());
            if (this.getPosition().distance(positionPersoActuel) <= portee && !p.estSain()) {
                listePersosAPortee.add(p);
            }
        }
        return listePersosAPortee;
    }

    public ArrayList<Personnage> filtrerInfectesGrave(ArrayList<Personnage> listePersos) {
        ArrayList<Personnage> listePersosInfecteGrave = new ArrayList<>();
        for (Personnage p : listePersos) {
            if (p instanceof InfecteGrave) {
                listePersosInfecteGrave.add(p);
            }
        }
        return listePersosInfecteGrave;
    }

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