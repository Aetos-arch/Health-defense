package Tower_Defense.Modele;

import Tower_Defense.Exception.PlacementException;
import Tower_Defense.Modele.Bfs.BFS;
import Tower_Defense.Modele.Bfs.Sommet;
import Tower_Defense.Modele.Personnage.Personnage;
import Tower_Defense.Modele.Tir.Tir;
import Tower_Defense.Modele.Tourelle.Tourelle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;


public class Environnement {

	private Map map;
	private ObservableList<Tourelle> tours;
	private ObservableList<Personnage> persos;
	private ObservableList<Tir> tirs;
	private BFS bfs;

	public Environnement() {
		this.tours = FXCollections.observableArrayList();
		this.persos = FXCollections.observableArrayList();
		this.map = new Map("src/Sources/map.csv");
		this.bfs = new BFS(this.getMap());
		this.tirs = FXCollections.observableArrayList();
	}
	
	public void ajouterPers(Personnage p) {
		this.persos.add(p);
	}
	
	public void ajouterTour(Tourelle tour) throws PlacementException {
		for(Tourelle t : this.tours)
			if(t.getX()==tour.getX() && t.getY() == tour.getY())
				throw new PlacementException();
		this.tours.add(tour);
	}

	public void unTour() {
		for (int i = this.persos.size() - 1; i >= 0; i--) {
			this.persos.get(i).agit();
			if (this.persos.get(i).estArrive())
				this.persos.remove(this.persos.get(i));
		}
		for (int i = this.tirs.size() - 1; i >= 0; i--)
			this.tirs.get(i).agit();

		for (Tourelle t : this.tours)
			t.agit();
	}

	public int[][] getMap() {
		return this.map.getMap();
	}

	public ObservableList<Personnage> getPersos() {
		return this.persos;
	}

	public ObservableList<Tourelle> getTours() {
		return this.tours;
	}

	public HashMap<Sommet, Sommet> getHashMap() {
		return this.bfs.getHashMap();
	}

	public ObservableList<Tir> getTirs() {
		return tirs;
	}

	public Sommet trouverSommet(int x, int y) {
		return this.bfs.trouverSommet(x, y);
	}

	public void creerArbre() {
		this.bfs.creationChemin();
	}

	public void modifChemin(int x, int y) throws PlacementException {
		this.bfs.supprimerSommet(x, y);
	}

	public void ajouterTir(Tir t) {
		this.tirs.add(t);
	}

	public void ajouterTourelle(Tourelle t) {
		this.tours.add(t);
	}
}