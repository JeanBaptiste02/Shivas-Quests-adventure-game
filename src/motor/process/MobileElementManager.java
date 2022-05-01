package motor.process;



import java.util.ArrayList;
import java.util.Iterator;

import configuration.GameConfiguration;
import motor.map.Block;
import motor.map.Map;
import motor.map.MapBuilder;

import motor.mobile.Joueur;
import motor.mobile.JoueurFictif;
import motor.mobile.Monster;
import motor.mobile.Monsters;
import motor.mobile.Npc;
import motor.mobile.Npcs;
import motor.mobile.ProjectileFeu;
import motor.mobile.ProjectileHero;
import motor.mobile.ProjectileMonster;
import motor.objects.BlockObject;
import motor.objects.CasqueObject;
import motor.objects.CrystalObject;
import motor.objects.DoorObject;
import motor.objects.EmptyObject;
import motor.objects.KeyObject;
import motor.objects.HeartObject;
import motor.objects.StrengthObject;
import motor.objects.SuperObject;
import motor.objects.TridentObject;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 * 
 */
public class MobileElementManager {

	private Map map;
	private Joueur hero;
	private JoueurFictif point;
	private Monsters monsters = new Monsters(15);
	private Npcs npcs = new Npcs(10);

	private boolean collisionOn = false;
	private boolean collisionMonsterOn = false;
	private boolean playerCanAttack = true;
	private boolean monsterCanAttack = false;
	private boolean maskButton1 = false;
	private boolean maskButton5 = false;
	private boolean playerTouched = false;
	private boolean choiceSelected = false;
	private boolean casqueSelected = false;
	private boolean canUseCasque = false;
	private boolean casqueTouched = false;
	private boolean tridentTouched = false;
	private boolean hasCasque = false;
	private boolean hasTrident = false;
	private boolean npcDialogueActived = false;

	private SuperObject obj[] = new SuperObject[60];
	private ArrayList<ProjectileMonster> projectilesMons = new ArrayList<ProjectileMonster>();
	private ArrayList<ProjectileHero> projectilesHero = new ArrayList<ProjectileHero>();
	private ArrayList<ProjectileFeu> projectilesFeu = new ArrayList<ProjectileFeu>();

	private int hasKey = 0;
	private int hasCrystal = 0;
	private int hasStrength = 0;
	private int time;
	private int choiceNum;
	private int useCasque = 1;
	private int useTrident = 2;
	private int useFeu = 1;
	private int bossDefeated = 0;
	private int miniMonsterDefeated = 0;
	private int gardienDefeated = 0;
	private int maxLvlReached = 0;
	private int expCourant = 0;
	private int expMaximum = 500;
	private int niveau = 1;
	private int cpt1 = 1, cpt2 = 1, cpt3 = 1, cpt4 = 1, cpt5 = 1;
	private int nbrOr = 0;
	
	private String dialogueNpc;
	
	public MobileElementManager(Map map) {
		this.map = map;
	}

