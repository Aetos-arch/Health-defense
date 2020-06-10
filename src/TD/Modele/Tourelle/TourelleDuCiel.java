package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Modele.Tir.Tir;
import TD.Modele.Tir.TirCiel;
import TD.Utilitaire.Position;

import java.util.ArrayList;
import java.util.Optional;


public class TourelleDuCiel extends Tourelle {

    public TourelleDuCiel(int x, int y, Environnement env) {
        super(x, y, 100, env, 500, 0);
    }

    @Override
    public void agit() {
        if (delai % 80 == 0) {
            Optional<Personnage> optionalPersonnage = Optional.ofNullable(viser());
            if (optionalPersonnage.isPresent()) {
               Personnage personnage = optionalPersonnage.get();
               Position positionCible = new Position(personnage.getX() + 8, personnage.getY() + 8);
               Tir tir = new TirCiel(90, positionCible, this.env, this);
               env.ajouterTir(tir);
            }
        }
       delai++;
    }

    public Personnage viser () {
        // Si pas de persos à portée return null
        if (getListePersosAPortee().isEmpty())
            return null;

        ArrayList<Personnage> listeInfecteGrave = filtrerInfectesGrave(getListePersosAPortee());
        // Infecté grave à portée on vise eux en priorité
        if (!listeInfecteGrave.isEmpty())
            return getPersoLePlusEntoure(listeInfecteGrave);

        // Sinon les personnages pas infecté grave
        return getPersoLePlusEntoure(getListePersosAPortee());
    }

    public Personnage getPersoLePlusEntoure (ArrayList<Personnage> listePersosAPortee) {
        if (!listePersosAPortee.isEmpty()) {
            int i = 0, y = 0;
            int nombreDePersosAPortee = 0, nombreDePersosAPorteeMax = 0;
            Personnage persoLePlusEntoure = listePersosAPortee.get(0);

            while (i < listePersosAPortee.size()) {
                Position positionA = new Position(listePersosAPortee.get(i).getX(), listePersosAPortee.get(i).getY());
                while (y < listePersosAPortee.size()) {
                    Position positionB = new Position(listePersosAPortee.get(y).getX(), listePersosAPortee.get(y).getY());
                    if (positionA.distance(positionB) < 100) {
                        nombreDePersosAPortee++;
                    }
                    y++;
                }
                if (nombreDePersosAPortee > nombreDePersosAPorteeMax) {
                    nombreDePersosAPorteeMax = nombreDePersosAPortee;
                    persoLePlusEntoure = listePersosAPortee.get(i);
                }
                i++;
            }
            return persoLePlusEntoure;
        } else
            return null;
    }
}