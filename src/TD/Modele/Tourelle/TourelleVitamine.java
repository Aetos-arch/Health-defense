package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Modele.Tir.Tir;
import TD.Modele.Tir.TirVitamine;
import TD.Utilitaire.Position;

import java.util.Optional;

public class TourelleVitamine extends TourelleDegatUnique {

    public TourelleVitamine(int x, int y, Environnement env) {
        super(x, y, env, 100, 10, 1);
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