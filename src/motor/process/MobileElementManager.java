package motor.process;


import configuration.GameConfiguration;
import motor.map.Block;
import motor.map.Map;
import motor.mobile.Joueur;
import motor.mobile.JoueurFictif;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 * cette classe permet de gerer les apparences et les mouvements du joueur
 */
public class MobileElementManager {

	private Map map;
	private Joueur hero;
	private JoueurFictif point;


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
	
	public void moveRightPlayerFictional() {
		Block pointPos = point.getPosition();
		
		if (pointPos.getColumn() < GameConfiguration.BLOCK_COLUMN_COUNT - 1) {
			Block newPos = map.getBlock(pointPos.getLine(), pointPos.getColumn() + 1);
			point.setPosition(newPos);
		}
		point.setDownPressed(false);
		point.setLeftPressed(false);
		point.setUpPressed(false);
	}
	
	public void moveLeftPlayerFictional() {
		Block pointPos = point.getPosition();
		
		if (pointPos.getColumn() > 0) {
			Block newPos = map.getBlock(pointPos.getLine(), pointPos.getColumn() - 1);
			point.setPosition(newPos);
		}
		point.setDownPressed(false);
		point.setUpPressed(false);
		point.setRightPressed(false);
	}
	
	public void moveTopPlayerFictional() {
		Block pointPos = point.getPosition();
		
		if (pointPos.getLine() > 0) {
			Block newPos = map.getBlock(pointPos.getLine() - 1, pointPos.getColumn());
			point.setPosition(newPos);
		}
		point.setDownPressed(false);
		point.setLeftPressed(false);
		point.setRightPressed(false);
	}
	
	public void moveBottomPlayerFictional() {
		Block pointPos = point.getPosition();
		
		if (pointPos.getLine() <  GameConfiguration.BLOCK_LINE_COUNT - 1) {
			Block newPos = map.getBlock(pointPos.getLine() + 1, pointPos.getColumn());
			point.setPosition(newPos);
		}
		point.setUpPressed(false);
		point.setLeftPressed(false);
		point.setRightPressed(false);
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

	public JoueurFictif getPoint() {
		return point;
	}

	public void setPoint(JoueurFictif point) {
		this.point = point;
	}
	
	
//	public void showSubMap() {
//		Block position = hero.getPosition();
//
//		if((position.getColumn() <= 16 && position.getColumn() >= 0) && (position.getLine() <= 16 && position.getLine() >= 0)) {
//			Block newPosition = map.getBlock(0, 0);
//			cam.setPosition(newPosition);
//		}
//		if((position.getColumn() <= 32 && position.getColumn() >= 16) && (position.getLine() <= 16 && position.getLine() >= 0)) {
//			Block newPosition = map.getBlock(0, 1);
//			cam.setPosition(newPosition);
//		}
//		if((position.getColumn() <= 48 && position.getColumn() >= 32) && (position.getLine() <= 16 && position.getLine() >= 0)) {
//			Block newPosition = map.getBlock(0, 2);
//			cam.setPosition(newPosition);
//		}
//		if((position.getColumn() <= 16 && position.getColumn() >= 0) && (position.getLine() <= 32 && position.getLine() >= 16)) {
//			Block newPosition = map.getBlock(1, 0);
//			cam.setPosition(newPosition);
//		}
//		if((position.getColumn() <= 32 && position.getColumn() >= 16) && (position.getLine() <= 32 && position.getLine() >= 16)) {
//			Block newPosition = map.getBlock(1, 1);
//			cam.setPosition(newPosition);
//		}
//		if((position.getColumn() <= 48 && position.getColumn() >= 32) && (position.getLine() <= 32 && position.getLine() >= 16)) {
//			Block newPosition = map.getBlock(1, 2);
//			cam.setPosition(newPosition);
//		}
//		if((position.getColumn() <= 16 && position.getColumn() >= 0) && (position.getLine() <= 48 && position.getLine() >= 32)) {
//			Block newPosition = map.getBlock(2, 0);
//			cam.setPosition(newPosition);
//		}
//		if((position.getColumn() <= 32 && position.getColumn() >= 16) && (position.getLine() <= 48 && position.getLine() >= 32)) {
//			Block newPosition = map.getBlock(2, 1);
//			cam.setPosition(newPosition);
//		}
//		if((position.getColumn() <= 48 && position.getColumn() >= 32) && (position.getLine() <= 48 && position.getLine() >= 32)) {
//			Block newPosition = map.getBlock(2, 2);
//			cam.setPosition(newPosition);
//		}
//	}
	
//	public Camera getCamera() {
//		return cam;
//	}
//
//	public void set(Camera c) {
//		this.cam = c;
//	}
	
	
}
