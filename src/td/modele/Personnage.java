package td.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Personnage {
	
	int id;
	private IntegerProperty x;
	private IntegerProperty y;
	private int nivCont;
	private int vitesse;
	private int dirX;
	private int dirY;
	
	public Personnage() {
		this.x = new SimpleIntegerProperty();
		this.y = new SimpleIntegerProperty();
		int random = (int)(Math.random()*20);
		this.x.set(random);
		random = (int)(Math.random()*20);
		this.y.set(random);
		this.nivCont = 10;
		this.vitesse = 1;
		this.dirX = 0;
		this.dirY = 0;
		this.id = 30;
	}
	
	public void agit() {
		int random = (int)(Math.random()*4);
		switch (random) {
		case 0:
			dirX=0;
			dirY=0;
			break;
		case 1:
			dirX=1;
			dirY=0;
			break;
		case 2:
			dirX=-1;
			dirY=0;
			break;
		case 3:
			dirX=0;
			dirY=1;
			break;
		case 4:
			dirX=0;
			dirY=-1;
		}
		
		this.x.set(this.x.getValue() + this.dirX);
		this.y.set(this.y.getValue() + this.dirY);
		
		if(this.x.getValue()<0 || this.x.getValue() >20)
			this.x.set(this.x.getValue() - this.dirX*2);
		if(this.y.getValue()<0 || this.y.getValue() >20)
			this.y.set(this.y.getValue() - this.dirY*2);
	}

	public IntegerProperty getX() {
		return x;
	}

	public IntegerProperty getY() {
		return y;
	}
	public int getId() {
		return this.id;
	}
}
