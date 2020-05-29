package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Modele.Tir.Position;
import TD.Modele.Tir.Tir;
import TD.Modele.Tir.TirVitamine;

import java.util.ArrayList;

public class TourelleVitamine extends Tourelle {
    private int portee;
    private static int delai=0;
    
    public TourelleVitamine(int x, int y, Environnement env) {
        super(x, y, 3, env);
        this.portee = 100;
    }

    @Override
    public void agit() {
    	if(delai%30 == 0) {
	        Personnage p = viser();
	        if(p != null) {
	        Position positionCible = new Position(p.getX(), p.getY());
	        Tir tir = new TirVitamine(this.getPosition(), positionCible, env);
	        env.tirs.add(tir);
	        }
    	}
    	delai++;
    }

    public ArrayList<Personnage> estAPortee() {
        ArrayList<Personnage> persosAPortee = new ArrayList<>();

        for (Personnage p : env.getPersos()) {
            Position positionPersoActuel = new Position(p.getX(), p.getY());
            if (this.getPosition().distance(positionPersoActuel) < portee) {
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