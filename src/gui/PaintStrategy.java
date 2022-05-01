package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Iterator;

import configuration.GameConfiguration;
import motor.map.Block;
import motor.map.BlockManager;
import motor.map.Map;
import motor.map.MapBuilder;
import motor.map.Tile;
import motor.mobile.Joueur;
import motor.mobile.JoueurFictif;
import motor.mobile.Monsters;
import motor.mobile.MonstersImagesTab;
import motor.mobile.Npcs;
import motor.mobile.NpcsImagesTab;
import motor.mobile.ProjectileFeu;
import motor.mobile.ProjectileHero;
import motor.mobile.ProjectileMonster;
import motor.objects.ObjectsImagesTab;
import motor.objects.SuperObject;


/**
 * 
 * @author D.JB E.SRI Z.VIC
 *
 */
public class PaintStrategy {
	
	
	
	public void paint(Map map, Joueur p, JoueurFictif point, Graphics2D g2) {
		Block[][] blocks = map.getBlocks();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		MapBuilder m = new MapBuilder("src/maps/map.txt");

		Block position = p.getPosition();
		Block posPoint = point.getPosition();

		Tile tiles = new Tile(55);                  // tableau de 50 images contenant les differents types de blocks
	    Image img1 = BlockManager.readImage("src/tiles/grass.png");
	    tiles.add(img1);
	    Image img2 = BlockManager.readImage("src/tiles/tree.png");
	    tiles.add(img2);
	    Image img3 = BlockManager.readImage("src/tiles/flame.png");
	    tiles.add(img3);
	    Image img4 = BlockManager.readImage("src/tiles/lava.png");
	    tiles.add(img4);
	    Image img5 = BlockManager.readImage("src/tiles/wall.png");
	    tiles.add(img5);
	    Image img6 = BlockManager.readImage("src/tiles/wood.png");
	    tiles.add(img6);
	    
	    // SHOP
	    Image img7 = BlockManager.readImage("src/shop/p1.png");
	    tiles.add(img7);
	    Image img8 = BlockManager.readImage("src/shop/p2.png");
	    tiles.add(img8);
	    Image img9 = BlockManager.readImage("src/shop/p3.png");
	    tiles.add(img9);
	    Image img10 = BlockManager.readImage("src/shop/p4.png");
	    tiles.add(img10);
	    Image img11 = BlockManager.readImage("src/shop/p5.png");
	    tiles.add(img11);
	    Image img12 = BlockManager.readImage("src/shop/p6.png");
	    tiles.add(img12);
	    Image img13 = BlockManager.readImage("src/shop/p7.png");
	    tiles.add(img13);
	    Image img14 = BlockManager.readImage("src/shop/p8.png");
	    tiles.add(img14);
	    Image img15 = BlockManager.readImage("src/shop/p9.png");
	    tiles.add(img15);
	    Image img16 = BlockManager.readImage("src/shop/p10.png");
	    tiles.add(img16);
	    Image img17 = BlockManager.readImage("src/shop/p11.png");
	    tiles.add(img17);
	    Image img18 = BlockManager.readImage("src/shop/p12.png");
	    tiles.add(img18);
	    Image img19 = BlockManager.readImage("src/shop/p13.png");
	    tiles.add(img19);
	    Image img20 = BlockManager.readImage("src/shop/p14.png");
	    tiles.add(img20);
	    Image img21 = BlockManager.readImage("src/shop/p15.png");
	    tiles.add(img21);
	    Image img22 = BlockManager.readImage("src/shop/p16.png");
	    tiles.add(img22);
	    Image img23 = BlockManager.readImage("src/shop/p17.png");
	    tiles.add(img23);
	    Image img24 = BlockManager.readImage("src/shop/p18.png");
	    tiles.add(img24);
	    Image img25 = BlockManager.readImage("src/shop/p19.png");
	    tiles.add(img25);
	    Image img26 = BlockManager.readImage("src/shop/p20.png");
	    tiles.add(img26);
	    
	    Image img27 = BlockManager.readImage("src/tiles/black.png");
	    tiles.add(img27);
	    Image img28 = BlockManager.readImage("src/tiles/flame2.png");
	    tiles.add(img28);
	    Image img29 = BlockManager.readImage("src/tiles/wood2.png");
	    tiles.add(img29);
	    Image img30 = BlockManager.readImage("src/tiles/wall2.png");
	    tiles.add(img30);
	    Image img31 = BlockManager.readImage("src/tiles/wood3.png");
	    tiles.add(img31);
	    Image img32 = BlockManager.readImage("src/tiles/support.png");
	    tiles.add(img32);
	   

	    int columnIndex = 0;
	    int lineIndex = 0;
	    
	    while(columnIndex < map.getColumnCount() && lineIndex < map.getLineCount()) {
	    	Block block = blocks[lineIndex][columnIndex];

	    	int x = block.getColumn();
	    	int y = block.getLine();

			Iterator<Integer> iterator = m.getMapData().iterator(); // parcours l'arraylist
			while (iterator.hasNext()) {
				Integer currentId = iterator.next();
				
				map.getBlock(lineIndex, columnIndex, currentId);
				
				g2.drawImage(tiles.currentImage(currentId), x * blockSize, y * blockSize, blockSize, blockSize, null); // par default notre map en entier	
				
				if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 1
					&& (x <= 15 && x >= 0) && (y <= 11 && y >= 0)) {
					g2.drawImage(tiles.currentImage(currentId), x * blockSize, y * blockSize, blockSize, blockSize, null); // le currentId correspondant a l'indice du type de block du tableau d'img (tiles)
					if(posPoint.getColumn() == 15) { // si le joueur touche le bord droit de lecran
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 14); // on fait en sorte que notre joueur a nous reste dans la partie visible de lecran
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 2);
						point.setPosition(newPosi);
					}
					if(posPoint.getColumn() == 0) { // si le joueur fictif touche le bord gauche de la zone ou il se trouve
						Block newPos = map.getBlock(position.getLine(), position.getColumn() + 1);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine(), posPoint.getColumn() + 1);
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 11) { // si le joueur fictif touche le bord bas de la zone ou il se trouve
						Block newPos = map.getBlock(position.getLine() - 10, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() + 2, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if(posPoint.getLine() == 0) { // si le joueur ficitif touche le bord haut de la zone ou il se trouve
						Block newPos = map.getBlock(position.getLine() + 1, position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(posPoint.getLine() + 1, posPoint.getColumn());
						point.setPosition(newPosi);
					}
					if((posPoint.getColumn() == 4 && posPoint.getLine() == 4)) { // si le joueur entre dans le magazin
						Block newPos = map.getBlock(position.getLine() + 6 , position.getColumn() + 4);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(10, 56);
						point.setPosition(newPosi);
					}
					if((posPoint.getColumn() == 3 && posPoint.getLine() == 4)) { //idem
						Block newPos = map.getBlock(position.getLine() + 6 , position.getColumn() + 4);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(10, 55);
						point.setPosition(newPosi);
					}
					if((point.getCollisionMons() == true && point.getIsDead() == false && point.getHeWon() == false)) { // si le joueur touche le monstre
						Block newPos = map.getBlock(position.getLine() - 3 , position.getColumn() - 8);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(18, 52); // le joueur fictif se retrouve dans la zone de combat
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 2
					&& (x <= 31 && x >= 16) && (y <= 11 && y >= 0)) {
					g2.drawImage(tiles.currentImage(currentId), (x * blockSize) - (16 * blockSize), y * blockSize, blockSize, blockSize, null); // on décale la zone vers la partie visible
					
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
					if((point.getCollisionMons() == true && point.getIsDead() == false && point.getHeWon() == false && point.getNameCurrentMonster() == "asura1")) { // si le joueur touche le monstre
						Block newPos = map.getBlock(position.getLine() - 3 , position.getColumn() - 9);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(18, 52); // le joueur fictif se retrouve dans la zone de combat
						point.setPosition(newPosi);
					}
					if((point.getCollisionMons() == true && point.getIsDead() == false && point.getHeWon() == false && point.getNameCurrentMonster() == "miniMonster2")) {
						Block newPos = map.getBlock(position.getLine() - 3 , position.getColumn() + 1);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(18, 52); // le joueur fictif se retrouve dans la zone de combat
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 3
					&& (x <= 47 && x >= 32) && (y <= 11 && y >= 0)) {
					g2.drawImage(tiles.currentImage(currentId), (x * blockSize) - (32 * blockSize), y * blockSize, blockSize, blockSize, null);
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
					if((point.getCollisionMons() == true && point.getIsDead() == false && point.getHeWon() == false && point.getNameCurrentMonster() == "miniMonster3")) { // si le joueur touche le monstre
						Block newPos = map.getBlock(position.getLine() + 4 , position.getColumn() + 1);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(18, 52); // le joueur fictif se retrouve dans la zone de combat
						point.setPosition(newPosi);
					}
					
				}
				if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 4
					&& (x <= 15 && x >= 0) && (y <= 23 && y >= 12)) {
					g2.drawImage(tiles.currentImage(currentId), x * blockSize, (y * blockSize) - (12 * blockSize), blockSize, blockSize, null);
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
					if(point.getCollisionMons() == true && point.getIsDead() == false && point.getHeWon() == false) { // si le joueur touche le monstre
						Block newPos = map.getBlock(position.getLine() + 4 , position.getColumn() + 1);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(18, 52); // le joueur fictif se retrouve dans la zone de combat
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 5
					&& (x <= 31 && x >= 16) && (y <= 23 && y >= 12)) {
					g2.drawImage(tiles.currentImage(currentId), (x * blockSize) - (16 * blockSize), (y * blockSize) - (12 * blockSize), blockSize, blockSize, null);
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
					if(point.getCollisionMons() == true && point.getIsDead() == false && point.getHeWon() == false) { // si le joueur touche le monstre
						Block newPos = map.getBlock(position.getLine() + 1, position.getColumn() - 5);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(30, 52); // le joueur fictif se retrouve dans la zone de combat
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 6
					&& (x <= 47 && x >= 32) && (y <= 23 && y >= 12)) {
					g2.drawImage(tiles.currentImage(currentId), (x * blockSize) - (32 * blockSize), (y * blockSize) - (12 * blockSize), blockSize, blockSize, null);
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
					if((point.getCollisionMons() == true && point.getIsDead() == false && point.getHeWon() == false)) { // si le joueur touche le monstre
						Block newPos = map.getBlock(position.getLine() + 4 , position.getColumn());
						p.setPosition(newPos);
						Block newPosi = map.getBlock(18, 52); // le joueur fictif se retrouve dans la zone de combat
						point.setPosition(newPosi);
					}
					if((point.getCollisionMons() == true && point.getIsDead() == false && point.getHeWon() == false && point.getNameCurrentMonster() == "miniMonster4")) { // si le joueur touche le monstre
						Block newPos = map.getBlock(position.getLine() - 2 , position.getColumn() + 2);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(18, 52); // le joueur fictif se retrouve dans la zone de combat
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 7
					&& (x <= 15 && x >= 0) && (y <= 35 && y >= 24)) {
					g2.drawImage(tiles.currentImage(currentId), x * blockSize, (y * blockSize) - (24 * blockSize), blockSize, blockSize, null);
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
					if(point.getCollisionMons() == true && point.getIsDead() == false && point.getHeWon() == false) { // si le joueur touche le monstre
						Block newPos = map.getBlock(position.getLine() - 2 , position.getColumn() + 1);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(18, 52); // le joueur fictif se retrouve dans la zone de combat
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 8
					&& (x <= 31 && x >= 16) && (y <= 35 && y >= 24)) {
					g2.drawImage(tiles.currentImage(currentId), (x * blockSize) - (16 * blockSize), (y * blockSize) - (24 * blockSize), blockSize, blockSize, null);
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
					if((point.getCollisionMons() == true && point.getIsDead() == false && point.getHeWon() == false && point.getNameCurrentMonster() == "asura3")) { // si le joueur touche le monstre
						Block newPos = map.getBlock(position.getLine() + 4, position.getColumn() + 2);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(18, 52); // le joueur fictif se retrouve dans la zone de combat
						point.setPosition(newPosi);
					}
					if((point.getCollisionMons() == true && point.getIsDead() == false && point.getHeWon() == false && point.getNameCurrentMonster() == "miniMonster6")) { // si le joueur touche le monstre
						Block newPos = map.getBlock(position.getLine() + 4, position.getColumn() - 8);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(18, 52); // le joueur fictif se retrouve dans la zone de combat
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 9
					&& (x <= 47 && x >= 32) && (y <= 35 && y >= 24)) {
					g2.drawImage(tiles.currentImage(currentId), (x * blockSize) - (32 * blockSize), (y * blockSize) - (24 * blockSize), blockSize, blockSize, null);
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
					if((point.getCollisionMons() == true && point.getIsDead() == false && point.getHeWon() == false)) { // si le joueur touche le monstre
						Block newPos = map.getBlock(position.getLine() - 2, position.getColumn() - 8);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(18, 52); // le joueur fictif se retrouve dans la zone de combat
						point.setPosition(newPosi);
					}
					
				}
				if((posPoint.getColumn() <= 63 && posPoint.getColumn() >= 47) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // shop
						&& (x <= 63 && x >= 47) && (y <= 11 && y >= 0)) {
					g2.drawImage(tiles.currentImage(currentId), (x * blockSize) - (48 * blockSize), y * blockSize, blockSize, blockSize, null);	
					if(posPoint.getLine() == 11) {
						Block newPos = map.getBlock(5, 4);
						p.setPosition(newPos);
						Block newPosi = map.getBlock(5, 4);
						point.setPosition(newPosi);
					}
				}
				if((posPoint.getColumn() <= 63 && posPoint.getColumn() >= 47) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map de combat minimonstre/gardien
						&& (x <= 63 && x >= 47) && (y <= 23 && y >= 12)) {
					g2.drawImage(tiles.currentImage(currentId), (x * blockSize) - (48 * blockSize), (y * blockSize) - (12 * blockSize), blockSize, blockSize, null);
					
					p.setDirection("right");
					p.setSpriteNum(2);
					
					if((point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) && point.getNameCurrentMonster() == "miniMonster1") { // Renitialisation des joueurs dans la map1
						p.setDirection("down");
						Block newPosi = map.getBlock(posPoint.getLine() - 16, posPoint.getColumn() - 43); 
						point.setPosition(newPosi);
						Block newPos = map.getBlock(position.getLine() - 4, position.getColumn() + 5);
						p.setPosition(newPos);
					}
					
					if((point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) && point.getNameCurrentMonster() == "asura1") { // Renitialisation des joueurs dans la map2
						Block newPosi = map.getBlock(posPoint.getLine() - 12, posPoint.getColumn() - 34); 
						point.setPosition(newPosi);
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 2);
						p.setPosition(newPos);
					}
					if((point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) && point.getNameCurrentMonster() == "miniMonster2") { 
						Block newPosi = map.getBlock(posPoint.getLine() - 12, posPoint.getColumn() - 34); 
						point.setPosition(newPosi);
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 2);
						p.setPosition(newPos);
					}
					
					if((point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) && point.getNameCurrentMonster() == "miniMonster3") {  // Renitialisation des joueurs dans la map3
						Block newPosi = map.getBlock(posPoint.getLine() - 12, posPoint.getColumn() - 19); 
						point.setPosition(newPosi);
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 3);
						p.setPosition(newPos);
					}
					
					if((point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) && point.getNameCurrentMonster() == "miniMonster8") {  // Renitialisation des joueurs dans la map4
						p.setDirection("up");
						Block newPosi = map.getBlock(posPoint.getLine() + 4, posPoint.getColumn() - 45); 
						point.setPosition(newPosi);
						Block newPos = map.getBlock(position.getLine() + 4, position.getColumn() + 3);
						p.setPosition(newPos);
					}
					
					
					if((point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) && point.getNameCurrentMonster() == "asura2") { // Renitialisation des joueurs dans la map6
						p.setDirection("down");
						Block newPosi = map.getBlock(posPoint.getLine() - 5, posPoint.getColumn() - 12); 
						point.setPosition(newPosi);
						Block newPos = map.getBlock(position.getLine() - 5, position.getColumn() + 4);
						p.setPosition(newPos);
					}
					if((point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) && point.getNameCurrentMonster() == "miniMonster4") { 
						p.setDirection("down");
						Block newPosi = map.getBlock(posPoint.getLine() - 5, posPoint.getColumn() - 12); 
						point.setPosition(newPosi);
						Block newPos = map.getBlock(position.getLine() - 5, position.getColumn() + 4);
						p.setPosition(newPos);
					}
					
					if((point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) && point.getNameCurrentMonster() == "miniMonster7") { // Renitialisation des joueurs dans la map7
						p.setDirection("left");
						Block newPosi = map.getBlock(posPoint.getLine() + 11, posPoint.getColumn() - 38); 
						point.setPosition(newPosi);
						Block newPos = map.getBlock(position.getLine() - 1, position.getColumn() + 10);
						p.setPosition(newPos);
					}
					
					if((point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) && point.getNameCurrentMonster() == "asura3") { // Renitialisation des joueurs dans la map8
						p.setDirection("left");
						Block newPosi = map.getBlock(posPoint.getLine() + 11, posPoint.getColumn() - 22); 
						point.setPosition(newPosi);
						Block newPos = map.getBlock(position.getLine() - 1, position.getColumn() + 10);
						p.setPosition(newPos);
					}
					if((point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) && point.getNameCurrentMonster() == "miniMonster6") { 
						p.setDirection("left");
						Block newPosi = map.getBlock(posPoint.getLine() + 11, posPoint.getColumn() - 22); 
						point.setPosition(newPosi);
						Block newPos = map.getBlock(position.getLine() - 1, position.getColumn() + 10);
						p.setPosition(newPos);
					}
					if((point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) && point.getNameCurrentMonster() == "miniMonster5") { // Renitialisation des joueurs dans la map9
						p.setDirection("down");
						Block newPosi = map.getBlock(posPoint.getLine() + 7, posPoint.getColumn() - 13); 
						point.setPosition(newPosi);
						Block newPos = map.getBlock(position.getLine() - 5, position.getColumn() + 3);
						p.setPosition(newPos);
					}
				}
				if((posPoint.getColumn() <= 63 && posPoint.getColumn() >= 47) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map de combat boss
						&& (x <= 63 && x >= 47) && (y <= 35 && y >= 24)) {
					g2.drawImage(tiles.currentImage(currentId), (x * blockSize) - (48 * blockSize), (y * blockSize) - (24 * blockSize) , blockSize, blockSize, null);
					
					p.setDirection("right");
					p.setSpriteNum(2);
					
				
					if((point.getQuitPressed() == true || point.getIsDead() == true || point.getHeWon() == true) && point.getNameCurrentMonster() == "boss") {  // Renitialisation des joueurs dans la map5
						Block newPosi = map.getBlock(posPoint.getLine() - 12, posPoint.getColumn() - 35); 
						point.setPosition(newPosi);
						Block newPos = map.getBlock(position.getLine(), position.getColumn() - 3);
						p.setPosition(newPos);
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
	
	public void paint(JoueurFictif point, Graphics2D graphics) {
		Block position = point.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		graphics.drawRect(x*blockSize, y*blockSize, blockSize, blockSize);
	}
	
	public void paint(SuperObject[] obj, Map map, JoueurFictif point, Graphics2D graphics) {
		Block[][] blocks = map.getBlocks();
		int blockSize = GameConfiguration.BLOCK_SIZE;
	
		MapBuilder m = new MapBuilder("src/maps/map.txt");
		
		Block posPoint = point.getPosition();
		
		ObjectsImagesTab objTab = new ObjectsImagesTab(60);
		
		Image img1 = BlockManager.readImage("src/objects/key.png");
		Image img2 = BlockManager.readImage("src/objects/door.png");
		Image img3 = BlockManager.readImage("src/objects/doorRight.png");
		Image img4 = BlockManager.readImage("src/objects/crystal.png");
		Image img5 = BlockManager.readImage("src/objects/strength.png");
		Image img6 = BlockManager.readImage("src/objects/block.png");
		Image img7 = BlockManager.readImage("src/objects/portail.png");
		Image img8 = BlockManager.readImage("src/objects/heartFullHero.png");
		Image img9 = BlockManager.readImage("src/objects/heartFullMonster.png");
		Image img10 = BlockManager.readImage("src/objects/casque.png");
		Image img11 = BlockManager.readImage("src/objects/trishula.png");
		objTab.add(img1); // key1, 2 et 3
		objTab.add(img1);
		objTab.add(img1);
		
		objTab.add(img2); // door1, 2 et 3
		objTab.add(img3);
		objTab.add(img2);
		
		objTab.add(img4); // crystal1, 2 et 3
		objTab.add(img4);
		objTab.add(img4);
		
		objTab.add(img6); // blockUp1 et down1
		objTab.add(img6);
		objTab.add(img6); // blockUp2 et down2
		objTab.add(img6);
		objTab.add(img6); // blockLeft3 et blockRight3
		objTab.add(img6);
		objTab.add(img6); // blockLeft4 et blockRight4
		objTab.add(img6);
		objTab.add(img6); // blockUp5 et blockDown5
		objTab.add(img6);
		objTab.add(img6); // blockUp6 et blockDown6
		objTab.add(img6);
		objTab.add(img6); // blockLeft7 et blockRight7
		objTab.add(img6);
		objTab.add(img6); // blockUp8 et blockDown8
		objTab.add(img6);
		
		objTab.add(img5); //strength1
		objTab.add(img5); //strength2
		objTab.add(img5); //strength3
		objTab.add(img5); //strength4
		objTab.add(img5); //strength5
		objTab.add(img5); //strength6
		objTab.add(img5); //strength7
		objTab.add(img5); //strength8
		
		objTab.add(img7); // portail
		
		objTab.add(img8); // heartRed1 2 3 4 et 5 sur la map de combat mini-monstre/Gardien
		objTab.add(img8);
		objTab.add(img8);
		objTab.add(img8);
		objTab.add(img8);
		
		objTab.add(img9); // heartBlack1 2 3 4 et 5 sur la map de combat mini-monstre/Gardien
		objTab.add(img9);
		objTab.add(img9);
		objTab.add(img9);
		objTab.add(img9);
		
		objTab.add(img10); // casque et trident
		objTab.add(img11);
		
		for(int i=0; i<obj.length; i++) {
			
			if(obj[i] != null) {
				
				int columnIndex = 0;
				int lineIndex = 0;
				while(columnIndex < map.getColumnCount() && lineIndex < map.getLineCount()) {
					Block block = blocks[lineIndex][columnIndex];
				
					int x = block.getColumn();
					int y = block.getLine();
				
					Iterator<Integer> iterator = m.getMapData().iterator(); // parcours l'arraylist de la map
					while (iterator.hasNext()) {
						iterator.next();
									
						if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 1
								&& (x <= 15 && x >= 0) && (y <= 11 && y >= 0)) {
							if(obj[i].getName() == "strength1" || obj[i].getName() == "block1") { 
								Block posiObj = obj[i].getPosition();
								int yO = posiObj.getLine();
								int xO = posiObj.getColumn();
								graphics.drawImage(objTab.currentImage(i), xO * blockSize, yO * blockSize, blockSize, blockSize, null);
							}	
						}
						if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 2
									&& (x <= 31 && x >= 16) && (y <= 11 && y >= 0)) {
							if(obj[i].getName() == "Key1" || obj[i].getName() == "Door1" || obj[i].getName() == "Crystal1" || obj[i].getName() == "strength2"
									|| obj[i].getName() == "block2") {
								Block posiObj = obj[i].getPosition();
								int yO = posiObj.getLine();
								int xO = posiObj.getColumn();
								graphics.drawImage(objTab.currentImage(i), (xO * blockSize) - (16 * blockSize), yO * blockSize, blockSize, blockSize, null);
							}
						}
						if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 3
								&& (x <= 47 && x >= 32) && (y <= 11 && y >= 0)) {
							if(obj[i].getName() == "strength3" || obj[i].getName() == "block3") { 
								Block posiObj = obj[i].getPosition();
								int yO = posiObj.getLine();
								int xO = posiObj.getColumn();
								graphics.drawImage(objTab.currentImage(i), (xO * blockSize) - (32 * blockSize), yO * blockSize, blockSize, blockSize, null);
							}	
						}
						if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 6
								&& (x <= 47 && x >= 32) && (y <= 23 && y >= 12)) {
							if(obj[i].getName() == "Key2" || obj[i].getName() == "Door2" || obj[i].getName() == "Crystal2" || obj[i].getName() == "strength4" || obj[i].getName() == "block4") { 
								Block posiObj = obj[i].getPosition();
								int yO = posiObj.getLine();
								int xO = posiObj.getColumn();
								graphics.drawImage(objTab.currentImage(i), (xO * blockSize) - (32 * blockSize), (yO * blockSize) - (12 * blockSize), blockSize, blockSize, null);
							}
						}
						if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 9
								&& (x <= 47 && x >= 32) && (y <= 35 && y >= 24)) {
							if(obj[i].getName() == "strength5" || obj[i].getName() == "block5") { 
								Block posiObj = obj[i].getPosition();
								int yO = posiObj.getLine();
								int xO = posiObj.getColumn();
								graphics.drawImage(objTab.currentImage(i), (xO * blockSize) - (32 * blockSize), (yO * blockSize) - (24 * blockSize), blockSize, blockSize, null);
							}
						}
						if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 8
								&& (x <= 31 && x >= 16) && (y <= 35 && y >= 24)) {
							if(obj[i].getName() == "Key3" || obj[i].getName() == "Door3" || obj[i].getName() == "Crystal3" || obj[i].getName() == "strength6" || obj[i].getName() == "block6") { 
								Block posiObj = obj[i].getPosition();
								int yO = posiObj.getLine();
								int xO = posiObj.getColumn();
								graphics.drawImage(objTab.currentImage(i), (xO * blockSize) - (16 * blockSize), (yO * blockSize) - (24 * blockSize), blockSize, blockSize, null);
							}
						}
						if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 7
								&& (x <= 15 && x >= 0) && (y <= 35 && y >= 24)) {
							if(obj[i].getName() == "strength7" || obj[i].getName() == "block7") { 
								Block posiObj = obj[i].getPosition();
								int yO = posiObj.getLine();
								int xO = posiObj.getColumn();
								graphics.drawImage(objTab.currentImage(i), xO * blockSize, (yO * blockSize) - (24 * blockSize), blockSize, blockSize, null);
							}
						}
						if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 4
								&& (x <= 15 && x >= 0) && (y <= 23 && y >= 12)) {
							if(obj[i].getName() == "strength8" || obj[i].getName() == "block8") { 
								Block posiObj = obj[i].getPosition();
								int yO = posiObj.getLine();
								int xO = posiObj.getColumn();
								graphics.drawImage(objTab.currentImage(i), xO * blockSize, (yO * blockSize) - (12 * blockSize), blockSize, blockSize, null);
							}
						}
						if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 5
								&& (x <= 31 && x >= 16) && (y <= 23 && y >= 12)) {
							if(obj[i].getName() == "portail") { 
								Block posiObj = obj[i].getPosition();
								int yO = posiObj.getLine();
								int xO = posiObj.getColumn();
								graphics.drawImage(objTab.currentImage(i), (xO * blockSize) - (16 * blockSize), (yO * blockSize) - (12 * blockSize), blockSize, blockSize, null);
							}
						}
						if((posPoint.getColumn() <= 63 && posPoint.getColumn() >= 47) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map de combat mini-monstre/gardien
								&& (x <= 63 && x >= 47) && (y <= 23 && y >= 12)) {
							if(obj[i].getName() == "heartRed1M1" || obj[i].getName() == "heartRed2M1" || obj[i].getName() == "heartRed3M1" || obj[i].getName() == "heartRed4M1" 
									|| obj[i].getName() == "heartRed5M1" || obj[i].getName() == "heartBlack1M1" || obj[i].getName() == "heartBlack2M1" || obj[i].getName() == "heartBlack3M1" 
									|| obj[i].getName() == "heartBlack4M1" || obj[i].getName() == "heartBlack5M1") {
								Block posiObj = obj[i].getPosition();
								int yO = posiObj.getLine();
								int xO = posiObj.getColumn();
								if(point.getCollisionMons() == true) {
									graphics.drawImage(objTab.currentImage(i), (xO * blockSize) - (48 * blockSize), (yO * blockSize) - (12 * blockSize) , blockSize, blockSize, null);
								}
								graphics.drawImage(objTab.currentImage(i), xO * blockSize, yO * blockSize, blockSize, blockSize, null);
							}
						}
						if((posPoint.getColumn() <= 63 && posPoint.getColumn() >= 47) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map de combat boss
								&& (x <= 63 && x >= 47) && (y <= 35 && y >= 24)) {

							if(obj[i].getName() == "heartRed1M1" || obj[i].getName() == "heartRed2M1" || obj[i].getName() == "heartRed3M1" || obj[i].getName() == "heartRed4M1" 
									|| obj[i].getName() == "heartRed5M1" || obj[i].getName() == "heartBlack1M1" || obj[i].getName() == "heartBlack2M1" || obj[i].getName() == "heartBlack3M1" 
									|| obj[i].getName() == "heartBlack4M1" || obj[i].getName() == "heartBlack5M1") {
								Block posiObj = obj[i].getPosition();
								int yO = posiObj.getLine();
								int xO = posiObj.getColumn();
								if(point.getCollisionMons() == true) {
									graphics.drawImage(objTab.currentImage(i), (xO * blockSize) - (48 * blockSize), (yO * blockSize) - (12 * blockSize) , blockSize, blockSize, null);
								}
								graphics.drawImage(objTab.currentImage(i), xO * blockSize, yO * blockSize, blockSize, blockSize, null);
							}
						}
						if((posPoint.getColumn() <= 63 && posPoint.getColumn() >= 47) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // shop
								&& (x <= 63 && x >= 47) && (y <= 11 && y >= 0)) {
	
							if(obj[i].getName() == "casque" || obj[i].getName() == "trident") { 
								Block posiObj = obj[i].getPosition();
								int yO = posiObj.getLine();
								int xO = posiObj.getColumn();
								graphics.drawImage(objTab.currentImage(i), (xO * blockSize) - (48 * blockSize), yO * blockSize, blockSize, blockSize, null);
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
		}
	}
	
	public void paint(Monsters monsters, Map map, JoueurFictif point, Graphics2D graphics) {
		Block[][] blocks = map.getBlocks();
		int blockSize = GameConfiguration.BLOCK_SIZE;
	
		MapBuilder m = new MapBuilder("src/maps/map.txt");
		
		Block posPoint = point.getPosition();
		
		MonstersImagesTab monstersTab = new MonstersImagesTab(15);
		
		Image img1 = BlockManager.readImage("src/monsters/asura.png");
		Image img2 = BlockManager.readImage("src/monsters/miniMonster.png");
		Image img3 = BlockManager.readImage("src/monsters/boss.png");
		monstersTab.add(img1); // les asuras
		monstersTab.add(img1);
		monstersTab.add(img1);
		
		monstersTab.add(img2); // les minimonstres
		monstersTab.add(img2);
		monstersTab.add(img2);
		monstersTab.add(img2);
		monstersTab.add(img2);
		monstersTab.add(img2);
		monstersTab.add(img2);
		monstersTab.add(img2);
		
		monstersTab.add(img3); // boss
		
		for(int i=0; i<monsters.getMonsters().length; i++) {
				
				if(monsters.currentMonster(i) != null) {
					
					int columnIndex = 0;
					int lineIndex = 0;
					while(columnIndex < map.getColumnCount() && lineIndex < map.getLineCount()) {
						Block block = blocks[lineIndex][columnIndex];
				
						int x = block.getColumn();
						int y = block.getLine();
				
						Iterator<Integer> iterator = m.getMapData().iterator(); // parcours l'arraylist de la map
						while (iterator.hasNext()) {
							iterator.next();
							
							if(point.getHeWon() == true && point.getNameCurrentMonster() == monsters.currentMonster(i).getName()) {
								monsters.remove(i);
								while(monsters.currentMonster(i) == null) {
									i++;
								}
							}
							
							Block posiMons = monsters.currentMonster(i).getPosition();
							int yM = posiMons.getLine();
							int xM = posiMons.getColumn();
							
							if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 1
									&& (x <= 15 && x >= 0) && (y <= 11 && y >= 0)) {
									if((monsters.currentMonster(i).getName() == "miniMonster1")) {
										graphics.drawImage(monstersTab.currentImage(i), xM * blockSize, yM * blockSize, blockSize, blockSize, null);
										if(point.getQuitPressed() == true || point.getIsDead() == true) { 
											Block newPosi2 = map.getBlock(9, 12); 
											monsters.currentMonster(i).setPosition(newPosi2);
										}
									}
							}
							if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 2
									&& (x <= 31 && x >= 16) && (y <= 11 && y >= 0)) {
								
								if((monsters.currentMonster(i).getName() == "miniMonster2")) {
									graphics.drawImage(monstersTab.currentImage(i), (xM * blockSize)  - (16 * blockSize), yM * blockSize, blockSize, blockSize, null);
									if(point.getQuitPressed() == true || point.getIsDead() == true) { // si on quite ou que le joueur a perdu
										Block newPosi2 = map.getBlock(9, 19); // remet le monstre a la position de base
										monsters.currentMonster(i).setPosition(newPosi2);
									}
								}
								
								if((monsters.currentMonster(i).getName() == "asura1")) {
									graphics.drawImage(monstersTab.currentImage(i), (xM * blockSize)  - (16 * blockSize), yM * blockSize, blockSize, blockSize, null);
									if(point.getQuitPressed() == true || point.getIsDead() == true) { // si on quite ou que le joueur a perdu
										Block newPosi2 = map.getBlock(9, 29); // remet le monstre a la position de base
										monsters.currentMonster(i).setPosition(newPosi2);
									}
								}
								
							}
							if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 6
									&& (x <= 47 && x >= 32) && (y <= 23 && y >= 12)) {		
								
								if((monsters.currentMonster(i).getName() == "asura2")) {
									graphics.drawImage(monstersTab.currentImage(i), (xM * blockSize)  - (32 * blockSize), (yM * blockSize) - (12 * blockSize), blockSize, blockSize, null);
									if(point.getQuitPressed() == true || point.getIsDead() == true) { 
										Block newPosi2 = map.getBlock(14, 36); 
										monsters.currentMonster(i).setPosition(newPosi2);
									}
								}
								if((monsters.currentMonster(i).getName() == "miniMonster4")) {
									graphics.drawImage(monstersTab.currentImage(i), (xM * blockSize)  - (32 * blockSize), (yM * blockSize) - (12 * blockSize), blockSize, blockSize, null);
									if(point.getQuitPressed() == true || point.getIsDead() == true) { 
										Block newPosi2 = map.getBlock(20, 34); 
										monsters.currentMonster(i).setPosition(newPosi2);
									}
								}
							}
							if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 8
									&& (x <= 31 && x >= 16) && (y <= 35 && y >= 24)) {
									
								if((monsters.currentMonster(i).getName() == "asura3")) {
									graphics.drawImage(monstersTab.currentImage(i), (xM * blockSize) - (16 * blockSize), (yM * blockSize) - (24 * blockSize), blockSize, blockSize, null);
									if(point.getQuitPressed() == true || point.getIsDead() == true) { 
										Block newPosi2 = map.getBlock(26, 18); 
										monsters.currentMonster(i).setPosition(newPosi2);
									}
								}
								if((monsters.currentMonster(i).getName() == "miniMonster6")) {
									graphics.drawImage(monstersTab.currentImage(i), (xM * blockSize) - (16 * blockSize), (yM * blockSize) - (24 * blockSize), blockSize, blockSize, null);
									if(point.getQuitPressed() == true || point.getIsDead() == true) { 
										Block newPosi2 = map.getBlock(26, 28); 
										monsters.currentMonster(i).setPosition(newPosi2);
									}
								}
							}
							
							if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 3
									&& (x <= 47 && x >= 32) && (y <= 11 && y >= 0)) {
								
								if((monsters.currentMonster(i).getName() == "miniMonster3")) {
									graphics.drawImage(monstersTab.currentImage(i), (xM * blockSize) - (32 * blockSize), yM * blockSize, blockSize, blockSize, null);
									if(point.getQuitPressed() == true || point.getIsDead() == true) { 
										Block newPosi2 = map.getBlock(2, 35); 
										monsters.currentMonster(i).setPosition(newPosi2);
									}
								}
							}
							
							if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 9
									&& (x <= 47 && x >= 32) && (y <= 35 && y >= 24)) {
								
								if((monsters.currentMonster(i).getName() == "miniMonster5")) {
									graphics.drawImage(monstersTab.currentImage(i), (xM * blockSize) - (32 * blockSize), (yM * blockSize)  - (24 * blockSize), blockSize, blockSize, null);
									if(point.getQuitPressed() == true || point.getIsDead() == true) { 
										Block newPosi2 = map.getBlock(32, 44); 
										monsters.currentMonster(i).setPosition(newPosi2);
									}
								}		
							}
								
							if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 7
									&& (x <= 15 && x >= 0) && (y <= 35 && y >= 24)) {
								
								if((monsters.currentMonster(i).getName() == "miniMonster7")) {
									graphics.drawImage(monstersTab.currentImage(i), xM * blockSize, (yM * blockSize)  - (24 * blockSize), blockSize, blockSize, null);
									if(point.getQuitPressed() == true || point.getIsDead() == true) { 
										Block newPosi2 = map.getBlock(32, 3); 
										monsters.currentMonster(i).setPosition(newPosi2);
									}
								}
								
							}
							
							if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 4
									&& (x <= 15 && x >= 0) && (y <= 23 && y >= 12)) {

								if((monsters.currentMonster(i).getName() == "miniMonster8")) {
									graphics.drawImage(monstersTab.currentImage(i), xM * blockSize, (yM * blockSize)  - (12 * blockSize), blockSize, blockSize, null);
									if(point.getQuitPressed() == true || point.getIsDead() == true) { 
										Block newPosi2 = map.getBlock(14, 3); 
										monsters.currentMonster(i).setPosition(newPosi2);
									}
								}
							}
							
