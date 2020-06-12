package Tower_Defense.Modele.Tourelle;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Personnage.Personnage;
import Tower_Defense.Modele.Tir.Tir;
import Tower_Defense.Modele.Tir.TirSeringue;
import Tower_Defense.Utilitaire.Position;

import java.util.Optional;

public class TourelleSeringue extends TourelleDegatUnique {

    public TourelleSeringue(int x, int y, Environnement env) {
        super(x, y, env, 200, 20, 3000);
    }

    @Override
    public void agit() {
        this.ralentie();
        if (delai % 40 == 0) {
            Optional<Personnage> optionalPersonnage = Optional.ofNullable(viser());
            if (optionalPersonnage.isPresent()) {
                Personnage personnage = optionalPersonnage.get();
                Position positionCible = new Position(personnage.getX(), personnage.getY());
                Tir tir = new TirSeringue(positionCible, this.env, this);
                this.env.ajouterTir(tir);
            }
        }
        delai++;
    }

    public void ralentie() {
        for (Personnage p : this.env.getPersos()) {
            if (((p.getY() >= this.getY() - 70 && p.getY() <= this.getY() + 70) &&
                    (p.getX() >= this.getX() - 70 && p.getX() <= this.getX() + 70)) && !p.estSain()) {
                p.ralentir();
            } else
                p.nonRalenti();
        }
    }
}