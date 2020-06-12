package Tower_Defense.Modele;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Score {
	
	private String nomFichier;
	private int numScore;
	private PrintWriter writer;
	
	public Score() {
		this.nomFichier = "src/Sources/Score.txt";
		this.numScore = 0;
		try {
			writer = new PrintWriter(nomFichier);
		} catch (FileNotFoundException e) {
			System.out.println("Le fichier n'a pas été trouvé.");
		}
	}
	
	public void ajouterScore(int i) {
		writer.println("Score nº" + this.numScore + " : ALLLLLLLOOOOO? " + i) ;
		writer.append("\n");
		writer.close();
		numScore++;
	}
}
