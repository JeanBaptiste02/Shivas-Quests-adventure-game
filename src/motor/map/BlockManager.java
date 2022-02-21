package motor.map;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 * cette classe permet de lire un fichier image
 */
public class BlockManager {
	
	/**
	 * Reads a image from an image file.
	 * 
	 * @param cheminfichier the path (from "src") of the image file
	 * @return the read file
	 */
	public static Image readImage(String cheminfichier) {
		try {
			return ImageIO.read(new File(cheminfichier));
		} catch (IOException e) {
			System.err.println("impossible d'ouvrir ce fichier image");
			return null;
		}
	}
	
	
}