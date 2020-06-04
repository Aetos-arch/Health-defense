package TD.Modele;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map {

	private int[][] map;

	public Map(String url) {
		map = new int[30][50];
		try { // pour gérer les erreurs
			String ligne;
			int numLigne = 0;
			BufferedReader csvReader = new BufferedReader(new FileReader(url)); // pour lire un fichier
			while ((ligne = csvReader.readLine()) != null) { // donner ligne préparer dans tableau de String
				String[] data = ligne.split(","); // pour lui dire le caractère de séparation
				for (int j = 0; j < 50; j++) {
					map[numLigne][j] = Integer.parseInt(data[j]);
				}
				numLigne++;
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("le fichier n'existe pas !"); // add e.error
		}
	}

	public int[][] getMap() {
		return this.map;
	}

	public void affMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
}