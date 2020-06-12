package Tower_Defense.Modele.Tourelle;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Personnage.Personnage;
import Tower_Defense.Modele.Tir.Tir;
import Tower_Defense.Modele.Tir.TirVaccin;
import Tower_Defense.Utilitaire.Position;

import java.util.Optional;

public class TourelleVaccin extends TourelleDegatUnique {
    public TourelleVaccin(int x, int y, Environnement env) {
        super(x, y, env, 500, 30, 3000);
    }

    @Override
    public void agit() {
        if (delai % 60 == 0) {
            Optional<Personnage> optionalPersonnage = Optional.ofNullable(viser());
            if (optionalPersonnage.isPresent()) {
                Personnage personnage = optionalPersonnage.get();
                Position positionCible = new Position(personnage.getX(), personnage.getY());
                Tir tir = new TirVaccin(positionCible, this.env, this);
                this.env.ajouterTir(tir);
            }
        }
        delai++;
    }
}