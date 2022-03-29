package motor.process;


import java.util.Iterator;

import configuration.GameConfiguration;
import motor.map.Block;
import motor.map.Map;
import motor.map.MapBuilder;
import motor.mobile.Joueur;
import motor.mobile.JoueurFictif;
import motor.objects.CrystalObject;
import motor.objects.DoorObject;
import motor.objects.KeyObject;
import motor.objects.SuperObject;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 * cette classe permet de gerer les apparences et les mouvements du joueur
 */
public class MobileElementManager {

	private Map map;
	private Joueur hero;
	private JoueurFictif point;
	private boolean collisionOn = false;
	private SuperObject obj[] = new SuperObject[10];


	public MobileElementManager(Map map) {
		this.map = map;
	}

	public void moveLeftPlayer() {
		Block position = hero.getPosition();
		collisionChecker();
		if(collisionOn == false) {
			if (position.getColumn() > 0) {
				Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
				hero.setPosition(newPosition);
			}
			hero.setDownPressed(false);
			hero.setUpPressed(false);
			hero.setRightPressed(false);
		}
		spritePlayer();	
	}

	public void moveRightPlayer() {
		Block position = hero.getPosition();
		collisionChecker();
		if(collisionOn == false) {
			if (position.getColumn() < GameConfiguration.BLOCK_COLUMN_COUNT - 1) {
				Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
				hero.setPosition(newPosition);
			}
			hero.setDownPressed(false);
			hero.setLeftPressed(false);
			hero.setUpPressed(false);
		}
		spritePlayer();
	}
	
	public void moveTopPlayer() {
		Block position = hero.getPosition();
		collisionChecker();
		if(collisionOn == false) {
			if (position.getLine() > 0) {
				Block newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
				hero.setPosition(newPosition);
			}
			hero.setDownPressed(false);
			hero.setLeftPressed(false);
			hero.setRightPressed(false);
		}
		spritePlayer();
	}
	
	public void moveBottomPlayer() {
		Block position = hero.getPosition();
		collisionChecker();
		if(collisionOn == false) {
			if (position.getLine() <  GameConfiguration.BLOCK_LINE_COUNT - 1) {
				Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
				hero.setPosition(newPosition);
			}
			hero.setUpPressed(false);
			hero.setLeftPressed(false);
			hero.setRightPressed(false);
		}
		spritePlayer();	
	}
	
	public void moveRightPlayerFictional() {
		Block pointPos = point.getPosition();
		collisionChecker();
		if(collisionOn == false) {
			if (pointPos.getColumn() < GameConfiguration.BLOCK_COLUMN_COUNT - 1) {
				Block newPos = map.getBlock(pointPos.getLine(), pointPos.getColumn() + 1);
				point.setPosition(newPos);
			}
			point.setDownPressed(false);
			point.setLeftPressed(false);
			point.setUpPressed(false);
		}
	}
	
	public void moveLeftPlayerFictional() {
		Block pointPos = point.getPosition();
		collisionChecker();
		if(collisionOn == false) {
			if (pointPos.getColumn() > 0) {
				Block newPos = map.getBlock(pointPos.getLine(), pointPos.getColumn() - 1);
				point.setPosition(newPos);
			}
			point.setDownPressed(false);
			point.setUpPressed(false);
			point.setRightPressed(false);
		}
	}
	
	public void moveTopPlayerFictional() {
		Block pointPos = point.getPosition();
		collisionChecker();
		if(collisionOn == false) {
			if (pointPos.getLine() > 0) {
				Block newPos = map.getBlock(pointPos.getLine() - 1, pointPos.getColumn());
				point.setPosition(newPos);
			}
			point.setDownPressed(false);
			point.setLeftPressed(false);
			point.setRightPressed(false);
		}	
	}
	