							if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 5
									&& (x <= 31 && x >= 16) && (y <= 23 && y >= 12)) {
								
								if((monsters.currentMonster(i).getName() == "boss")) {
									graphics.drawImage(monstersTab.currentImage(i), (xM * blockSize) - (16 * blockSize), (yM * blockSize)  - (12 * blockSize), blockSize, blockSize, null);
									if(point.getQuitPressed() == true || point.getIsDead() == true) { 
										Block newPosi2 = map.getBlock(17, 25); 
										monsters.currentMonster(i).setPosition(newPosi2);
									}
								}
							}

							if((posPoint.getColumn() <= 63 && posPoint.getColumn() >= 47) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map de combat mini-monstre/gardien
									&& (x <= 63 && x >= 47) && (y <= 23 && y >= 12)) { // map de combat minimonstre/gardien
								graphics.drawImage(monstersTab.currentImage(i), xM * blockSize, yM * blockSize, blockSize, blockSize, null);
							}
							
							if((posPoint.getColumn() <= 63 && posPoint.getColumn() >= 47) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map de combat boss
									&& (x <= 63 && x >= 47) && (y <= 35 && y >= 24)) {
								graphics.drawImage(monstersTab.currentImage(i), xM * blockSize, yM * blockSize, blockSize, blockSize, null);
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
		}	
	}
	
	public void paint(ProjectileMonster pro, Graphics graphics) {
		Block position = pro.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		Image img = BlockManager.readImage("src/projectiles/bossProjectile.png");
		graphics.drawImage(img, x * blockSize, y * blockSize, blockSize, blockSize, null);	
	}
	
	public void paint(Graphics graphics, ProjectileMonster pro) {
		Block position = pro.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		Image img = BlockManager.readImage("src/projectiles/projectileMonster.png");
		graphics.drawImage(img, x * blockSize, y * blockSize, blockSize, blockSize, null);	
	}
	
	public void paint(ProjectileHero pro, Graphics graphics) {
		Block position = pro.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		Image img = BlockManager.readImage("src/projectiles/pinakaProjectile.png");
		graphics.drawImage(img, x * blockSize, y * blockSize, blockSize, blockSize, null);	
	}
	
	public void paint(ProjectileFeu pro, Graphics graphics) {
		Block position = pro.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		Image img = BlockManager.readImage("src/projectiles/projectileFeu.png");
		graphics.drawImage(img, x * blockSize, y * blockSize, blockSize, blockSize, null);	
	}
	
	public void paint(Graphics graphics, ProjectileHero pro) {
		Block position = pro.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		Image img = BlockManager.readImage("src/projectiles/tridentProjectile.png");
		graphics.drawImage(img, x * blockSize, y * blockSize, blockSize, blockSize, null);	
	}
	
	public void paint(Npcs npcs, Map map, JoueurFictif point, Graphics2D graphics) {
		Block[][] blocks = map.getBlocks();
		int blockSize = GameConfiguration.BLOCK_SIZE;
	
		MapBuilder m = new MapBuilder("src/maps/map.txt");
		
		Block posPoint = point.getPosition();
		
		NpcsImagesTab npcsTab = new NpcsImagesTab(10);
		
		Image img = BlockManager.readImage("src/npcs/villager.png");
		
		npcsTab.add(img);
		npcsTab.add(img);
		npcsTab.add(img);
		npcsTab.add(img);
		npcsTab.add(img);
		npcsTab.add(img);
		npcsTab.add(img);
		
		for(int i=0; i<npcs.getNpc().length; i++) {
			
			if(npcs.currentNpc(i) != null) {
				
				int columnIndex = 0;
				int lineIndex = 0;
				while(columnIndex < map.getColumnCount() && lineIndex < map.getLineCount()) {
					Block block = blocks[lineIndex][columnIndex];
			
					int x = block.getColumn();
					int y = block.getLine();
			
					Iterator<Integer> iterator = m.getMapData().iterator(); // parcours l'arraylist de la map
					while (iterator.hasNext()) {
						iterator.next();
						
						
						Block posiMons = npcs.currentNpc(i).getPosition();
						int yN = posiMons.getLine();
						int xN = posiMons.getColumn();
					
						
						if((posPoint.getColumn() <= 63 && posPoint.getColumn() >= 47) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // shop
								&& (x <= 63 && x >= 47) && (y <= 11 && y >= 0)) { //shop
							
							if(npcs.currentNpc(i).getName() == "npc1" || npcs.currentNpc(i).getName() == "npc2") { 
								
								graphics.drawImage(npcsTab.currentImage(i), (xN * blockSize) - (48 * blockSize), yN * blockSize, blockSize, blockSize, null);
							}
						}
						
						if((posPoint.getColumn() <= 15 && posPoint.getColumn() >= 0) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 1
								&& (x <= 15 && x >= 0) && (y <= 11 && y >= 0)) {
							
							if(npcs.currentNpc(i).getName() == "npc3") { 
								
								graphics.drawImage(npcsTab.currentImage(i), xN * blockSize, yN * blockSize, blockSize, blockSize, null);
							}
						}
						
						if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 3
								&& (x <= 47 && x >= 32) && (y <= 11 && y >= 0)) {
							
							if(npcs.currentNpc(i).getName() == "npc4") { 
								
								graphics.drawImage(npcsTab.currentImage(i), (xN * blockSize) - (32 * blockSize), yN * blockSize, blockSize, blockSize, null);
							}
						}
						
						if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 23 && posPoint.getLine() >= 12) // map 5
								&& (x <= 31 && x >= 16) && (y <= 23 && y >= 12)) {
							
							if(npcs.currentNpc(i).getName() == "npc6") { 
								
								graphics.drawImage(npcsTab.currentImage(i), (xN * blockSize) - (16 * blockSize), (yN * blockSize) - (12 * blockSize), blockSize, blockSize, null);
							}
						}
						
						if((posPoint.getColumn() <= 47 && posPoint.getColumn() >= 32) && (posPoint.getLine() <= 35 && posPoint.getLine() >= 24) // map 9
								&& (x <= 47 && x >= 32) && (y <= 35 && y >= 24)) {
							
							if(npcs.currentNpc(i).getName() == "npc5") { 
								
								graphics.drawImage(npcsTab.currentImage(i), (xN * blockSize) - (32 * blockSize), (yN * blockSize) - (24 * blockSize), blockSize, blockSize, null);
							}
						}
						
						if((posPoint.getColumn() <= 31 && posPoint.getColumn() >= 16) && (posPoint.getLine() <= 11 && posPoint.getLine() >= 0) // map 2
								&& (x <= 31 && x >= 16) && (y <= 11 && y >= 0)) {
							
							if(npcs.currentNpc(i).getName() == "npc7") { 
								
								graphics.drawImage(npcsTab.currentImage(i), (xN * blockSize) - (16 * blockSize), yN * blockSize, blockSize, blockSize, null);
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
		}
		
	}
}
