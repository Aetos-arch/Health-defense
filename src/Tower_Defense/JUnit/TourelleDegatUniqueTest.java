package Tower_Defense.JUnit;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Personnage.InfecteGrave;
import Tower_Defense.Modele.Personnage.InfecteSansSymp;
import Tower_Defense.Modele.Personnage.Personnage;
import Tower_Defense.Modele.Tourelle.TourelleVitamine;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TourelleDegatUniqueTest {

    TourelleVitamine tourelle;
    Environnement env;
    ArrayList<Personnage> listeDesPersos;

    @Before
    public void setUp() throws Exception {
        this.env = new Environnement();
        this.tourelle = new TourelleVitamine(10*16, 10*16, env);
        this.env.ajouterTour(tourelle);

        Personnage persoFiltrer1 = new InfecteSansSymp(10, 10, this.env);
        Personnage persoFiltrer2 = new InfecteSansSymp(14, 10, this.env);
        Personnage persoFiltrer3 = new InfecteSansSymp(18, 10, this.env);
        Personnage persoFiltrer4 = new InfecteSansSymp(22, 10, this.env);
        Personnage persoFiltrer5 = new InfecteSansSymp(24, 10, this.env);
        Personnage persoGarder = new InfecteGrave(26, 10, this.env);

        this.env.ajouterPers(persoFiltrer1);
        this.env.ajouterPers(persoFiltrer2);
        this.env.ajouterPers(persoFiltrer3);
        this.env.ajouterPers(persoFiltrer4);
        this.env.ajouterPers(persoFiltrer5);
        this.env.ajouterPers(persoGarder);

        listeDesPersos = new ArrayList<>();
        listeDesPersos.add(persoFiltrer1);
        listeDesPersos.add(persoFiltrer2);
        listeDesPersos.add(persoFiltrer3);
        listeDesPersos.add(persoFiltrer4);
        listeDesPersos.add(persoFiltrer5);
        listeDesPersos.add(persoGarder);
    }

    @After
    public void clear () {
        this.env.getPersos().clear();
        this.env.getTirs().clear();
        this.env.getTours().clear();
    }

    @org.junit.Test
    public void testCreationTir() {
        this.tourelle.agit();
        assertNotNull(this.env.getTirs());
    }

    @org.junit.Test
    public void testAPortee() {
        assertFalse(tourelle.getListePersosAPortee().isEmpty());

        tourelle.setPosition(12*16, 12*16);
        assertFalse(tourelle.getListePersosAPortee().isEmpty());

        tourelle.setPosition(40*16, 30*16);
        assertTrue(tourelle.getListePersosAPortee().isEmpty());
    }

    @org.junit.Test
    public void testFiltrerInfecteGrave() {
        assertEquals(this.tourelle.filtrerInfectesGrave(listeDesPersos).size(), 1);
    }

    @org.junit.Test
    public void testPersoLePlusProche() {
        // Le perso à l'indice 0 est à la même position que la tourelle
        assertSame(true, this.tourelle.getPersoLePlusProche(listeDesPersos) == listeDesPersos.get(0));
        assertSame(false,this.tourelle.getPersoLePlusProche(listeDesPersos) == listeDesPersos.get(1));

        this.tourelle.setPosition(30*16, 12*16);
        assertSame(true, this.tourelle.getPersoLePlusProche(listeDesPersos) == listeDesPersos.get(5));

        this.tourelle.setPosition(8*16, 8*16);
        assertSame(true,this.tourelle.getPersoLePlusProche(listeDesPersos) == listeDesPersos.get(0));

        this.tourelle.setPosition(19*16, 10*16);
        assertSame(true,this.tourelle.getPersoLePlusProche(listeDesPersos) == listeDesPersos.get(2));
    }

    @org.junit.Test
    public void testFocusInfecteGrave() {
        // focus indice 5 pour infecté grave, alors que l'indice 4 est à la même position que la tourelle
        this.tourelle.setPosition(24*16, 10*16);
        assertSame(listeDesPersos.get(5), this.tourelle.viser());
    }
}