	public void moveBottomPlayerFictional() {
		Block pointPos = point.getPosition();
		collisionChecker();
		if(collisionOn == false) {
			if (pointPos.getLine() <  GameConfiguration.BLOCK_LINE_COUNT - 1) {
				Block newPos = map.getBlock(pointPos.getLine() + 1, pointPos.getColumn());
				point.setPosition(newPos);
			}
			point.setUpPressed(false);
			point.setLeftPressed(false);
			point.setRightPressed(false);
		}
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
	
	public void collisionChecker() {
		Block[][] blocks = map.getBlocks();
		MapBuilder m = new MapBuilder("src/maps/map.txt");
		
		Block posPoint = point.getPosition();
		
		int columnIndex = 0;
	    int lineIndex = 0;
	    
	    while(columnIndex < map.getColumnCount() && lineIndex < map.getLineCount()) {
	    	Block block = blocks[lineIndex][columnIndex];
			
	    	int x = block.getColumn();
	    	int y = block.getLine();
	    	
	
			Iterator<Integer> iterator = m.getMapData().iterator(); // parcours l'arraylist
			while (iterator.hasNext()) {
				Integer currentId = iterator.next();
				
				map.getBlock(lineIndex, columnIndex, currentId); // chaque block de la map a un id
				
				if(map.getId() == 0 && posPoint.getColumn() == x && posPoint.getLine() == y) {
					collisionOn = false;
				}
				
				if(map.getId() == 1 && posPoint.getColumn() == x && posPoint.getLine() == y ) {
					if(point.getRightPressed() == true) {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 1);
						point.setPosition(newPosi);
					}
					if(point.getLeftPressed() == true )  {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 1);
						point.setPosition(newPosi);
					}
					if(point.getUpPressed() == true)  {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine() + 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(point.getDownPressed() == true)  {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine() - 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					
				}
				if(map.getId() == 2 && posPoint.getColumn() == x && posPoint.getLine() == y) {
					if(point.getRightPressed() == true) {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 1);
						point.setPosition(newPosi);
					}
					if(point.getLeftPressed() == true )  {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 1);
						point.setPosition(newPosi);
					}
					if(point.getUpPressed() == true)  {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine() + 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(point.getDownPressed() == true)  {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine() - 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
				}
				if(map.getId() == 3 && posPoint.getColumn() == x && posPoint.getLine() == y) {
					if(point.getRightPressed() == true) {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 1);
						point.setPosition(newPosi);
					}
					if(point.getLeftPressed() == true )  {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 1);
						point.setPosition(newPosi);
					}
					if(point.getUpPressed() == true)  {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine() + 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(point.getDownPressed() == true)  {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine() - 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
				}
				if(map.getId() == 4 && posPoint.getColumn() == x && posPoint.getLine() == y) {
					if(point.getRightPressed() == true) {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 1);
						point.setPosition(newPosi);
					}
					if(point.getLeftPressed() == true )  {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 1);
						point.setPosition(newPosi);
					}
					if(point.getUpPressed() == true)  {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine() + 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(point.getDownPressed() == true)  {
						collisionOn = true;
						Block newPosi = map.getBlock(posPoint.getLine() - 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
				}
				if(map.getId() == 5 && posPoint.getColumn() == x && posPoint.getLine() == y) {
					collisionOn = false;
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
	
	public void setObjects() {
		
		Block blockKey1 = map.getBlock(9, 29);
		obj[0] = new KeyObject(blockKey1);

		Block blockKey2 = map.getBlock(14, 36);
		obj[1] = new KeyObject(blockKey2);
		
		Block blockKey3 = map.getBlock(26, 18);
		obj[2] = new KeyObject(blockKey3);
		
		Block blockDoor1 = map.getBlock(4, 24);
		obj[3] = new DoorObject(blockDoor1);
		
		Block blockDoor2 = map.getBlock(18, 43);
		obj[4] = new DoorObject(blockDoor2);
		
		Block blockDoor3 = map.getBlock(31, 24);
		obj[5] = new DoorObject(blockDoor3);
		
		Block blockCrystal1 = map.getBlock(2, 24);
		obj[6] = new CrystalObject(blockCrystal1);
		
		Block blockCrystal2 = map.getBlock(18, 45);
		obj[7] = new CrystalObject(blockCrystal2);
		
		Block blockCrystal3 = map.getBlock(33, 24);
		obj[8] = new CrystalObject(blockCrystal3);
		
	}

	public SuperObject[] getObj() {
		return obj;
	}

	public void setObj(SuperObject[] obj) {
		this.obj = obj;
	}
	

	
	
}
