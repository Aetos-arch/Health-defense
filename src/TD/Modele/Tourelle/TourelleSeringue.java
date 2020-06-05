package TD.Modele.Tourelle;

import TD.Modele.Environnement;
import TD.Modele.Personnage.Personnage;
import TD.Modele.Tir.Tir;
import TD.Modele.Tir.TirSeringue;
import TD.Utilitaire.Position;

import java.util.Optional;

public class TourelleSeringue extends TourelleDegatUnique {

    public TourelleSeringue(int x, int y, Environnement env) {
        super(x, y, env, 200, 20, 750);
    }

    @Override
    public void agit() {
        if (delai % 40 == 0) {
            Optional<Personnage> optionalPersonnage = Optional.ofNullable(viser());
            if (optionalPersonnage.isPresent()) {
                Personnage personnage = optionalPersonnage.get();
                Position positionCible = new Position(personnage.getX() + 8, personnage.getY() + 8);
                Tir tir = new TirSeringue(positionCible, env, this);
                env.ajouterTir(tir);
            }
        }
        delai++;
    }
}