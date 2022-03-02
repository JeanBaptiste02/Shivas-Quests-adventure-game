package motor.process;

import configuration.GameConfiguration;
import motor.map.Block;
import motor.map.Map;
import motor.mobile.Joueur;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 * cette classe permet de gerer les apparences et les mouvements du joueur
 */
public class MobileElementManager {

	private Map map;
	private Joueur hero;

	public MobileElementManager(Map map) {
		this.map = map;
	}

	public void moveLeftPlayer() {
		Block position = hero.getPosition();

		if (position.getColumn() > 0) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
			hero.setPosition(newPosition);
		}
		hero.setDownPressed(false);
		hero.setUpPressed(false);
		hero.setRightPressed(false);
		spritePlayer();

	}

	public void moveRightPlayer() {
		Block position = hero.getPosition();

		if (position.getColumn() < GameConfiguration.BLOCK_COLUMN_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
			hero.setPosition(newPosition);
		}
		hero.setDownPressed(false);
		hero.setLeftPressed(false);
		hero.setUpPressed(false);
		spritePlayer();
	}
	
	public void moveTopPlayer() {
		Block position = hero.getPosition();

		if (position.getLine() > 0) {
			Block newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
			hero.setPosition(newPosition);
		}
		hero.setDownPressed(false);
		hero.setLeftPressed(false);
		hero.setRightPressed(false);
		spritePlayer();
	}
	
	public void moveBottomPlayer() {
		Block position = hero.getPosition();

		if (position.getLine() <  GameConfiguration.BLOCK_LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
			hero.setPosition(newPosition);
		}
		hero.setUpPressed(false);
		hero.setLeftPressed(false);
		hero.setRightPressed(false);
		spritePlayer();
	}
	
	public void spritePlayer() {
		
		if(hero.getDownPressed() == true || hero.getRightPressed() == true 
				|| hero.getLeftPressed() == true || hero.getUpPressed() == true) {
			if(hero.getUpPressed() == true) {
				hero.setDirection("up");
				System.out.println("haut");
			} 
			else if(hero.getDownPressed() == true) {
				hero.setDirection("down");
				System.out.println("bas");
			}
			else if(hero.getLeftPressed() == true) {
				hero.setDirection("left");
				System.out.println("gauche");
			}
			else if(hero.getRightPressed() == true) {
				hero.setDirection("right");
				System.out.println("droit");
			}
			
			if(hero.getSpriteNum() == 1) {
				hero.setSpriteNum(2);
			}
			else if(hero.getSpriteNum() == 2) {
				hero.setSpriteNum(1);
			}	
		}
	}
	
	public Joueur getPlayer() {
		return hero;
	}
	
	public void set(Joueur p) {
		this.hero = p;
	}

}
