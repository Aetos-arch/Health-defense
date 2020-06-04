package TD.Modele.Personnage;

import TD.Modele.Bfs.Sommet;
import TD.Modele.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.HashMap;

public abstract class Personnage {
	
	private IntegerProperty x;
	private IntegerProperty y;
	private int nivCont;
	private int vitesse;
	private int dirX;
	private int dirY;
	private Sommet som;
	private Environnement env;
	private HashMap<Sommet, Sommet> aretes;
	private boolean arrive;
	
	public Personnage(int vit, int nivContamination, int xS, int yS, Environnement e) {
		this.x = new SimpleIntegerProperty();
		this.y = new SimpleIntegerProperty();
		this.x.set(xS*16);
		this.y.set(yS*16);
		this.nivCont = nivContamination;
		this.vitesse = vit;
		this.env = e;
		this.aretes = this.env.getHashMap();
		this.initSom(xS, yS);
		this.calculerDir();
		this.arrive = false;
	}
	
	protected void initSom(int x, int y) {
		this.som = this.env.trouverSommet(x, y);
	}

	public void agit() {
		this.aretes = this.env.getHashMap();
		if(!arrive) {
		if(x.getValue() == this.som.getX()*16 && y.getValue() == this.som.getY()*16) {
			this.som = this.aretes.get(som);
			if(this.som == null) {
				this.arrive = true;
			}
			else{
				this.calculerDir();	
			}
		}
		this.x.set(this.x.getValue() + this.dirX);
		this.y.set(this.y.getValue() + this.dirY);
		}
		
	}
	
	private void calculerDir() {
		int cal = this.x.getValue() - this.som.getX()*16;
		if(cal < 0)
			this.dirX = this.vitesse;
		else if (cal == 0)
			this.dirX = 0;
		else
			this.dirX = -this.vitesse;
		
		cal = this.y.getValue() - this.som.getY()*16;
		if(cal < 0)
			this.dirY = this.vitesse;
		else if (cal == 0)
			this.dirY = 0;
		else
			this.dirY = -this.vitesse;
	}

	public void seFaireSoigner(int d) {
		this.nivCont -= d;
	}
	protected void setVit(int v) {
		this.vitesse = v;
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

    public boolean estArrive() {
        return this.arrive;
    }
}
