package motor.objects;

import java.awt.Image;

/**
 * Cette classe permet d'ajouter une image dans un tableau d'objets (images) en fonction des indices qui seront appelés dans d'autres classes
 * @author vikne
 *
 */
public class ObjectsImagesTab {
	
	private Image[] images;
	private int currentSize = 0;
	
	/**
	 * constructeur
	 * @param size
	 */
	public ObjectsImagesTab(int size) {
		images = new Image[size];
	}
	
	/**
	 * permet d'ajouter les objets dans le tableau
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
	 * @param index represente l'index du tableau d'objets
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
	
}
