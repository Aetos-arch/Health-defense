package Tower_Defense.Modele;

import java.io.FileWriter;
import java.io.IOException;


public class Score {
	
	private String nomFichier;
	private FileWriter writer;
	
	public Score() {
		this.nomFichier = "src/Sources/Score.txt";
	}
	
	public void ajouterScore(int i, String nom) {
		System.out.println("On ajoute un score");
		try {
			writer = new FileWriter(nomFichier, true);
			writer.write("Score " +nom+ " : " + i +"\n") ;
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