	public void moveLeftPlayer() {
		Block position = hero.getPosition();
		collisionTile();
		checkCollisionObject();
		collisionMonster();
		collisionNpc();
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
		collisionTile();
		checkCollisionObject();
		collisionMonster();
		collisionNpc();
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
		collisionTile();
		checkCollisionObject();
		collisionMonster();
		collisionNpc();
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
		collisionTile();
		checkCollisionObject();
		collisionMonster();
		collisionNpc();
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
		collisionTile();
		checkCollisionObject();
		collisionMonster();
		collisionNpc();
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
		collisionTile();
		checkCollisionObject();
		collisionMonster();
		collisionNpc();
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
		collisionTile();
		checkCollisionObject();
		collisionMonster();
		collisionNpc();
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
		collisionTile();
		checkCollisionObject();
		collisionMonster();
		collisionNpc();
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
		if(point.getDownPressed() == true || point.getRightPressed() == true 
				|| point.getLeftPressed() == true || point.getUpPressed() == true) {
			if(point.getUpPressed() == true) {
				hero.setDirection("up");
				System.out.println("haut");
			} 
			else if(point.getDownPressed() == true) {
				hero.setDirection("down");
				System.out.println("bas");
			}
			else if(point.getLeftPressed() == true) {
				hero.setDirection("left");
				System.out.println("gauche");
			}
			else if(point.getRightPressed() == true) {
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
	
	public void generateOneProjectileMons() { // creer juste 1 seule projectile a chaque tour
		for(int i=0; i<monsters.getMonsters().length; i++) {
			if(monsters.currentMonster(i) != null) {
				Block position = monsters.currentMonster(i).getPosition();
				if(collisionMonsterOn == true && projectilesMons.size() == 0 
						&& point.getNameCurrentMonster() == monsters.currentMonster(i).getName()) { // si le joueur touche le monstre et que larraylist projectilesMons est vide
					ProjectileMonster projectile = new ProjectileMonster(position);
					projectilesMons.add(projectile);
				}
			}
		}
	}
	
	public void generateProjectileHero() { 
		Block position = hero.getPosition();
		ProjectileHero projectile = new ProjectileHero(position);
		projectilesHero.add(projectile);	
	}
	
	public void generateProjectileFeu() { 
		Block position = hero.getPosition();
		ProjectileFeu projectile = new ProjectileFeu(position);
		projectilesFeu.add(projectile);	
	}
	
	public void nextRound() {
		systemeDeCombat();	
		
		if(point.getHeWon() == true && time > 0) { // permet davoir 1 seule fois les items une fois le monstre battu
			itemReward();
		}
		
		if((obj[35] == null || obj[36] == null || obj[37] == null) && useCasque == 1) { // a chaque combat on peut utiliser une seule fois le casque
			canUseCasque = true;
		}
		
		quêtesPrincipales();
		quêtesSecondaires();
		systemeDeNiveauEtOr();
		
	}
	
	public void quêtesPrincipales() {
		if(point.getNameCurrentMonster() == "boss" && point.getHeWon() == true && collisionMonsterOn == true) {
			bossDefeated = 1;
		}
	}
	
	public void quêtesSecondaires() {
		if(point.getNameCurrentMonster() == "miniMonster1" || point.getNameCurrentMonster() == "miniMonster2" 
				|| point.getNameCurrentMonster() == "miniMonster3" || point.getNameCurrentMonster() == "miniMonster4" || point.getNameCurrentMonster() == "miniMonster5" 
				|| point.getNameCurrentMonster() == "miniMonster6" || point.getNameCurrentMonster() == "miniMonster7" || point.getNameCurrentMonster() == "miniMonster8") {
			if(point.getHeWon() == true && miniMonsterDefeated != 2 && collisionMonsterOn == true) {
				 miniMonsterDefeated++;
			 } 
		}
		
		if(point.getNameCurrentMonster() == "asura1" || point.getNameCurrentMonster() == "asura2"
				|| point.getNameCurrentMonster() == "asura3") {
			if(point.getHeWon() == true && gardienDefeated != 2 && collisionMonsterOn == true) {
				 gardienDefeated++;
			}	
		}
		
	}
	
	public void systemeDeNiveauEtOr() {
		if(point.getNameCurrentMonster() == "miniMonster1" || point.getNameCurrentMonster() == "miniMonster2" 
				|| point.getNameCurrentMonster() == "miniMonster3" || point.getNameCurrentMonster() == "miniMonster4" || point.getNameCurrentMonster() == "miniMonster5" 
				|| point.getNameCurrentMonster() == "miniMonster6" || point.getNameCurrentMonster() == "miniMonster7" || point.getNameCurrentMonster() == "miniMonster8") {
			if(point.getHeWon() == true && collisionMonsterOn == true) {
				 expCourant += 500;
				 nbrOr += 50;
			 } 
		}
		
		if(point.getNameCurrentMonster() == "asura1" || point.getNameCurrentMonster() == "asura2"
				|| point.getNameCurrentMonster() == "asura3") {
			if(point.getHeWon() == true  && collisionMonsterOn == true) {
				 expCourant += 1000;
				 nbrOr += 100;
			 }	
		}
		
		
		if(hasCrystal == 3 && cpt1 > 0) {
			expCourant += 1500;
			nbrOr += 100;
			cpt1--;
		}

		if(miniMonsterDefeated == 2 && cpt2 > 0) {
			expCourant += 750;
			nbrOr += 50;
			cpt2--;
		}
		
		if(gardienDefeated == 2 && cpt3 > 0) {
			expCourant += 750;
			nbrOr += 50;
			cpt3--;
		}
		
		if(maxLvlReached == 1 && cpt5 > 0) {
			nbrOr += 50;
			cpt5--;
		}
		
		if(bossDefeated == 1 && cpt4 > 0) {
			nbrOr += 100;
			cpt4--;
		}
		
		if(expCourant >= 500 && niveau == 1) {
			expCourant -= expMaximum;
			expMaximum = 1500;
			niveau = 2;
		} else if(expCourant >= 1500 && niveau == 2) {
			expCourant -= expMaximum;
			expMaximum = 3000;
			niveau = 3;
		} else if(expCourant >= 3000 && niveau == 3) {
			expCourant -= expMaximum;
			expMaximum = 5000;
			niveau = 4;
		} else if(expCourant >= 5000 && niveau == 4) {
			niveau = 5;
			maxLvlReached++;
		}
	}
	
	private void moveProjectilesMons() {
		ArrayList<ProjectileMonster> outOfBoundProjectiles = new ArrayList<ProjectileMonster>();
		for (int i=0; i<projectilesMons.size(); i++) {
			Block position = projectilesMons.get(i).getPosition();
			
			if (!(position ==  hero.getPosition()) && point.getIsDead() == false) {
				Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
				projectilesMons.get(i).setPosition(newPosition);
			} else {
				playerTouched = true;
				monsterCanAttack = false;
				playerCanAttack = true;
				outOfBoundProjectiles.add(projectilesMons.get(i));
				impactProjectileMons();
			}
		}
		
		for(ProjectileMonster projectile : outOfBoundProjectiles) {
			projectilesMons.remove(projectile);
		}
		
	}
	
	private void  moveProjectilesHero() {
		ArrayList<ProjectileHero> outOfBoundMissiles = new ArrayList<ProjectileHero>();

		for (ProjectileHero proHero : projectilesHero) {
			Block posProHero = proHero.getPosition();
			
			if (!(posProHero.getColumn() == 11 && posProHero.getLine() == 6) && point.getHeWon() == false) { // getHeWon==true signifie que le joueur a tuer le monstre
				Block newPosition = map.getBlock(posProHero.getLine(), posProHero.getColumn() + 1);
				proHero.setPosition(newPosition);
			} else {
				playerCanAttack = false;
				monsterCanAttack = true;
				outOfBoundMissiles.add(proHero);
				impactProjectileHero();
			}
		}
		
		Iterator<ProjectileHero> itr =  outOfBoundMissiles.iterator();
		while(itr.hasNext()) {
			ProjectileHero proHero = itr.next();
			projectilesHero.remove(proHero);
		}
	}

	private void  moveProjectilesFeu() {
		ArrayList<ProjectileFeu> outOfBoundMissiles = new ArrayList<ProjectileFeu>();

		for (ProjectileFeu proFeu : projectilesFeu) {
			Block posProFeu = proFeu.getPosition();
			
			if (!(posProFeu.getColumn() == 11 && posProFeu.getLine() == 6) && point.getHeWon() == false) { // getHeWon==true signifie que le joueur a tuer le monstre
				Block newPosition = map.getBlock(posProFeu.getLine(), posProFeu.getColumn() + 1);
				proFeu.setPosition(newPosition);
			} else {
				playerCanAttack = false;
				monsterCanAttack = true;
				outOfBoundMissiles.add(proFeu);
				impactProjectileHero();
			}
		}
		
		Iterator<ProjectileFeu> itr =  outOfBoundMissiles.iterator();
		while(itr.hasNext()) {
			ProjectileFeu proFeu = itr.next();
			projectilesFeu.remove(proFeu);
		}
	}
	
	public void impactProjectileMons() {
		if(point.getNameCurrentMonster() == "miniMonster1" || point.getNameCurrentMonster() == "miniMonster2" 
				|| point.getNameCurrentMonster() == "miniMonster3" || point.getNameCurrentMonster() == "miniMonster4" || point.getNameCurrentMonster() == "miniMonster5" 
				|| point.getNameCurrentMonster() == "miniMonster6" || point.getNameCurrentMonster() == "miniMonster7" || point.getNameCurrentMonster() == "miniMonster8") {
			 miniMonstersDamage();
			 
		} else if( point.getNameCurrentMonster() == "asura1" || point.getNameCurrentMonster() == "asura2"
			|| point.getNameCurrentMonster() == "asura3") {
			gardiensDamage();
		} else if(point.getNameCurrentMonster() == "boss") {
			bossDamage();
		}
		
		int life = 5;
		for(int i=34; i<=38; i++){
			if(obj[i] == null) {
				life--;
			}
		}
		if(life == 0) {
			resetObjectHeartRed();
			life = 5;
			point.setDead(true);
		}
	}
	
	public int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}
	
	public void miniMonstersDamage() { //chaque miniMonstre enleve 1 coeur
	
			int cpt = 1;
			for(int i=38; i>=34; i--) {
				if(obj[i] != null && cpt > 0) { 
					obj[i] = null;
					cpt--;
				}
			}	
	}
	
	public void gardiensDamage() { //chaque gardien enleve 1 ou 2 coeur
		
		int cpt = getRandomNumber(1, 2);
		for(int i=38; i>=34; i--) {
			if(obj[i] != null && cpt > 0) { 
				obj[i] = null;
				cpt--;
			}
		}	
	}
	
	public void bossDamage() { //chaque gardien enleve 1 ou 2 voir 3 coeur
		
		int cpt = getRandomNumber(1, 3);
		for(int i=38; i>=34; i--) {
			if(obj[i] != null && cpt > 0) { 
				obj[i] = null;
				cpt--;
			}
		}	
	}
	
	public void impactProjectileHero() {
		if(choiceNum == 1) {
			pinakaDamage();
			System.out.println("l'arc a été choisi");
		}else if(choiceNum == 2 && useTrident > 0) {
			trishulDamage();
			System.out.println("le trident a été choisi");
			useTrident--;
		} else if(choiceNum == 4 && useFeu > 0) {
			fireDamage();
			System.out.println("le sort special a été choisi");
			useFeu--;
		}	
		
		int life = 5;
		for(int i=39; i<=43; i++){
			if(obj[i] == null) {
				life--;
			}
		}
		if(life <= 0) {
			resetObjectHeartBlack();
			life = 5;
			point.setHeWon(true);
			time++;
		}
	}
	
	public void pinakaDamage() { //arme par default qui enleve 1 coeur 
		int cpt = 1;
		for(int i=43; i>=39; i--) {
			if(obj[i] != null && cpt > 0) {
				obj[i] = null;
				cpt--;
			}
		}
	}
	
	public void trishulDamage() { //arme qui enleve 2 coeur (on peut l'utiliser 2 fois max)
		int cpt = 2;
		for(int i=43; i>=39; i--) {
			if(obj[i] != null && cpt > 0) {
				obj[i] = null;
				cpt--;
			}
		}
	}
	
	public void casquePower() { //arme qui permet dajouter 2 coeur (on peut l'utiliser une seule fois max)
		System.out.println("le casque a été choisi");
		int posHeart = 0;
		int cpt = 2;
		for(int i=34; i<=38; i++) {
			if(obj[i] != null && obj[i+1] == null && obj[i+2] == null) {
				posHeart = i;
			}
			if(posHeart == 34 && cpt == 2) {
				cpt -= cpt;
				Block blockHeartRed2M1 = map.getBlock(12, 49);
				obj[35] = new HeartObject(blockHeartRed2M1, "heartRed2M1");
				
				Block blockHeartRed3M1 = map.getBlock(12, 50);
				obj[36] = new HeartObject(blockHeartRed3M1, "heartRed3M1");
				
			} else if(posHeart == 35 && cpt == 2) {
				cpt -= cpt;
				Block blockHeartRed3 = map.getBlock(12, 50);
				obj[36] = new HeartObject(blockHeartRed3, "heartRed3M1");
				
				Block blockHeartRed4M1 = map.getBlock(12, 51);
				obj[37] = new HeartObject(blockHeartRed4M1, "heartRed4M1");
			} else if(posHeart == 36 && cpt == 2) {
				cpt -= cpt;
				Block blockHeartRed4 = map.getBlock(12, 51);
				obj[37] = new HeartObject(blockHeartRed4, "heartRed4M1");
				
				Block blockHeartRed5M1 = map.getBlock(12, 52);
				obj[38] = new HeartObject(blockHeartRed5M1, "heartRed5M1");
			
			}
		}
	}
	
	public void fireDamage() {
		int cpt = 3;
		for(int i=43; i>=39; i--) {
			if(obj[i] != null && cpt > 0) {
				obj[i] = null;
				cpt--;
			}
		}
	}
	
	public void systemeDeCombat() {
		
		if(point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) {
			playerTouched = true;
			playerCanAttack = true;
			monsterCanAttack = false;
			resetObjectHeartRed();
			resetObjectHeartBlack();
			projectilesMons.clear();
			projectilesHero.clear();
			useCasque = 1;
			useTrident = 2;
			useFeu = 1;
			maskButton5 = false;
			canUseCasque = false;
			choiceSelected = false;
			casqueSelected = false;
		}
		
		if(!(playerCanAttack == true)) {
			moveProjectilesMons();
		}
		if(!(monsterCanAttack == true)) {
			if(choiceNum != 4) {
				moveProjectilesHero();
			}
			if(choiceNum == 4) {
				moveProjectilesFeu();
			}
		}
		
	}
	
	
	
	public void resetObjectHeartRed() {
		Block blockHeartRed1M1 = map.getBlock(12, 48);
		obj[34] = new HeartObject(blockHeartRed1M1, "heartRed1M1");
		
		Block blockHeartRed2M1 = map.getBlock(12, 49);
		obj[35] = new HeartObject(blockHeartRed2M1, "heartRed2M1");
		
		Block blockHeartRed3M1 = map.getBlock(12, 50);
		obj[36] = new HeartObject(blockHeartRed3M1, "heartRed3M1");
		
		Block blockHeartRed4M1 = map.getBlock(12, 51);
		obj[37] = new HeartObject(blockHeartRed4M1, "heartRed4M1");
		
		Block blockHeartRed5M1 = map.getBlock(12, 52);
		obj[38] = new HeartObject(blockHeartRed5M1, "heartRed5M1");
	}
	
	public void resetObjectHeartBlack() {
		Block blockHeartBlack1M1 = map.getBlock(12, 63);
		obj[39] = new HeartObject(blockHeartBlack1M1, "heartBlack1M1");
		
		Block blockHeartBlack2M1 = map.getBlock(12, 62);
		obj[40] = new HeartObject(blockHeartBlack2M1, "heartBlack2M1");
		
		Block blockHeartBlack3M1 = map.getBlock(12, 61);
		obj[41] = new HeartObject(blockHeartBlack3M1, "heartBlack3M1");
		
		Block blockHeartBlack4M1 = map.getBlock(12, 60);
		obj[42] = new HeartObject(blockHeartBlack4M1, "heartBlack4M1");
		
		Block blockHeartBlack5M1 = map.getBlock(12, 59);
		obj[43] = new HeartObject(blockHeartBlack5M1, "heartBlack5M1");
	}
	
	public ArrayList<ProjectileMonster> getProjectilesMons() {
		return projectilesMons;
	}

	public void setProjectilesMons(ArrayList<ProjectileMonster> projectiles) {
		this.projectilesMons = projectiles;
	}

	public ArrayList<ProjectileHero> getProjectilesHero() {
		return projectilesHero;
	}

	public void setProjectilesHero(ArrayList<ProjectileHero> projectilesHero) {
		this.projectilesHero = projectilesHero;
	}

	public void collisionTile() {
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
				
				if((map.getId() == 0 || map.getId() == 5 || map.getId() == 26 ||  map.getId() == 28 ||  map.getId() == 30 || 
						map.getId() == 31) 
						&& posPoint.getColumn() == x && posPoint.getLine() == y) {
					collisionOn = false;
				}
				
				if((map.getId() == 1 || map.getId() == 2 || map.getId() == 3 || map.getId() == 4 || map.getId() == 25 
						|| map.getId() == 20 || map.getId() == 21 || map.getId() == 24 || map.getId() == 27 || map.getId() == 26
						|| map.getId() == 29) && posPoint.getColumn() == x && posPoint.getLine() == y ) {
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
				if((posPoint.getColumn() <= 63 && posPoint.getColumn() >= 47) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map de combat minimonstre/gardien
						&& (x <= 63 && x >= 47) && (y <= 23 && y >= 12)) {
					collisionOn = true; // blocque le joueur dans la zone de combat
				}
				 
				if((posPoint.getColumn() <= 63 && posPoint.getColumn() >= 47) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map de combat boss
						&& (x <= 63 && x >= 47) && (y <= 35 && y >= 24)) {
					collisionOn = true;
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
		
		Block blockDoor1 = map.getBlock(4, 24);
		obj[3] = new DoorObject(blockDoor1, "Door1");
		
		Block blockDoor2 = map.getBlock(18, 43);
		obj[4] = new DoorObject(blockDoor2, "Door2");
		
		Block blockDoor3 = map.getBlock(31, 24);
		obj[5] = new DoorObject(blockDoor3, "Door3");
		
		Block blockCrystal1 = map.getBlock(2, 24);
		obj[6] = new CrystalObject(blockCrystal1, "Crystal1");
		
		Block blockCrystal2 = map.getBlock(18, 45);
		obj[7] = new CrystalObject(blockCrystal2, "Crystal2");
		
		Block blockCrystal3 = map.getBlock(33, 24);
		obj[8] = new CrystalObject(blockCrystal3, "Crystal3");
		
		Block blockUp1 = map.getBlock(5, 15);
		obj[9] = new BlockObject(blockUp1, "block1");
		
		Block blockDown1 = map.getBlock(6, 15);
		obj[10] = new BlockObject(blockDown1, "block1");
		
		Block blockUp2 = map.getBlock(5, 31);
		obj[11] = new BlockObject(blockUp2, "block2");
		
		Block blockDown2 = map.getBlock(6, 31);
		obj[12] = new BlockObject(blockDown2, "block2");
		
		Block blockLeft3 = map.getBlock(11, 39);
		obj[13] = new BlockObject(blockLeft3, "block3");
		
		Block blockRight3 = map.getBlock(11, 40);
		obj[14] = new BlockObject(blockRight3, "block3");
		
		Block blockLeft4 = map.getBlock(23, 39);
		obj[15] = new BlockObject(blockLeft4, "block4");
		
		Block blockRight4 = map.getBlock(23, 40);
		obj[16] = new BlockObject(blockRight4, "block4");
		
		Block blockUp5 = map.getBlock(29, 32);
		obj[17] = new BlockObject(blockUp5, "block5");
		
		Block blockDown5 = map.getBlock(30, 32);
		obj[18] = new BlockObject(blockDown5, "block5");
		
		Block blockUp6 = map.getBlock(29, 16);
		obj[19] = new BlockObject(blockUp6, "block6");
		
		Block blockDown6 = map.getBlock(30, 16);
		obj[20] = new BlockObject(blockDown6, "block6");
		
		Block blockLeft7 = map.getBlock(24, 7);
		obj[21] = new BlockObject(blockLeft7, "block7");
		
		Block blockRight7 = map.getBlock(24, 8);
		obj[22] = new BlockObject(blockRight7, "block7");
		
		Block blockUp8 = map.getBlock(17, 15);
		obj[23] = new BlockObject(blockUp8, "block8");
		
		Block blockDown8 = map.getBlock(18, 15);
		obj[24] = new BlockObject(blockDown8, "block8");
		
		Block blockPortail = map.getBlock(20, 25);
		obj[33] = new DoorObject(blockPortail, "portail");
		
		Block blockHeartRed1M1 = map.getBlock(12, 48);
		obj[34] = new HeartObject(blockHeartRed1M1, "heartRed1M1");
		
		Block blockHeartRed2M1 = map.getBlock(12, 49);
		obj[35] = new HeartObject(blockHeartRed2M1, "heartRed2M1");
		
		Block blockHeartRed3M1 = map.getBlock(12, 50);
		obj[36] = new HeartObject(blockHeartRed3M1, "heartRed3M1");
		
		Block blockHeartRed4M1 = map.getBlock(12, 51);
		obj[37] = new HeartObject(blockHeartRed4M1, "heartRed4M1");
		
		Block blockHeartRed5M1 = map.getBlock(12, 52);
		obj[38] = new HeartObject(blockHeartRed5M1, "heartRed5M1");
		
		Block blockHeartBlack1M1 = map.getBlock(12, 63);
		obj[39] = new HeartObject(blockHeartBlack1M1, "heartBlack1M1");
		
		Block blockHeartBlack2M1 = map.getBlock(12, 62);
		obj[40] = new HeartObject(blockHeartBlack2M1, "heartBlack2M1");
		
		Block blockHeartBlack3M1 = map.getBlock(12, 61);
		obj[41] = new HeartObject(blockHeartBlack3M1, "heartBlack3M1");
		
		Block blockHeartBlack4M1 = map.getBlock(12, 60);
		obj[42] = new HeartObject(blockHeartBlack4M1, "heartBlack4M1");
		
		Block blockHeartBlack5M1 = map.getBlock(12, 59);
		obj[43] = new HeartObject(blockHeartBlack5M1, "heartBlack5M1");
		
		Block blockCasque = map.getBlock(6, 60);
		obj[44] = new CasqueObject(blockCasque, "casque");
		
		Block blockTrident = map.getBlock(6, 51);
		obj[45] = new TridentObject(blockTrident, "trident");
		
		// Sert de marquage de fin pour le parcours du tableau obj
		obj[54] = new EmptyObject(blockCrystal3, "MarquageDeFin");
		
	}

	public void itemReward() {
		if(point.getHeWon() == true && point.getNameCurrentMonster() == "asura1") {
			Block blockKey1 = map.getBlock(9, 29);
			obj[0] = new KeyObject(blockKey1, "Key1");
		}

		if(point.getHeWon() == true && point.getNameCurrentMonster() == "asura2") {
			Block blockKey2 = map.getBlock(14, 36);
			obj[1] = new KeyObject(blockKey2, "Key2");
		}
		
		if(point.getHeWon() == true && point.getNameCurrentMonster() == "asura3") {
			Block blockKey3 = map.getBlock(26, 18);
			obj[2] = new KeyObject(blockKey3, "Key3");
		}
		
		if(point.getHeWon() == true && point.getNameCurrentMonster() == "miniMonster1") {
			Block blockStrength1 = map.getBlock(9, 12);
			obj[25] = new StrengthObject(blockStrength1, "strength1");
		}
		
		if(point.getHeWon() == true && point.getNameCurrentMonster() == "miniMonster2") {
			Block blockStrength2 = map.getBlock(9, 19);
			obj[26] = new StrengthObject(blockStrength2, "strength2");
		}
		
		if(point.getHeWon() == true && point.getNameCurrentMonster() == "miniMonster3") {
			Block blockStrength3 = map.getBlock(2, 35);
			obj[27] = new StrengthObject(blockStrength3, "strength3");
		}
		
		if(point.getHeWon() == true && point.getNameCurrentMonster() == "miniMonster4") {
			Block blockStrength4 = map.getBlock(20, 34);
			obj[28] = new StrengthObject(blockStrength4, "strength4");
		}
		
		if(point.getHeWon() == true && point.getNameCurrentMonster() == "miniMonster5") {
			Block blockStrength5 = map.getBlock(32, 44);
			obj[29] = new StrengthObject(blockStrength5, "strength5");
		}
		
		if(point.getHeWon() == true && point.getNameCurrentMonster() == "miniMonster6") {
			Block blockStrength6 = map.getBlock(26, 28);
			obj[30] = new StrengthObject(blockStrength6, "strength6");
		}
		
		if(point.getHeWon() == true && point.getNameCurrentMonster() == "miniMonster7") {
			Block blockStrength7 = map.getBlock(32, 3);
			obj[31] = new StrengthObject(blockStrength7, "strength7");
		}
		
		if(point.getHeWon() == true && point.getNameCurrentMonster() == "miniMonster8") {
			Block blockStrength8 = map.getBlock(14, 3);
			obj[32] = new StrengthObject(blockStrength8, "strength8");
		}
			
	}
	
	public void checkCollisionObject() {
		Block[][] blocks = map.getBlocks();
		MapBuilder m = new MapBuilder("src/maps/map.txt");
		
		Block posPoint = point.getPosition();
		
		int columnIndex = 0;
	    int lineIndex = 0;
	    
	    while(columnIndex < map.getColumnCount() && lineIndex < map.getLineCount()) {
	    	Block block = blocks[lineIndex][columnIndex];
			
	    	Iterator<Integer> iterator = m.getMapData().iterator(); // parcours l'arraylist
			while (iterator.hasNext()) {
				iterator.next();
				
				for(int i=0; i < obj.length; i++) {
					
					 if(obj[i] != null) {
						 
						Block posObj = obj[i].getPosition();
						int xObj = posObj.getColumn();
						int yObj = posObj.getLine();
					
						if((obj[i].getName() == "Key1" || obj[i].getName() == "Key2" || obj[i].getName() == "Key3") 
								&& posPoint.getColumn() == xObj && posPoint.getLine() == yObj && time > 0) {
							
							time--;
							obj[i] = null;
							hasKey++;
							System.out.println("Key:"+hasKey);
							i = 0;
							while(obj[i] == null) { // pour gerer lerreur NullPointerException
								i++; // tant que l'obj courant est null on passe a lobjet suivant
							}
						}
						if((obj[i].getName() == "Crystal1" || obj[i].getName() == "Crystal2" || obj[i].getName() == "Crystal3")
								&& posPoint.getColumn() == xObj && posPoint.getLine() == yObj) {
							
							obj[i] = null;
							hasCrystal++;
							i=0;
							System.out.println("Crystal:"+hasCrystal);
							while(obj[i] == null) {
								i++;
							}
						}
						if((obj[i].getName() == "Door1" || obj[i].getName() == "Door2" || obj[i].getName() == "Door3")  
								&& posPoint.getColumn() == xObj && posPoint.getLine() == yObj) {
							
							if(hasKey > 0 && collisionOn == true) {
								obj[i] = null;
								hasKey--;
								i = 0;
								System.out.println("Key:"+hasKey);
								while(obj[i] == null) {
									i++;
								}
							}
							
							if(point.getRightPressed() == true ) {
								collisionOn = true;
								Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 1);
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
						if((obj[i].getName() == "strength1" || obj[i].getName() == "strength2" || obj[i].getName() == "strength3"
								|| obj[i].getName() == "strength4"  || obj[i].getName() == "strength5" || obj[i].getName() == "strength6"
								|| obj[i].getName() == "strength7" || obj[i].getName() == "strength8") 
								&& posPoint.getColumn() == xObj && posPoint.getLine() == yObj && time > 0) {
							
							time--;
							obj[i] = null;
							hasStrength++;
							System.out.println("strength:"+hasStrength);
							i = 0;
							while(obj[i] == null) { 
								i++; 
							}
						}
						if((obj[i].getName() == "portail")  
								&& posPoint.getColumn() == xObj && posPoint.getLine() == yObj) {
							
							if(hasCrystal == 3 && collisionOn == true) {
								obj[i] = null;
								i = 0;
								System.out.println("Crystal:"+hasCrystal);
								while(obj[i] == null) {
									i++;
								}
							}
							
							if(point.getUpPressed() == true)  {
								collisionOn = true;
								Block newPosi = map.getBlock(posPoint.getLine() + 1, posPoint.getColumn());
								point.setPosition(newPosi);
							}
						}
						if((obj[i].getName() == "block1" || obj[i].getName() == "block2" || obj[i].getName() == "block3"
								|| obj[i].getName() == "block4" || obj[i].getName() == "block5" || obj[i].getName() == "block6" 
								|| obj[i].getName() == "block7" || obj[i].getName() == "block8")  
								&& posPoint.getColumn() == xObj && posPoint.getLine() == yObj) {
							
							if (obj[i].getName() == "block8" && hasStrength > 0 && collisionOn == true) {
								obj[23] = null;
								obj[24] = null;
								hasStrength--;
								i = 0;
								System.out.println("strength:"+hasStrength);
								while(obj[i] == null) {
									i++;
								}
							}
							
							if(hasStrength > 0 && collisionOn == true && obj[i].getName() != "block8") {
								
								if(obj[i].getName() == obj[i+1].getName()) {
									obj[i] = null;
									obj[i+1] = null;
								} else {
									obj[i] = null;
									obj[i-1] = null;
								}	
								hasStrength--;
								i = 0;
								System.out.println("strength:"+hasStrength);
								while(obj[i] == null) {
									i++;
								}
							}
							
							if(point.getRightPressed() == true ) {
								collisionOn = true;
								Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 1);
								point.setPosition(newPosi);
							}
							
							if(point.getLeftPressed() == true ) {
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
						if((obj[i].getName() == "casque")  
								&& posPoint.getColumn() == xObj && posPoint.getLine() == yObj) {
							
							if(nbrOr >= 500 && collisionOn == true) {
								dialogueNpc = "";
								nbrOr -= 500;
								hasCasque = true;
								obj[i] = null;
								i = 0;
								System.out.println("possede le casque");
								while(obj[i] == null) {
									i++;
								}
							}
							
							if(point.getRightPressed() == true ) {
								collisionOn = true;
								casqueTouched = true;
								npcDialogueActived = true;
								int reste = achatCasqueFail();
								if(reste != 0) {
									dialogueNpc = "Or insuffisant... il vous manque encore "+achatCasqueFail()+" pièces d'or pour l'acheter";
								}
								Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 1);
								point.setPosition(newPosi);
							}
							
							if(point.getUpPressed() == true)  {
								collisionOn = true;
								casqueTouched = true;
								npcDialogueActived = true;
								int reste = achatCasqueFail();
								if(reste != 0) {
									dialogueNpc = "Or insuffisant... il vous manque encore "+achatCasqueFail()+" pièces d'or pour l'acheter";
								}
								Block newPosi = map.getBlock(posPoint.getLine() + 1, posPoint.getColumn());
								point.setPosition(newPosi);
							}
							
							if(point.getDownPressed() == true)  {
								collisionOn = true;
								casqueTouched = true;
								npcDialogueActived = true;
								int reste = achatCasqueFail();
								if(reste != 0) {
									dialogueNpc = "Or insuffisant... il vous manque encore "+achatCasqueFail()+" pièces d'or pour l'acheter";
								}
								Block newPosi = map.getBlock(posPoint.getLine() - 1, posPoint.getColumn());
								point.setPosition(newPosi);
							}
						}
						if((obj[i].getName() == "trident")  
								&& posPoint.getColumn() == xObj && posPoint.getLine() == yObj) {
							
							if(nbrOr >= 150 && collisionOn == true) {
								dialogueNpc = "";
								nbrOr -= 150;
								hasTrident = true;
								obj[i] = null;
								i = 0;
								System.out.println("possede le trident");
								while(obj[i] == null) {
									i++;
								}
							}
							
							if(point.getLeftPressed() == true ) {
								collisionOn = true;
								tridentTouched = true;
								npcDialogueActived = true;
								int reste = achatTridentFail();
								if(reste != 0) {
									dialogueNpc = "Or insuffisant... il vous manque encore "+achatTridentFail()+" pièces d'or pour l'acheter";
								}
								
								Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 1);
								point.setPosition(newPosi);
							}
							
							if(point.getUpPressed() == true)  {
								collisionOn = true;
								tridentTouched = true;
								npcDialogueActived = true;
								int reste = achatTridentFail();
								if(reste != 0) {
									dialogueNpc = "Or insuffisant... il vous manque encore "+achatTridentFail()+" pièces d'or pour l'acheter";
								}
								Block newPosi = map.getBlock(posPoint.getLine() + 1, posPoint.getColumn());
								point.setPosition(newPosi);
							}
							
							if(point.getDownPressed() == true)  {
								collisionOn = true;
								tridentTouched = true;
								npcDialogueActived = true;
								int reste = achatTridentFail();
								if(reste != 0) {
									dialogueNpc = "Or insuffisant... il vous manque encore "+achatTridentFail()+" pièces d'or pour l'acheter";
								}
								Block newPosi = map.getBlock(posPoint.getLine() - 1, posPoint.getColumn());
								point.setPosition(newPosi);
							}
						}
					}
				}
					columnIndex++;
					if(columnIndex == map.getColumnCount()) {
						columnIndex = 0;
						lineIndex++;
					}
				}
			}
	}
	
	public int achatTridentFail() {
		int res = 0;
		if(tridentTouched == true && hasTrident == false) {
			res = 150 - nbrOr;
		}
		return res;	
	}
	
	public int achatCasqueFail() {
		int res = 0;
		if(casqueTouched == true && hasCasque == false) {
			res = 500 - nbrOr;
		}
		return res;	
	}
	
	public void setMonsters() {
		Block gardien1 = map.getBlock(9, 29);
		Monster asura1 = new Monster(gardien1, "asura1");
		monsters.add(asura1);
		
		Block gardien2 = map.getBlock(14, 36);
		Monster asura2 = new Monster(gardien2, "asura2");
		monsters.add(asura2);
		
		Block gardien3 = map.getBlock(26, 18);
		Monster asura3 = new Monster(gardien3, "asura3");
		monsters.add(asura3);
		
		Block miniMonstre1 = map.getBlock(9, 12);
		Monster enemy1 = new Monster(miniMonstre1, "miniMonster1");
		monsters.add(enemy1);
		
		Block miniMonstre2 = map.getBlock(9, 19);
		Monster enemy2 = new Monster(miniMonstre2, "miniMonster2");
		monsters.add(enemy2);
		
		Block miniMonstre3 = map.getBlock(2, 35);
		Monster enemy3 = new Monster(miniMonstre3, "miniMonster3");
		monsters.add(enemy3);
		
		Block miniMonstre4 = map.getBlock(20, 34);
		Monster enemy4 = new Monster(miniMonstre4, "miniMonster4");
		monsters.add(enemy4);
		
		Block miniMonstre5 = map.getBlock(32, 44);
		Monster enemy5 = new Monster(miniMonstre5, "miniMonster5");
		monsters.add(enemy5);
		
		Block miniMonstre6 = map.getBlock(26, 28);
		Monster enemy6 = new Monster(miniMonstre6, "miniMonster6");
		monsters.add(enemy6);
		
		Block miniMonstre7 = map.getBlock(32, 3);
		Monster enemy7 = new Monster(miniMonstre7, "miniMonster7");
		monsters.add(enemy7);
		
		Block miniMonstre8 = map.getBlock(14, 3);
		Monster enemy8 = new Monster(miniMonstre8, "miniMonster8");
		monsters.add(enemy8);
		
		Block bossFinal = map.getBlock(17, 25);
		Monster boss = new Monster(bossFinal, "boss");
		monsters.add(boss);
		
		Block empty = map.getBlock(0, 0);
		Monster emptyMonster = new Monster(empty, "marquageDeFin");
		monsters.add(emptyMonster);
	}
	
	public void collisionMonster() {
		Block posPoint = point.getPosition();
		
		for(int i=0; i < monsters.getMonsters().length; i++) {
			
				if(monsters.currentMonster(i) != null) {
				
						Block posMons = monsters.currentMonster(i).getPosition();
						int xM = posMons.getColumn();
						int yM = posMons.getLine();
					
						if(posPoint.getColumn() == xM && posPoint.getLine() == yM) {
							collisionMonsterOn = true;
							point.setNameCurrentMonster(monsters.currentMonster(i).getName());
							point.setCollisionMons(true);
							point.setDead(false);
							point.setHeWon(false);
							System.out.println("TOUCHER");
							Block newPosi = map.getBlock(6, 11); // change la position du monstre vers la partie visible
							monsters.currentMonster(i).setPosition(newPosi);
						
						}
				}	
		}
	}

	public void setNpcs() {
		Block npc1 = map.getBlock(3, 53);
		Npc nonChar1 = new Npc(npc1, "npc1");
		nonChar1.setDialogue("L'arme de gauche, aussi appelé <<Trishula>>,"
				+ " le trident Sutra, permet d'enlever 2 point de vie instantanément à l'énemie"
				+ " et peut être utiliser 2 fois lors d'un combat. Nous vous le proposons à 150 pièces d'Or.");
		npcs.add(nonChar1);
		
		Block npc2 = map.getBlock(3, 58);
		Npc nonChar2 = new Npc(npc2, "npc2");
		nonChar2.setDialogue("L'arme de droite, aussi appelé <<ushnisha>> la courronne de Bouddha, elle permet d'ajouter 2 point de vie au joueur"
				+ " l'orsque ce dernier est en dessous de 3 point de vie et peut être utiliser 1 seule fois lors d'un combat. Nous vous le proposons à 500 pièces d'Or.");
		npcs.add(nonChar2);
		
		Block npc3 = map.getBlock(3, 12);
		Npc nonChar3 = new Npc(npc3, "npc3");
		nonChar3.setDialogue("Battez le monstre pour acquérir de la puissance et passer de l'autre côté.");
		npcs.add(nonChar3);
		
		Block npc4 = map.getBlock(8, 44);
		Npc nonChar4 = new Npc(npc4, "npc4");
		nonChar4.setDialogue("Atteignez le niveau 5 pour débloquer un sort magique !");
		npcs.add(nonChar4);
		
		Block npc5 = map.getBlock(26, 35);
		Npc nonChar5 = new Npc(npc5, "npc5");
		nonChar5.setDialogue("N'hesitez pas a retourner au magasin lorsque vous avez assez d'or,"
				+ " il y a des armes précieuses qui vont sûrement vous plaire.");
		npcs.add(nonChar5);
		
		Block npc6 = map.getBlock(14, 19);
		Npc nonChar6 = new Npc(npc6, "npc6");
		nonChar6.setDialogue("Récolter un total de 3 cristaux pour ouvrir ce portail.");
		npcs.add(nonChar6);
		
		Block npc7 = map.getBlock(4, 19);
		Npc nonChar7 = new Npc(npc7, "npc7");
		nonChar7.setDialogue("Allez visiter notre magasin qui se trouve dans la zone précédente, des armes précieuses vous attendent.");
		npcs.add(nonChar7);
		
		
	}
	
	public void collisionNpc() {
		Block posPoint = point.getPosition();
		
		for(int i=0; i < npcs.getNpc().length; i++) {
			
				if(npcs.currentNpc(i) != null) {
				
						Block posNpc = npcs.currentNpc(i).getPosition();
						int xN = posNpc.getColumn();
						int yN = posNpc.getLine();
					
						if(posPoint.getColumn() == xN && posPoint.getLine() == yN) {
							
							if(point.getRightPressed() == true ) {
								collisionOn = true;
								npcDialogueActived = true;
								dialogueNpc = npcs.currentNpc(i).getDialogue();
								Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() - 1);
								point.setPosition(newPosi);
							}
							
							if(point.getLeftPressed() == true ) {
								collisionOn = true;
								npcDialogueActived = true;
								dialogueNpc = npcs.currentNpc(i).getDialogue();
								Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 1);
								point.setPosition(newPosi);
							}
							
							if(point.getUpPressed() == true)  {
								collisionOn = true;
								npcDialogueActived = true;
								dialogueNpc = npcs.currentNpc(i).getDialogue();
								Block newPosi = map.getBlock(posPoint.getLine() + 1, posPoint.getColumn());
								point.setPosition(newPosi);
							}
							
							if(point.getDownPressed() == true)  {
								collisionOn = true;
								npcDialogueActived = true;
								dialogueNpc = npcs.currentNpc(i).getDialogue();
								Block newPosi = map.getBlock(posPoint.getLine() - 1, posPoint.getColumn());
								point.setPosition(newPosi);
							}
					}
					
					if(collisionOn == false) {
						npcDialogueActived = false;
					}
			}	
		}
	}
	
	public int getHasKey() {
		return hasKey;
	}

	public void setHasKey(int hasKey) {
		this.hasKey = hasKey;
	}

	public int getHasBlueKey() {
		return hasStrength;
	}

	public void setHasBlueKey(int hasBlueKey) {
		this.hasStrength = hasBlueKey;
	}

	public SuperObject[] getObj() {
		return obj;
	}

	public void setObj(SuperObject[] obj) {
		this.obj = obj;
	}
	
	public Monsters getMonsters() {
		return monsters;
	}

	public void setMonsters(Monsters monsters) {
		this.monsters = monsters;
	}
	
	public boolean getCollisionMonsterOn() {
		return collisionMonsterOn;
	}

	public void setCollisionMonsterOn(boolean collisionMonsterOn) {
		this.collisionMonsterOn = collisionMonsterOn;
	}

	public boolean getMaskButton1() {
		return maskButton1;
	}

	public void setMaskButton1(boolean maskButton1) {
		this.maskButton1 = maskButton1;
	}

	public boolean getPlayerTouched() {
		return playerTouched;
	}

	public void setPlayerTouched(boolean playerTouched) {
		this.playerTouched = playerTouched;
	}

	public int getChoiceNum() {
		return choiceNum;
	}

	public void setChoiceNum(int choiceNum) {
		this.choiceNum = choiceNum;
	}

	public int getUseCasque() {
		return useCasque;
	}

	public void setUseCasque(int useCasque) {
		this.useCasque = useCasque;
	}

	public int getUseTrident() {
		return useTrident;
	}

	public void setUseTrident(int useTrident) {
		this.useTrident = useTrident;
	}

	public boolean getChoiceSelected() {
		return choiceSelected;
	}

	public void setChoiceSelected(boolean choiceSelected) {
		this.choiceSelected = choiceSelected;
	}

	public boolean getCasqueSelected() {
		return casqueSelected;
	}

	public void setCasqueSelected(boolean casqueSelected) {
		this.casqueSelected = casqueSelected;
	}

	public boolean getCanUseCasque() {
		return canUseCasque;
	}

	public void setCanUseCasque(boolean canUseCasque) {
		this.canUseCasque = canUseCasque;
	}

	public int getHasCrystal() {
		return hasCrystal;
	}

	public int getBossDefeated() {
		return bossDefeated;
	}

	public int getMiniMonsterDefeated() {
		return miniMonsterDefeated;
	}

	public int getGardienDefeated() {
		return gardienDefeated;
	}

	public int getExpCourant() {
		return expCourant;
	}

	public int getExpMaximum() {
		return expMaximum;
	}

	public int getNiveau() {
		return niveau;
	}

	public int getMaxLvlReached() {
		return maxLvlReached;
	}

	public ArrayList<ProjectileFeu> getProjectilesFeu() {
		return projectilesFeu;
	}

	public int getUseFeu() {
		return useFeu;
	}

	public boolean getMaskButton5() {
		return maskButton5;
	}

	public void setMaskButton5(boolean maskButton5) {
		this.maskButton5 = maskButton5;
	}

	public int getNbrOr() {
		return nbrOr;
	}

	public boolean getCasqueTouched() {
		return casqueTouched;
	}

	public boolean getTridentTouched() {
		return tridentTouched;
	}

	public boolean getHasCasque() {
		return hasCasque;
	}

	public boolean getHasTrident() {
		return hasTrident;
	}

	public Npcs getNpcs() {
		return npcs;
	}

	public String getDialogueNpc() {
		return dialogueNpc;
	}

	public void setDialogueNpc(String dialogueNpc) {
		this.dialogueNpc = dialogueNpc;
	}

	public boolean getNpcDialogueActived() {
		return npcDialogueActived;
	}

	
	
	
}
