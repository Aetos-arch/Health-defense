package td.modele;

public class Partie {

	private int score;
	private int niveau;
	private int money;
	private Environnement env;
	private int pv;
	
	public Partie(Environnement e) {
		this.score= 0;
		this.niveau = 1;
		this.money = 0;
		this.env=e;
		this.pv = 30;
	}
	
	public void lancerPartie() {
		//TODO
	}
	
	public void unTour() {
		this.env.unTour();
	}
	
	public boolean estPerdu() {
		return this.pv <=0;
	}
	
	public boolean niveauFini() {
		//TODO
		return false;
	}
}
