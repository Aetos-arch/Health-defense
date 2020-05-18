package td.modele;

import java.util.HashMap;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {
	
	int id;
	private IntegerProperty x;
	private IntegerProperty y;
	private int nivCont;
	private int vitesse;
	private int dirX;
	private int dirY;
	private Sommet som;
	private Environnement env;
	private HashMap<Sommet, Sommet> aretes;
	
	public Personnage(int vit, int nivContamination, int id, Sommet s, Environnement e) {
		this.x = new SimpleIntegerProperty();
		this.y = new SimpleIntegerProperty();
		this.som=s;
		this.x.set(this.som.getX());
		this.y.set(this.som.getY());
		this.nivCont = nivContamination;
		this.vitesse = vit;
		this.dirX = 0;
		this.dirY = 0;
		this.id = id;
		this.env = e;
		this.aretes = this.env.getHashMap();
	}
	
	public void agit() {
		if(x.getValue() == this.som.getX() && y.getValue() == this.som.getY()) {
			this.som = this.aretes.get(som);
			this.calculerDir();
		}
		this.x.set(this.x.getValue() + this.dirX);
		this.y.set(this.x.getValue() + this.dirY);
	}
	
	private void calculerDir() {
		
		int cal = this.x.getValue() - this.som.getX();
		if(cal < 0)
			this.dirX = this.vitesse;
		else if (cal == 0)
			this.dirX = 0;
		else
			this.dirX = - this.vitesse;
		
		cal = this.y.getValue() - this.som.getY();
		if(cal < 0)
			this.dirY = this.vitesse;
		else if (cal == 0)
			this.dirY = 0;
		else
			this.dirY = - this.vitesse;
		
	}

	public void seFaireSoigner(int d) {
		this.nivCont -= d;
	}
	
	public boolean estSain() {
		return this.nivCont<= 0;
	}

	public IntegerProperty getXProperty() {
		return x;
	}

	public IntegerProperty getYProperty() {
		return y;
	}
	
	public int getX() {
		return x.getValue();
	}
	
	public int getY() {
		return y.getValue();
	}
	public int getId() {
		return this.id;
	}
}
