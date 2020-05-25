package td.modele;

public class Partie {

	private static int avancement = 0;

	private int score;
	private int niveau;
	private int money;
	private Environnement env;
	private int pv;

	public Partie() {
		this.score = 0;
		this.niveau = 1;
		this.money = 0;
		this.env = new Environnement();
		this.pv = 30;
	}

	public void lancerNiveau() {
		avancement = 0;
		niveau++;
	}

	public void unTour() {
		if (avancement < nombreEnnemi()) {
			//this.env.ajouterPers(new InfecteSansSymp());

			avancement++;
//			System.out.println("vague : " + this.niveau + " " + this.env.getPersos().get(avancement));
		}
		this.env.unTour();
	}

	public boolean estPerdu() {
		return this.pv <= 0;
	}
	
	public int nombreEnnemi() {
		return this.niveau*2;
	}

	public void perdrePV(int n) {
		this.pv -= n;
	}
	
	public int getScore() {
		return this.score;
	}

	public Environnement getEnv() {
		return this.env;
	}

	public boolean niveauFini() {
		return this.env.getPersos().isEmpty();
	}
}
