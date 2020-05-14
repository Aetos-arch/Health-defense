package td.modele;

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
	
	public Personnage(int vit, int nivContamination, int id) {
		this.x = new SimpleIntegerProperty();
		this.y = new SimpleIntegerProperty();
		this.x.set(0);
		this.y.set(0);
		this.nivCont = nivContamination;
		this.vitesse = vit;
		this.dirX = 0;
		this.dirY = 0;
		this.id = id;
	}
	
	public void agit() {
		//TODO
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
