package Tower_Defense.Modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Score {
	
	private String nomFichier;
	private FileWriter writer;
	
	public Score() {
		this.nomFichier = "src/Resources/Score.txt";
	}
	
	public void ajouterScore(int i, String nom) {
		System.out.println("On ajoute un score");
		try {
			writer = new FileWriter(nomFichier, true);
			writer.write("Score " +nom+ " : " + i + "\n") ;
			writer.close();
		} catch (IOException e) {
			System.out.println("Problème dans l'écriture du fichier!");
		}
	}
	
	public String affScores(){
		try {
			String ligne;
			String ensembleDesScores = "";
			BufferedReader csvReader = new BufferedReader(new FileReader(this.nomFichier)); // pour lire un fichier
			while ((ligne = csvReader.readLine()) != null) {
				String[] data = ligne.split("\n");
				for(int i = 0; i< data.length; i++)
					ensembleDesScores += data[i];
				ensembleDesScores += "\n";
			}
			return ensembleDesScores;
		}catch (Exception e) {
			System.out.println("Problème dans la lecture du fichier!");
		}
		return null;
	}
}
