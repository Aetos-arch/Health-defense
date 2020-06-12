package TD.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TD.Modele.Environnement;
import TD.Modele.Personnage.InfecteGrave;
import TD.Modele.Personnage.InfecteSansSymp;
import TD.Modele.Personnage.Personnage;

public class PersonnageTest {

	private Environnement env;
	@Before
	public void setUp() throws Exception{
		this.env = new Environnement();
		this.env.creerArbre();
	}
	
	@Test
	public void testProtection() {
		Personnage p1 = new InfecteSansSymp(0, 18, env);
		Personnage p2 = new InfecteGrave(1, 20, env);
		this.env.ajouterPers(p1);
		this.env.ajouterPers(p2);
		p2.seFaireSoigner(20);
		assertTrue(p1.estProtege().getValue()==1);
	}

}
