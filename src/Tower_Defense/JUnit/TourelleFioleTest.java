package Tower_Defense.JUnit;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Personnage.InfecteGrave;
import Tower_Defense.Modele.Personnage.InfecteSansSymp;
import Tower_Defense.Modele.Personnage.Personnage;
import Tower_Defense.Modele.Tourelle.TourelleFiole;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.assertSame;

public class TourelleFioleTest {

    TourelleFiole tourelle;
    Environnement env;
    ArrayList<Personnage> listeDesPersos;

    @Before
    public void setUp() throws Exception {
        this.env = new Environnement();
        this.tourelle = new TourelleFiole(10*16, 10*16, env);
        this.env.ajouterTour(tourelle);

        Personnage perso1 = new InfecteSansSymp(10, 10, this.env);
        Personnage perso2 = new InfecteSansSymp(11, 10, this.env);
        Personnage perso3 = new InfecteSansSymp(20, 10, this.env);
        Personnage persoGarder = new InfecteGrave(26, 10, this.env);

        this.env.ajouterPers(perso1);
        this.env.ajouterPers(perso2);
        this.env.ajouterPers(perso3);
        this.env.ajouterPers(persoGarder);

        listeDesPersos = new ArrayList<>();
        listeDesPersos.add(perso1);
        listeDesPersos.add(perso2);
        listeDesPersos.add(perso3);
        listeDesPersos.add(persoGarder);
    }

    @After
    public void clear () {
        this.env.getPersos().clear();
        this.env.getTirs().clear();
        this.env.getTours().clear();
    }

    @org.junit.Test
    public void testPersoLePlusEntoure() {
        assertSame(this.listeDesPersos.get(0), this.tourelle.getPersoLePlusEntoure(this.listeDesPersos));
    }
}
