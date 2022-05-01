package motor.mobile;

import java.awt.Image;

public class MonstersImagesTab {

	private Image[] images;
	private int currentSize = 0;
	
	public MonstersImagesTab(int size) {
		images = new Image[size];
	}
	
	public void add(Image img) {
		if (currentSize != images.length) {
			images[currentSize] = img;
			currentSize++;
		}
	}
	
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
