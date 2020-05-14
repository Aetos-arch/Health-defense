package td.modele;

import java.util.ArrayList;

public class Environnement {

	private int [][] map;
	ArrayList<Tourelle> tours;
	ArrayList<Personnage> persos;
	
	public Environnement() {
		this.tours = new ArrayList<Tourelle>();
		this.persos = new ArrayList<Personnage>();
		this.map= Map.map1;
		this.ajouterPers(new InfecteSansSymp());
	}
	
	public void ajouterPers(Personnage p) {
		this.persos.add(p);
	}
	
	public void unTour() {
		for(Personnage p : this.persos) {
			p.agit();
		}
	}

	public int[][] getMap () {
		return this.map;
	}
	public ArrayList<Personnage> getPersos(){
		return this.persos;
	}
	
}
