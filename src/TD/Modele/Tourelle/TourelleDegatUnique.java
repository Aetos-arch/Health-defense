package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.InfecteGrave;
import TD.Modele.Personnage.Personnage;
import TD.Utilitaire.Position;

import java.util.ArrayList;

public abstract class TourelleDegatUnique extends Tourelle {

    public TourelleDegatUnique(int x, int y, Environnement env, int portee, int delai, int prix) {
        super(x, y, delai, env, portee, prix);
        this.portee = portee;
    }

    public Personnage viser() {
        // Si pas de persos à portée return null
        if (listePersosAPortee().isEmpty()) {
            return null;
        }

        ArrayList<Personnage> listeInfecteGrave = filtrerInfectesGrave(listePersosAPortee());
        // Infecté grave à portée on vise eux en priorité
        if (!listeInfecteGrave.isEmpty()) {
            return getPersoLePlusProche(listeInfecteGrave);
        }

        // Sinon les personnages pas infecté grave
        return getPersoLePlusProche(listePersosAPortee());
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