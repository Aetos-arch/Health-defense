package td.modele;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
	
	private int[][] map;
	
	public Map(String url) {
		map = new int[30][50];
		try {
			String ligne;
			int numLigne = 0;
			BufferedReader csvReader = new BufferedReader(new FileReader(url));
			while ((ligne = csvReader.readLine())!= null) {
				String [] data = ligne.split(",");
				
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
