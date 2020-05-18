package td.modele;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
	
	private int[][] map;
	public static int[][] map1= {{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4},
			{7, 8, 9, 8, 9, 8, 9, 8, 9, 8, 9, 8, 9, 8, 8, 8, 9, 8, 9, 16},
			{7, 14, 15, 14, 15, 14, 15, 14, 15, 14, 15, 14, 15, 14, 14, 14, 15, 14, 15, 16},
			{7, 8, 9, 9, 8, 9, 8, 9, 8, 8, 9, 8, 9, 8, 9, 8, 9, 8, 9, 16}, 
			{7, 14, 15, 15, 14, 8, 9, 15, 14, 14, 15, 14, 15, 14, 15, 14, 15, 14, 15, 16},
			{7, 8, 9, 8, 8, 8, 9, 9, 9, 8, 9, 9, 8, 8, 9, 8, 8, 8, 9, 16},
			{7, 14, 15, 14, 14, 14, 15, 8, 9, 14, 15, 15, 14, 14, 15, 14, 14, 14, 15, 16},
			{7, 8, 9, 8, 8, 9, 8, 9, 15, 14, 14, -1, 8, 8, 9, 8, 9, 8, 9, 16}, 
			{7, 14, 15, 9, 14, 8, 9, 9, 9, 14, 8, 9, 14, 8, 9, 14, 15, 14, 15, 16},
			{7, 8, 9, 15, 9, 14, 15, 9, 8, 8, 8, 9, 8, 8, 9, 8, 8, 8, 9, 16},
			{7, 8, 9, 9, 15, 9, 14, 8, 14, 14, 14, 15, 14, 14, 15, 9, 14, 14, 15, 16},
			{7, 14, 15, 8, 8, 9, 8, 14, 8, 9, 9, 9, 15, 14, 15, 8, 8, 8, 9, 16},
			{7, 8, 9, 14, 14, 15, 14, 8, 9, 15, 15, 15, 8, 9, 9, 14, 14, 8, 9, 16},
			{7, 14, 8, 8, 9, 8, 9, 8, 9, 14, 15, 8, 14, 15, 8, 9, 8, 8, 9, 16},
			{7, 8, 14, 8, 9, 14, 15, 14, 15, 8, 9, 14, 8, 9, 8, 9, 14, 8, 9, 16}, 
			{7, 14, 8, 9, 15, 8, 9, 8, 8, 8, 9, 14, 8, 9, 9, 9, 8, 8, 9, 16},
			{7, 8, 9, 15, 9, 14, 15, 8, 9, 8, 8, 9, 9, 8, 8, 9, 8, 9, 9, 16},
			{7, 8, 9, 8, 8, 9, 14, 14, 15, 14, 14, 15, 15, 14, 8, 9, 8, 8, 9, 16},
			{7, 14, 15, 14, 14, 15, 14, 15, 15, 15, 15, 15, 15, 15, 14, 15, 14, 14, 15, 16},
			{19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 22}};
	
	public Map(String url) {
		map = new int[30][50];
		try { // pour gérer les erreurs
			String ligne;
			int numLigne = 0;
			BufferedReader csvReader = new BufferedReader(new FileReader(url)); // pour lire un fichier
			while ((ligne = csvReader.readLine())!= null) { // donner ligne préparer dans tableau de String
				String [] data = ligne.split(","); // pour lui dire le caractère de séparation
				
				for (int j = 0; j< 50; j++) {
					map[numLigne][j] = Integer.parseInt(data[j]);
				}
				numLigne ++;		
			}
			csvReader.close();
		}
		catch (Exception e){
			System.out.println("le fichier n'existe pas! ");
		}
	}
	
	public int[][] getMap(){
		return this.map;
	}
	
	public void affMap(){
		for(int i = 0; i< map.length; i++) {
			for (int j = 0 ; j< map[i].length; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
}
