package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Utilitaire.Position;

import java.util.ArrayList;

public class TourelleSeringue extends Tourelle {
    private int portee;
    private int delai;

    public TourelleSeringue(int x, int y, Environnement env) {
        super(x, y, 3, env);
        this.portee = 200;
        this.delai = 0;
    }

    @Override
    public void agit() {
        if (delai % 100 == 0) {
            Personnage p = viser();
            if (p != null) {
                Position positionCible = new Position(p.getX() + 8, p.getY() + 8);
                // Tir tir = new TirVitamine(this.getPosition(), positionCible, env, this);
                //   env.ajouterTir(tir);
            }
        }
        delai++;
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
}