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
	
	public void nonMarque() {
		this.marque = false;
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
		return this.x + "&" + this.y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sommet other = (Sommet) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
