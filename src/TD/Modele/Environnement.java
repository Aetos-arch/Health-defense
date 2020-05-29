package TD.Modele;

import TD.Modele.Bfs.BFS;
import TD.Modele.Bfs.Sommet;
import TD.Modele.Personnage.Personnage;
import TD.Modele.Tir.Tir;
import TD.Modele.Tourelle.Tourelle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Environnement {

	private Map map;
	public List<Tourelle> tours;
	//HSet, quand declare variable mettre des types superieurs (ex List plutot que arraylist ici :
	//ArrayList<String> list = new ArrayList<>()
	//List<String> list = new ArrayList<>()
	//Set<String> set =  new HashSet<>()
	// Liste besoin de l'ordre avc index, peut pas si veut sup mettre ref de l'objet : remove nicolas etc, mais i, et ca va bcp plus vite le hset
	// Hset dif tourelles par id etc

	private List<Personnage> persos;
	public ObservableSet<Tir> tirs; // approfondir mettre en pv
	private BFS bfs;

	public Environnement() {
		this.tours = new ArrayList<>();
		this.persos = new ArrayList<>();
		this.map = new Map("src/Sources/map.csv");
		this.bfs = new BFS(this.getMap());
		this.tirs = FXCollections.observableSet();
	}
	
	public void ajouterPers(Personnage p) {
		this.persos.add(p);
	}
	
	public void ajouterTour(Tourelle tour) {
		this.tours.add(tour);
	}

	// Mettre dans partie
	public void unTour() {
		for (Personnage p : this.persos) {
			p.agit();
		}
		tirs.forEach(tir -> tir.agit());
		tours.forEach(tourelle -> tourelle.agit());
	}

	public int[][] getMap () {
		return this.map.getMap();
	}
	public List<Personnage> getPersos(){
		return this.persos;
	}

	public List<Tourelle> getTours(){
		return this.tours;
	}

	public HashMap<Sommet, Sommet> getHashMap(){
		return this.bfs.getHashMap();
	}

	public ObservableSet<Tir> getTirs() {
		return tirs;
	}

	public void setTirs(ObservableSet<Tir> tirs) {
		this.tirs = tirs;
  }
  
	public Sommet trouverSommet(int x, int y){
		return this.bfs.trouverSommet(x,y);
	}
	
	public void creerArbre() {
		this.bfs.creationChemin();
	}
}