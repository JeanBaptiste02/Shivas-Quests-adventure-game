package gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Iterator;

import configuration.GameConfiguration;
import motor.map.Block;
import motor.map.BlockManager;
import motor.map.Map;
import motor.map.MapBuilder;
import motor.mobile.Joueur;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 *
 */
public class PaintStrategy {
	
	public void paint(Map map, Graphics2D g2) {
		Block[][] blocks = map.getBlocks();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		MapBuilder buildMap = new MapBuilder("src/maps/map01.txt");
		
	    Image[] array = new Image[10];                  // tableau de 10 images contenant les differents types de blocks
	    array[0] = BlockManager.readImage("images/blocks/grass.png");
	    array[1] = BlockManager.readImage("images/blocks/tree.png");
	    array[2] = BlockManager.readImage("images/blocks/flame.png");
	    
	    int columnIndex = 0;
	    int lineIndex = 0;
	
	    while(columnIndex < map.getColumnCount() && lineIndex < map.getLineCount()) {
	    	Block block = blocks[lineIndex][columnIndex];
			
	    	int x = block.getColumn();
	    	int y = block.getLine();
	
			Iterator<Integer> iterator = buildMap.getMapData().iterator(); // parcours l'arraylist
			while (iterator.hasNext()) {
				Integer currentId = iterator.next();
			
				g2.drawImage(array[currentId], x * blockSize, y * blockSize, blockSize, blockSize, null); // affiche le type de block à l'indice correspondant du tableau
				columnIndex++;
				x++;
				
				if(columnIndex == map.getColumnCount()) {
					columnIndex = 0;
					x = 0;
					lineIndex++;
					y++;
				}
			}
	    }		
	}
	
	public void paint(Joueur p, Graphics2D graphics) {
		Block position = p.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		Image up1, up2, down1, down2, left1, left2, right1, right2;
		
		switch(p.getDirection()) {
		case "up":
			if(p.getSpriteNum() == 1) {
				up1 = BlockManager.readImage("images/player/up1.png");
				graphics.drawImage(up1, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			if(p.getSpriteNum() == 2) {
				up2 = BlockManager.readImage("images/player/up2.png");
				graphics.drawImage(up2, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			break;
		case "down":
			if(p.getSpriteNum() == 1) {
				down1 = BlockManager.readImage("images/player/down1.png");
				graphics.drawImage(down1, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			if(p.getSpriteNum() == 2) {
				down2 = BlockManager.readImage("images/player/down2.png");
				graphics.drawImage(down2, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			break;
		case "left":
			if(p.getSpriteNum() == 1) {
				left1 = BlockManager.readImage("images/player/left1.png");
				graphics.drawImage(left1, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			if(p.getSpriteNum() == 2) {
				left2 = BlockManager.readImage("images/player/left2.png");
				graphics.drawImage(left2, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			break;
		case "right":
			if(p.getSpriteNum() == 1) {
				right1 = BlockManager.readImage("images/player/right1.png");
				graphics.drawImage(right1, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			if(p.getSpriteNum() == 2) {
				right2 = BlockManager.readImage("images/player/right2.png");
				graphics.drawImage(right2, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			break;
		}
		
		

	}

	
}
