package Tower_Defense.Modele;

import Tower_Defense.Exception.MoneyException;
import Tower_Defense.Exception.PlacementException;
import Tower_Defense.Modele.Personnage.InfecteGrave;
import Tower_Defense.Modele.Personnage.InfecteJogger;
import Tower_Defense.Modele.Personnage.InfecteQuiTousse;
import Tower_Defense.Modele.Personnage.InfecteSansSymp;
import Tower_Defense.Modele.Tourelle.Tourelle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Partie {

	private static int avancement = 0;
	private static int delai = 0;

	private IntegerProperty scoreProperty;
	private IntegerProperty vagueProperty;
	private IntegerProperty moneyProperty;
	private Environnement env;
	private IntegerProperty pvProperty;
	private Score score;
	private String nomJoueur;

	public Partie() {
		this.scoreProperty = new SimpleIntegerProperty(0);
		this.vagueProperty = new SimpleIntegerProperty(0);
		this.moneyProperty = new SimpleIntegerProperty(4000);
		this.env = new Environnement();
		this.pvProperty = new SimpleIntegerProperty(30);
		this.env.creerArbre();
		this.score = new Score();
	}

	public void nouvellePartie() {
		this.env.nouvPartie();
		this.scoreProperty.setValue(0);
		this.vagueProperty.setValue(0);
		this.pvProperty.setValue(30);
		this.moneyProperty.setValue(4000);
	}
	
	public void lancerNiveau() {
		delai = 0;
		avancement = 0;
		this.vagueProperty.set(this.getVague() + 1);
		if(this.vagueProperty.getValue()%5==0)
			this.env.amelioPers(2);
		if(this.vagueProperty.getValue()%15==0) {
			this.env.amelioPers(6);
		}
	}

	public void unTour() {
		if (delai % 17 == 0)
			if (avancement < nombreEnnemi()) {
				double spawnAleatoire = Math.random() * 4;
				if (spawnAleatoire < 1) {
					int random = (int) (Math.random() * 11) + 11;
					this.env.ajouterPers(new InfecteSansSymp(0, random, this.env));
				} else if (spawnAleatoire < 2) {
					int random = (int) (Math.random() * 11) + 11;
					this.env.ajouterPers(new InfecteJogger(0, random, this.env));
				} else if (spawnAleatoire < 3){
					int random = (int) (Math.random() * 11) + 11;
					this.env.ajouterPers(new InfecteGrave(0, random, this.env));
				} else {
					int random = (int) (Math.random() * 11) + 11;
					this.env.ajouterPers(new InfecteQuiTousse(0, random, this.env));
				}
				avancement++;
			}
		delai++;
		this.env.unTour();
	}

	public void ajouterTour(Tourelle t) throws MoneyException, PlacementException {
		if (t.getPrix() <= this.moneyProperty.getValue()) {
			this.env.modifChemin((int) (t.getX() / 16), (int) (t.getY() / 16));
			this.env.ajouterTour(t);
			this.moneyProperty.setValue(this.moneyProperty.getValue() - t.getPrix());
		} else {
			throw new MoneyException();
		}
	}

	public boolean estPerdu() {
		return this.getPV() <= 0;
	}

	public int nombreEnnemi() {
		return this.getVague() * 4;
	}

	public void perdrePV(int n) {
		this.pvProperty.setValue(this.getPV() - n);
	}

	public void augmenterScore(int n) {
		this.scoreProperty.set(this.scoreProperty.getValue() + n);
	}

	public void augmenterMoney(int n) {
		this.moneyProperty.setValue(this.getMoney() + n);
	}

	public IntegerProperty moneyProperty() {
		return this.moneyProperty;
	}

	public int getMoney() {
		return this.moneyProperty.getValue();
	}
	
	public IntegerProperty pvProperty() {
		return this.pvProperty;
	}

	public int getPV() {
		return this.pvProperty.getValue();
	}

	public IntegerProperty vagueProperty() {
		return this.vagueProperty;
	}

	public int getVague() {
		return this.vagueProperty.getValue();
	}

	public IntegerProperty scoreProperty() {
		return this.scoreProperty;
	}

	public Environnement getEnv() {
		return this.env;
	}

	public boolean niveauFini() {
		return this.env.getPersos().isEmpty() && this.env.getTirs().isEmpty() && avancement >= this.nombreEnnemi();
	}
	
	public void ajouterScore() {
		this.score.ajouterScore(this.scoreProperty.getValue(), this.nomJoueur);
	}
	
	public void setNomJoueur(String s) {
		this.nomJoueur = s;
	}
}
