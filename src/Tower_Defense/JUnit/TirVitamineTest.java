package Tower_Defense.JUnit;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Personnage.InfecteSansSymp;
import Tower_Defense.Modele.Personnage.Personnage;
import Tower_Defense.Modele.Tir.TirDirection;
import Tower_Defense.Modele.Tir.TirVitamine;
import Tower_Defense.Modele.Tourelle.TourelleVitamine;
import Tower_Defense.Utilitaire.Position;
import org.junit.Before;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class TirVitamineTest {

    TourelleVitamine tourelle;
    TirVitamine tir;
    Environnement env;
    Personnage personnage;
    Position positionCible;

    @Before
    public void setUp() throws Exception {
        this.env = new Environnement();
        this.tourelle = new TourelleVitamine(26*16, 15*16, env);
        this.personnage = new InfecteSansSymp(26, 15, env);
        this.env.ajouterPers(this.personnage);
        this.env.ajouterTour(tourelle);
    }

    @org.junit.Test
    public void testCreationTir() {
        this.tourelle.agit();
        assertNotNull(this.env.getTirs());
    }

    @org.junit.Test
    public void testCollision() {
        this.tourelle.agit();
        if (this.env.getTirs().get(0) instanceof TirDirection) {
            assertTrue(((TirDirection) this.env.getTirs().get(0)).collision());
        }
    }
}