package Tower_Defense.JUnit;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Personnage.InfecteSansSymp;
import Tower_Defense.Modele.Personnage.Personnage;
import Tower_Defense.Modele.Tourelle.TourelleVitamine;
import Tower_Defense.Utilitaire.Position;
import org.junit.Before;

import static org.junit.Assert.*;

public class TourelleDegatUniqueTest {

    TourelleVitamine tourelle;
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
    public void testAPortee() {
        assertFalse(tourelle.getListePersosAPortee().isEmpty());

        tourelle.setPosition(27*16, 16*16);
        assertFalse(tourelle.getListePersosAPortee().isEmpty());

        tourelle.setPosition(40*16, 30*16);
        assertTrue(tourelle.getListePersosAPortee().isEmpty());
    }

    @org.junit.Test
    public void testFocusInfecteGrave() {
        assertFalse(tourelle.getListePersosAPortee().isEmpty());

        tourelle.setPosition(27*16, 16*16);
        assertFalse(tourelle.getListePersosAPortee().isEmpty());

        tourelle.setPosition(40*16, 30*16);
        assertTrue(tourelle.getListePersosAPortee().isEmpty());
    }
}
