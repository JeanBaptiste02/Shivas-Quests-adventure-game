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
import motor.mobile.JoueurFictif;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 *
 */
public class PaintStrategy {
	
	public void paint(Map map, Joueur p, JoueurFictif point, Graphics2D g2) {
		Block[][] blocks = map.getBlocks();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		MapBuilder m = new MapBuilder("images/maps/map.txt"); // map text file

		Block position = p.getPosition();
		Block posPoint = point.getPosition();

	    Image[] array = new Image[10];                  // array of 10 images which is contained in the blocks
	    array[0] = BlockManager.readImage("images/blocks/grass.png");
	    array[1] = BlockManager.readImage("images/blocks/tree.png");
	    array[2] = BlockManager.readImage("images/blocks/flame.png");
	    array[3] = BlockManager.readImage("images/blocks/water.png");

	    int columnIndex = 0;
	    int lineIndex = 0;

	    while(columnIndex < map.getColumnCount() && lineIndex < map.getLineCount()) {
	    	Block block = blocks[lineIndex][columnIndex];

	    	int x = block.getColumn();
	    	int y = block.getLine();

			Iterator<Integer> iterator = m.getMapData().iterator(); // parcours l'arraylist
			while (iterator.hasNext()) {
				Integer currentId = iterator.next();


				if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 1
					&& (x <= 15 && x >= 0) && (y <= 11 && y >= 0)) {
					g2.drawImage(array[currentId], x * blockSize, y * blockSize, blockSize, blockSize, null); // affiche le type de block a l'indice correspondant du tableau
					if(posPoint.getColumn() == 15) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 14);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getColumn() == 0) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() + 1);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 1);
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 11) {
						Block newPos = map.getBlock(position.getLine() - 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() + 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 0) {
						Block newPos = map.getBlock(position.getLine() + 1, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() + 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 2
					&& (x <= 31 && x >= 16) && (y <= 11 && y >= 0)) {
					g2.drawImage(array[currentId], (x * blockSize) - (16 * blockSize), y * blockSize, blockSize, blockSize, null);
					if(posPoint.getColumn() == 31) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 14);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getColumn() == 16) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() + 14);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 11) {
						Block newPos = map.getBlock(position.getLine() - 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() + 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 0) {
						Block newPos = map.getBlock(position.getLine() + 1, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() + 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 3
					&& (x <= 47 && x >= 32) && (y <= 11 && y >= 0)) {
					g2.drawImage(array[currentId], (x * blockSize) - (32 * blockSize), y * blockSize, blockSize, blockSize, null);
					if(posPoint.getColumn() == 47) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 1);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 1);
						point.setPosition(newPosi);
					}
					if(posPoint.getColumn() == 32) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() + 14);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 11) {
						Block newPos = map.getBlock(position.getLine() - 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() + 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 0) {
						Block newPos = map.getBlock(position.getLine() + 1, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() + 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					
				}
				if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 4
					&& (x <= 15 && x >= 0) && (y <= 23 && y >= 12)) {
					g2.drawImage(array[currentId], x * blockSize, (y * blockSize) - (12 * blockSize), blockSize, blockSize, null);
					if(posPoint.getColumn() == 15) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 14);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getColumn() == 0) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() + 1);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 1);
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 23) {
						Block newPos = map.getBlock(position.getLine() - 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() + 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 12) {
						Block newPos = map.getBlock(position.getLine() + 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() - 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 5
					&& (x <= 31 && x >= 16) && (y <= 23 && y >= 12)) {
					g2.drawImage(array[currentId], (x * blockSize) - (16 * blockSize), (y * blockSize) - (12 * blockSize), blockSize, blockSize, null);
					if(posPoint.getColumn() == 31) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 14);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getColumn() == 16) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() + 14);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 23) {
						Block newPos = map.getBlock(position.getLine() - 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() + 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 12) {
						Block newPos = map.getBlock(position.getLine() + 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() - 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 6
					&& (x <= 47 && x >= 32) && (y <= 23 && y >= 12)) {
					g2.drawImage(array[currentId], (x * blockSize) - (32 * blockSize), (y * blockSize) - (12 * blockSize), blockSize, blockSize, null);
					if(posPoint.getColumn() == 47) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 1);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 1);
						point.setPosition(newPosi);
					}
					if(posPoint.getColumn() == 32) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() + 14);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 23) {
						Block newPos = map.getBlock(position.getLine() - 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() + 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 12) {
						Block newPos = map.getBlock(position.getLine() + 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() - 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 7
					&& (x <= 15 && x >= 0) && (y <= 35 && y >= 24)) {
					g2.drawImage(array[currentId], x * blockSize, (y * blockSize) - (24 * blockSize), blockSize, blockSize, null);
					if(posPoint.getColumn() == 15) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 14);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getColumn() == 0) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() + 1);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 1);
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 35) {
						Block newPos = map.getBlock(position.getLine() - 1, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() - 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 24) {
						Block newPos = map.getBlock(position.getLine() + 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() - 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 8
					&& (x <= 31 && x >= 16) && (y <= 35 && y >= 24)) {
					g2.drawImage(array[currentId], (x * blockSize) - (16 * blockSize), (y * blockSize) - (24 * blockSize), blockSize, blockSize, null);
					if(posPoint.getColumn() == 31) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 14);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getColumn() == 16) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() + 14);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 35) {
						Block newPos = map.getBlock(position.getLine() - 1, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() - 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 24) {
						Block newPos = map.getBlock(position.getLine() + 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() - 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 9
					&& (x <= 47 && x >= 32) && (y <= 35 && y >= 24)) {
					g2.drawImage(array[currentId], (x * blockSize) - (32 * blockSize), (y * blockSize) - (24 * blockSize), blockSize, blockSize, null);
					if(posPoint.getColumn() == 47) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 1);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 1);
						point.setPosition(newPosi);
					}
					if(posPoint.getColumn() == 32) {
						Block newPos = map.getBlock(position.getLine(), position.getColumn() + 14);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 35) {
						Block newPos = map.getBlock(position.getLine() - 1, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() - 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 24) {
						Block newPos = map.getBlock(position.getLine() + 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() - 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
				}

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
	
	public void paint(JoueurFictif point, Graphics2D graphics) {
		Block position = point.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.drawRect(x*blockSize, y*blockSize, blockSize, blockSize);
	}

	
}
