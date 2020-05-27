package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Modele.Tir.Position;

public abstract class Tourelle {
    Position position;
    private int cadence;
    private int portee; // Pour viser
    Environnement env; //


    public Tourelle(int x, int y, int c, Environnement env) {
        position = new Position(x, y);
        this.cadence = c;
        this.env = env;
        env.tours.add(this);
    }

    public abstract void tir(Personnage p);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getCadence() {
        return cadence;
    }

    public void setCadence(int cadence) {
        this.cadence = cadence;
    }


}