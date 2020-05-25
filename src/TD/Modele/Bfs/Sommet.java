package TD.Modele.Bfs;

public class Sommet {

	private int x;
	private int y;
	private boolean marque;
	
	public Sommet(int x, int y) {
		this.x = x;
		this.y = y;
		this.marque = false;
	}
	
	public void marque() {
		this.marque = true;
	}
	
	public boolean estMarque() {
		return this.marque;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String toString() {
		return this.x + ", " + this.y;
	}
	
}
