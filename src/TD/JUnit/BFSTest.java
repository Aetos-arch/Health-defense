package TD.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TD.Exception.PlacementException;
import TD.Modele.Map;
import TD.Modele.Bfs.BFS;
import TD.Modele.Bfs.Sommet;

public class BFSTest {

	private BFS bfs;
	private Map map;

	
	@Before
	public void setUp() throws Exception {
		this.map = new Map("src/Sources/map.csv");
		this.bfs = new BFS(this.map.getMap());
	}
	
	@Test
	public void testCreationSommets() {
		assertNotNull(this.bfs.getSommets());
	}
	
	@Test
	public void testCreationChemin() {
		this.bfs.creationChemin();
		assertNotNull(this.bfs.getHashMap());
	}
	
	@Test
	public void testArrive() {
		//Pour la méthode trouverArr()
		assertEquals(new Sommet(43,4), this.bfs.trouverArr());
		// J'en profite pour tester trouverSommet()
		assertEquals(new Sommet(43,4), this.bfs.trouverSommet(43, 4));
	}

	@Test
	public void testSupprimerSommet() throws PlacementException {
		int nbAreteAvant = this.bfs.getSommets().size();
		this.bfs.supprimerSommet(25, 10);
		assertTrue(nbAreteAvant > this.bfs.getSommets().size());
	}
	
	@Test(expected = PlacementException.class)
	public void testSupprimerSommetException() throws PlacementException{
		this.bfs.supprimerSommet(0, 0);
	}
}
