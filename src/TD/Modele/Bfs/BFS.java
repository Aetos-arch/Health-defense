package TD.Modele.Bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BFS {

	private int [][] map;
	private LinkedList<Sommet> file;
	private ArrayList<Sommet> sommets;
	private ArrayList<Sommet> adj;
	private HashMap<Sommet, Sommet> aretes;
	private ArrayList<Integer> sommetsACreer;
	private static int[] tuilesSol = {0,1,14,15,16,17,18,19
			,20,21,30,31,32,33,34,35,36,37,38,39
			,50,51,52,53,54,55,56,57,58,59
			,68,69,70,71,72,73,74,75,76,77,78,79
			,88,89,90,91,92,93,202};
	
	public BFS(int [][] m) {
		this.map= m;
		this.file = new LinkedList<Sommet>();
		this.sommets = new ArrayList<Sommet>();
		this.adj = new ArrayList<Sommet>();
		this.aretes = new HashMap<Sommet, Sommet>();
		this.sommetsACreer = new ArrayList<Integer>();
		for (int i : this.tuilesSol)
			this.sommetsACreer.add(i);
		this.creerSommets();
		
	}
	
	public void creationChemin() {
		Sommet arr = trouverArr();
		arr.marque();
		file.addLast(arr);
		while(file.size()!=0) {
			Sommet s = this.file.removeFirst();
			this.trouverAdjHV(s);
			for(Sommet t : this.adj) {
				t.marque();
				this.file.addLast(t);
				this.aretes.put(t, s);
			}
			this.trouverAdjD(s);
			for(Sommet t : this.adj) {
				t.marque();
				this.file.addLast(t);
				this.aretes.put(t, s);
			}
		}
	}
	private void resetListes() {
		this.file.clear();
		this.adj.clear();
		this.aretes.clear();
	}

	private Sommet trouverArr() {
		for (Sommet s : this.sommets)
			if (map[s.getY()][s.getX()] == 202)
				return s;
		return null;
	}
	
	private void creerSommets() {
		for(int i = 0; i < map.length; i++)
			for(int j = 0; j< map[i].length; j++)
				//Enleve les sommets qui ne sont pas du sol
				if(this.sommetsACreer.contains(this.map[i][j]))
					this.sommets.add(new Sommet(j,i));
	}
	
	public void supprimerSommet(int x, int y) {
		this.sommets.remove(this.trouverSommet(x, y));
		this.sommets.remove(this.trouverSommet(x, y+1));
		this.resetListes();
		this.creationChemin();
	}
	
	private void trouverAdjHV(Sommet s){
		this.adj.clear();
		for (Sommet a: this.sommets) {
			//Determine si le sommet a fait partie des sommets autour de s en vertical ou horizontal
			if((a.getX()== s.getX()&& a.getY()== s.getY()-1) ||
					(a.getX()== s.getX()&& a.getY()== s.getY()+1)||
					(a.getX()== s.getX()-1&& a.getY()== s.getY())||
					(a.getX()== s.getX()+1 && a.getY()== s.getY()))
				//Enleve le cas ou les sommets sont identiques et si a est deja marqué
				if(!a.equals(s) && !a.estMarque())
						this.adj.add(a);
		}
	}
	private void trouverAdjD(Sommet s) {
		this.adj.clear();
		for (Sommet a: this.sommets) {
			if((a.getX()== s.getX()-1 && a.getY()== s.getY()-1) ||
					(a.getX()== s.getX()+1&& a.getY()== s.getY()+1)||
					(a.getX()== s.getX()-1&& a.getY()== s.getY()+1)||
					(a.getX()== s.getX()+1 && a.getY()== s.getY()-1))
				//Enleve le cas ou les sommets sont identiques et si a est deja marqué
				if(!a.equals(s) && !a.estMarque())
						this.adj.add(a);
		}
		
	}
	
	public HashMap<Sommet, Sommet> getHashMap(){
		return this.aretes;
	}
	
	public ArrayList<Sommet> getSommets(){
		return this.sommets;
	}
	
	public Sommet trouverSommet(int x, int y) {
		for(Sommet s : this.sommets) {
			if(s.getX()==x && s.getY()==y)
				return s;
		}
		return null;
	}
}
