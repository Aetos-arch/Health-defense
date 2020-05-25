package td.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Partie {

	private static int avancement = 0;

	private IntegerProperty scoreProperty;
	private IntegerProperty vagueProperty;
	private IntegerProperty moneyProperty;
	private Environnement env;
	private IntegerProperty pvProperty;

	public Partie() {
		this.scoreProperty = new SimpleIntegerProperty(0);
		this.vagueProperty = new SimpleIntegerProperty(1);
		this.moneyProperty = new SimpleIntegerProperty(0);
		this.env = new Environnement();
		this.pvProperty = new SimpleIntegerProperty(30);
	}

	public void lancerNiveau() {
		avancement = 0;
		this.setVague(this.getVague()+1);;
	}

	public void unTour() {
		if (avancement < nombreEnnemi()) {
			//this.env.ajouterPers(new InfecteSansSymp());
			avancement++;
//			System.out.println("vague : " + this.niveau + " " + this.env.getPersos().get(avancement));
		}
		this.env.unTour();
		this.setVague(this.getVague()+1);
	}

	public boolean estPerdu() {
		return this.getPV() <= 0;
	}
	
	public int nombreEnnemi() {
		return this.getVague()*2;
	}

	public void perdrePV(int n) {
		this.setPV(this.getPV()-n);
	}
	
	public void augmenterScore(int n) {
		this.setScore(this.getScore()+n);
	}
	
	public IntegerProperty moneyProperty() {
		return this.moneyProperty;
	}
	
	public int getMoney() {
		return this.moneyProperty.getValue();
	}
	
	public void setMoney(int n) {
		this.moneyProperty.set(n);
	}
	
	public IntegerProperty pvProperty() {
		return this.pvProperty;
	}
	
	public int getPV() {
		return this.pvProperty.getValue();
	}
	
	public void setPV(int n) {
		this.pvProperty.set(n);
	}
	
	public IntegerProperty vagueProperty() {
		return this.vagueProperty;
	}
	
	public int getVague() {
		return this.vagueProperty.getValue();
	}
	
	public void setVague(int n) {
		this.vagueProperty.set(n);
	}
	
	public IntegerProperty scoreProperty() {
		return this.scoreProperty;
	}
	
	public int getScore() {
		return this.scoreProperty.getValue();
	}
	
	public void setScore(int n) {
		this.scoreProperty.set(n);
	}

	public Environnement getEnv() {
		return this.env;
	}

	public boolean niveauFini() {
		return false; //this.env.getPersos().isEmpty();
	}
}
