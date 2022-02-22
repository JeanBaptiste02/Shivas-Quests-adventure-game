package gui;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import configuration.GameConfiguration;
import motor.map.Block;
import motor.map.BlockManager;
import motor.map.Map;
import motor.mobile.Joueur;


/**
 * 
 * @author D.JB E.SRI Z.VIC
 *
 */
public class PaintStrategy {
	
	public void paint(Graphics2D g2, Map map) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];
				
				//g2.setColor(Color.GREEN);
				g2.drawImage(BlockManager.readImage("src/images/herbe.png"), block.getColumn() * blockSize, block.getLine() * blockSize, GameConfiguration.BLOCK_SIZE, GameConfiguration.BLOCK_SIZE, null);
				//g2.fillRect(block.getColumn()*blockSize, block.getLine()*blockSize, blockSize, blockSize);
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
				up1 = BlockManager.readImage("src/player/up1.png");
				graphics.drawImage(up1, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			if(p.getSpriteNum() == 2) {
				up2 = BlockManager.readImage("src/player/up2.png");
				graphics.drawImage(up2, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			break;
		case "down":
			if(p.getSpriteNum() == 1) {
				down1 = BlockManager.readImage("src/player/down1.png");
				graphics.drawImage(down1, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			if(p.getSpriteNum() == 2) {
				down2 = BlockManager.readImage("src/player/down2.png");
				graphics.drawImage(down2, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			break;
		case "left":
			if(p.getSpriteNum() == 1) {
				left1 = BlockManager.readImage("src/player/left1.png");
				graphics.drawImage(left1, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			if(p.getSpriteNum() == 2) {
				left2 = BlockManager.readImage("src/player/left2.png");
				graphics.drawImage(left2, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			break;
		case "right":
			if(p.getSpriteNum() == 1) {
				right1 = BlockManager.readImage("src/player/right1.png");
				graphics.drawImage(right1, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			if(p.getSpriteNum() == 2) {
				right2 = BlockManager.readImage("src/player/right2.png");
				graphics.drawImage(right2, x * blockSize, y * blockSize, blockSize, blockSize, null);
			}
			break;
		}
		
		

	}

	
}
