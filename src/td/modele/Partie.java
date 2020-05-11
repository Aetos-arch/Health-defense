package td.modele;

public class Partie {

	private int score;
	private int niveau;
	private int money;
	private Environnement env;
	
	public Partie(Environnement e) {
		this.score= 0;
		this.niveau = 1;
		this.money = 0;
		this.env=e;
	}
	
	public void lancerPartie() {
		//TODO
	}
}
