package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Modele.Tir.Tir;
import TD.Modele.Tir.TirVaccin;
import TD.Utilitaire.Position;

import java.util.Optional;

public class TourelleVaccin extends TourelleDegatUnique {
    public TourelleVaccin(int x, int y, Environnement env) {
        super(x, y, env, 500, 30, 1000);
    }

    @Override
    public void agit() {
        if (delai % 60 == 0) {
            Optional<Personnage> optionalPersonnage = Optional.ofNullable(viser());
            if (optionalPersonnage.isPresent()) {
                Personnage personnage = optionalPersonnage.get();
                Position positionCible = new Position(personnage.getX() + 8, personnage.getY() + 8);
                Tir tir = new TirVaccin(positionCible, env, this);
                env.ajouterTir(tir);
            }
        }
        delai++;
    }
}
