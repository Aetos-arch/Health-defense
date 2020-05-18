package td.modele;

import java.util.ArrayList;

public class Environnement {

	private Map map;
	ArrayList<Tourelle> tours;
	ArrayList<Personnage> persos;
	
	public Environnement() {
		this.tours = new ArrayList<Tourelle>();
		this.persos = new ArrayList<Personnage>();
		this.map= new Map("src/Sources/map.csv");;
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
		return this.map.getMap();
	}
	public ArrayList<Personnage> getPersos(){
		return this.persos;
	}
	
}