package td.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import td.modele.bfs.BFS;
import td.modele.bfs.Sommet;
import td.modele.personnage.Personnage;
import td.modele.tir.Tir;
import td.modele.tourelle.Tourelle;

import java.util.*;

public class Environnement {

	private Map map;
	public List<Tourelle> tours;
	//HSet, quand declare variable mettre des types superieurs (ex List plutot que arraylist ici :
	//ArrayList<String> list = new ArrayList<>()
	//List<String> list = new ArrayList<>()
	//Set<String> set =  new HashSet<>()
	// Liste besoin de l'ordre avc index, peut pas si veut sup mettre ref de l'objet : remove nicolas etc, mais i, et ca va bcp plus vite le hset
	// Hset dif tourelles par id etc

	List<Personnage> persos;
	public ObservableSet<Tir> tirs; // approfondir
	private BFS bfs;
	
	public Environnement() {
		this.tours = new ArrayList<Tourelle>();
		this.persos = new ArrayList<Personnage>();
		this.map= new Map("src/Sources/map.csv");
		this.bfs = new BFS(this.getMap());
		this.tirs = FXCollections.observableSet();
	}
	
	public void ajouterPers(Personnage p) {
		this.persos.add(p);
	}

	// Mettre dans partie
	public void unTour() {
		for(Personnage p : this.persos) {
			p.agit();
		}
		tirs.forEach(tir -> tir.agit());
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