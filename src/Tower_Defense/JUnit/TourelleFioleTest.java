package Tower_Defense.JUnit;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Personnage.InfecteSansSymp;
import Tower_Defense.Modele.Personnage.Personnage;
import Tower_Defense.Modele.Tourelle.TourelleVitamine;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;

public class TourelleFioleTest {

        TourelleVitamine tourelle;
        Environnement env;
        Personnage personnage;
        ArrayList<Personnage> listePersos;
        @Before
        public void setUp() throws Exception {
            env = new Environnement();

            this.tourelle = new TourelleVitamine(10*16, 10*16, env);
            this.personnage = new InfecteSansSymp(10, 10, env);
            this.env.ajouterPers(this.personnage);
            this.env.ajouterTour(tourelle);

            Personnage persoFiltrer1 = new InfecteSansSymp(10, 10, this.env);
            Personnage persoFiltrer2 = new InfecteSansSymp(10, 10, this.env);
            Personnage persoFiltrer3 = new InfecteSansSymp(10, 10, this.env);
            Personnage persoFiltrer4 = new InfecteSansSymp(10, 10, this.env);
            Personnage persoFiltrer5 = new InfecteSansSymp(10, 10, this.env);
            Personnage persoGarder = new InfecteSansSymp(10, 10, this.env);

            this.env.ajouterPers(persoFiltrer1);
            this.env.ajouterPers(persoFiltrer2);
            this.env.ajouterPers(persoFiltrer3);
            this.env.ajouterPers(persoFiltrer4);
            this.env.ajouterPers(persoFiltrer5);
            this.env.ajouterPers(persoGarder);

            ArrayList<Personnage> listePersos = new ArrayList<>();
            listePersos.add(persoFiltrer1);
            listePersos.add(persoFiltrer2);
            listePersos.add(persoFiltrer3);
            listePersos.add(persoFiltrer4);
            listePersos.add(persoFiltrer5);
            listePersos.add(persoGarder);
        }

        @After
        public void clear () {
            this.env.getPersos().clear();
            this.env.getTirs().clear();
            this.env.getTours().clear();
        }

        
}
