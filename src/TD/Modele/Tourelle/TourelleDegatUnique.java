package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.InfecteGrave;
import TD.Modele.Personnage.Personnage;
import TD.Utilitaire.Position;

import java.util.ArrayList;

public abstract class TourelleDegatUnique extends Tourelle {
    protected int portee;

    public TourelleDegatUnique(int x, int y, Environnement env, int portee, int delai, int prix) {
        super(x, y, delai, env, prix);
        this.portee = portee;
    }

    public Personnage viser() {
        // Si pas de persos à portée return null
        if (listePersosAPortee().isEmpty()) {
            return null;
        }

        // Infecté grave à portée on vise eux en priorité
        else if (!filtrerInfectesGrave(listePersosAPortee()).isEmpty()) {
            ArrayList<Personnage> listeInfecteGrave = filtrerInfectesGrave(listePersosAPortee());
            return getPersoLePlusProche(listeInfecteGrave);
        }

        // Sinon les personnages pas infecté grave
        return getPersoLePlusProche(listePersosAPortee());
    }

    public ArrayList<Personnage> listePersosAPortee() {
        ArrayList<Personnage> persosAPortee = new ArrayList<>();

        for (Personnage p : env.getPersos()) {
            Position positionPersoActuel = new Position(p.getX(), p.getY());
            if (this.getPosition().distance(positionPersoActuel) <= portee) {
                persosAPortee.add(p);
            }
        }
        return persosAPortee;
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


    public Personnage getPersoLePlusProche(ArrayList<Personnage> listePersos) {
        Personnage persoPlusProche = listePersosAPortee().get(0);

        for (Personnage p : listePersos) {
            Position positionPersoProche = new Position(persoPlusProche.getX(), persoPlusProche.getY());
            Position positionPersoActuel = new Position(p.getX(), p.getY());

            if (this.getPosition().distance(positionPersoProche) > this.getPosition().distance(positionPersoActuel)) {
                persoPlusProche = p;
            }
        }
        return persoPlusProche;
    }

    public abstract void agit();

    public int getPortee() {
        return portee;
    }
}