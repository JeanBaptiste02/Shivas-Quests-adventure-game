package motor.map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import configuration.GameConfiguration;

public class MapBuilder {
	
	private ArrayList<Integer> mapData; // l'arraylist qui va stocker tout les nombres du fichier txt
	

	public MapBuilder(String fileName) {
		mapData = new ArrayList<>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			
			while ((line = reader.readLine()) != null) { // lit ligne par ligne le contenu du fichier
				String fields[] = line.split(" "); // ici le séparateur c'est l'espace
				for(int col = 0; col < GameConfiguration.BLOCK_COLUMN_COUNT; col++) {
					mapData.add(Integer.parseInt(fields[col])); // ajoute le caractère courant dans l'arraylist sous forme d'entier
				}						
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
  
	public ArrayList<Integer> getMapData() {
		return mapData;
	}
		

}
