package motor.map;

import java.awt.Image;

/**
 * Cette classe permet d'ajouter une image dans un tableau d'images en fonction des indices qui seront appelés dans d'autres classes
 * @author vikne
 *
 */
public class Tile {
	
	private Image[] images;
	private int currentSize = 0;
	
	/**
	 * constructeur
	 * @param size
	 */
	public Tile(int size) {
		images = new Image[size];
	}
	
	/**
	 * permet d'ajouter les images dans le tableau
	 * @param img represente l'image a ajouter
	 */
	public void add(Image img) {
		if (currentSize != images.length) {
			images[currentSize] = img;
			currentSize++;
		}
	}
	
	/**
	 * permet de retourner l'image courrante
	 * @param index represente l'index du tableau d'images
	 * @return l'image courrante
	 */
	public Image currentImage(int index) {
		return images[index];
	}

	public Image[] getImages() {
		return images;
	}

	public void setImages(Image[] images) {
		this.images = images;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}

	
}
