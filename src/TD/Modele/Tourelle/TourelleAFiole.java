package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;

import java.util.ArrayList;

public class TourelleAFiole extends Tourelle {

    public TourelleAFiole (int x, int y, Environnement env) {
        super(x, y, 100, env, 500, 2000);
    }

    @Override
    public void agit() {

    }

   /* public Personnage viser () {
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
    }*/
}
