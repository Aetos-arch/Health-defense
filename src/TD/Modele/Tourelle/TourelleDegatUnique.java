package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Utilitaire.Position;

import java.util.ArrayList;

public class TourelleDegatUnique extends Tourelle {
    protected int portee;

    public TourelleDegatUnique(int x, int y, Environnement env, int portee, int delai) {
        super(x, y, delai, env);
        this.portee = portee;
    }

    public ArrayList<Personnage> estAPortee() {
        ArrayList<Personnage> persosAPortee = new ArrayList<>();

        for (Personnage p : env.getPersos()) {
            Position positionPersoActuel = new Position(p.getX(), p.getY());
            if (this.getPosition().distance(positionPersoActuel) <= portee) {
                persosAPortee.add(p);
            }
        }
        return persosAPortee;
    }

    public Personnage viser() {
        if (estAPortee().size() == 0) {
            return null;
        }

        Personnage persoPlusProche = estAPortee().get(0);

        for (Personnage p : estAPortee()) {
            Position positionPersoProche = new Position(persoPlusProche.getX(), persoPlusProche.getY());
            Position positionPersoActuel = new Position(p.getX(), p.getY());

            if (this.getPosition().distance(positionPersoProche) > this.getPosition().distance(positionPersoActuel)) {
                persoPlusProche = p;
            }
        }
        return persoPlusProche;
    }

    //public ArrayList listeInfecteGrave (ArrayList<Personnage>) {
    //
    //}

    @Override
    public void agit() {

    }

    public int getPortee() {
        return portee;
    }
}