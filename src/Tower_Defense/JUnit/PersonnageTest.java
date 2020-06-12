package Tower_Defense.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Tower_Defense.Modele.Environnement;
import Tower_Defense.Modele.Personnage.InfecteSansSymp;
import Tower_Defense.Modele.Personnage.Personnage;

public class PersonnageTest {
	
	private Environnement env;
	private Personnage p1;
	
	@Before
	public void setUp() throws Exception{
		this.env = new Environnement();
		p1 = new InfecteSansSymp(0, 18, this.env);
	}

	@Test
	public void testHeal() {
		this.p1.seFaireSoigner(40);
		assertFalse(this.p1.estSain());
		this.p1.seFaireSoigner(60);
		assertTrue(this.p1.estSain());
	}
	
	@Test
	public void testHealOnTime() {
		this.p1.prendreUnHoT(100);
		assertTrue(this.p1.getHotProprety().getValue() == 100/2 );
		for (int i = 0; i<50;i++)
			this.p1.agit();
		assertTrue(this.p1.estSain());
	}
	
	@Test
	public void testRalentissement() {
		int vit1 = this.p1.getVit();
		this.p1.ralentir();
		int vit2 = this.p1.getVit();
		assertTrue(vit1>vit2);
		
		this.p1.ralentir();
		int vit3 = this.p1.getVit();
		assertTrue(vit2 == vit3);//On ne veut pas pouvoir le ralentir le personnage plusieurs fois d'affilés
		
		this.p1.nonRalenti();;
		int vit4 = this.p1.getVit();
		assertTrue(vit3<vit4);
		
		this.p1.nonRalenti();;
		int vit5 = this.p1.getVit();
		assertTrue(vit5 == vit4);//Pareil que pour le ralentissement
		
		assertTrue(vit1 == vit5);
	}
	
}
