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
	
	public BFS(int [][] m) {
		this.map= m;
		this.file = new LinkedList<Sommet>();
		this.sommets = new ArrayList<Sommet>();
		this.adj = new ArrayList<Sommet>();
		this.aretes = new HashMap<Sommet, Sommet>();
		this.creerSommets();
	}
	
	public void creationChemin() {
		Sommet arr = trouverArr();
		arr.marque();
		file.add(arr);
		while(file.size()!=0) {
			Sommet s = this.file.poll();
			this.trouverAdj(s);
			for(Sommet t : this.adj) {
				t.marque();
				this.file.add(t);
				this.aretes.put(t, s);
			}
		}
	}
	
	private void resetListes() {
		this.file.clear();
		this.adj.clear();
		this.sommets.clear();
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
					this.sommets.add(new Sommet(j,i));
	}
	
	private void trouverAdj(Sommet s){
		this.adj.clear();
		for (Sommet a: this.sommets) {
			//Determine si le sommet a fait partie des sommets autour de s
			if((a.getX()== s.getX()-1 || a.getX()== s.getX()|| a.getX()== s.getX()+1)&&
				(a.getY()== s.getY()-1 || a.getY()== s.getY()|| a.getY()== s.getY()+1))
				//Enleve le cas ou les sommets sont identiques et si a est deja marqué
				if(a != s && a.estMarque() == false)
					//Enleve les sommets qui ne sont pas du sol
					if(this.map[a.getY()][a.getX()]< 94
							&&(this.map[a.getY()][a.getX()]< 80||this.map[a.getY()][a.getX()]> 87)
							&&(this.map[a.getY()][a.getX()]< 60||this.map[a.getY()][a.getX()]> 67)
							&&(this.map[a.getY()][a.getX()]< 40||this.map[a.getY()][a.getX()]> 49)
							&&(this.map[a.getY()][a.getX()]< 22||this.map[a.getY()][a.getX()]> 29)
							&&(this.map[a.getY()][a.getX()]< 2||this.map[a.getY()][a.getX()]> 13)) {
						this.adj.add(a);
					}
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
