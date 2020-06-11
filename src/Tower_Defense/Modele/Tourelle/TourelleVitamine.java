package Tower_Defense.Modele.Tourelle;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Personnage.Personnage;
import Tower_Defense.Modele.Tir.Tir;
import Tower_Defense.Modele.Tir.TirVitamine;
import Tower_Defense.Utilitaire.Position;

import java.util.Optional;

public class TourelleVitamine extends TourelleDegatUnique {

    public TourelleVitamine(int x, int y, Environnement env) {
        super(x, y, env, 100, 10, 500);
    }

    @Override
    public void agit() {
        if (delai % 2 == 0) {
            Optional<Personnage> optionalPersonnage = Optional.ofNullable(viser());
            if (optionalPersonnage.isPresent()) {
                Personnage personnage = optionalPersonnage.get();
                Position positionCible = new Position(personnage.getX(), personnage.getY());
                Tir tir = new TirVitamine(positionCible, this.env, this);
                this.env.ajouterTir(tir);
            }
        }
        delai++;
    }
}