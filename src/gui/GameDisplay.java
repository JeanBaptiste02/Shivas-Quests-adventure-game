package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import configuration.GameConfiguration;

import motor.map.Map;
import motor.mobile.Joueur;
import motor.mobile.JoueurFictif;
import motor.mobile.Monsters;
import motor.mobile.Npcs;
import motor.mobile.ProjectileFeu;
import motor.mobile.ProjectileHero;
import motor.mobile.ProjectileMonster;
import motor.objects.SuperObject;
import motor.process.MobileElementManager;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 *
 */
@SuppressWarnings("serial")
public class GameDisplay extends JPanel {
	
	private boolean debugGrid = false; // permet de montrer la grille pour débuger facilement
	
	private Map map;
	private MobileElementManager manager;
	private PaintStrategy paintStrategy = new PaintStrategy();


	public GameDisplay(Map map, MobileElementManager manager) {
		this.map = map;
		this.manager = manager;
	
	}
	
	
	@Override
	public void paintComponent(Graphics g) { // comme si on avait un crayon pour dessiner
		super.paintComponent(g);
		
		
		Graphics2D g2 = (Graphics2D)g; // permet d'avoir plus de fonctionalité graphique
		
		Joueur player = manager.getPlayer();
		JoueurFictif point = manager.getPoint();
		
		//MAP
		paintStrategy.paint(map, player, point, g2);
		
		//OBJECTS
		SuperObject[] object = manager.getObj();
		paintStrategy.paint(object, map, point, g2);
		
		//PLAYERS
		paintStrategy.paint(player,g2);
		paintStrategy.paint(point, g2);
		
		//MONSTERS
		Monsters monsters = manager.getMonsters();
		paintStrategy.paint(monsters, map, point, g2);
		
		//PROJECTILES
		if(manager.getPoint().getNameCurrentMonster() == "boss") {
			for (ProjectileMonster bossProjectile : manager.getProjectilesMons()) {
				paintStrategy.paint(bossProjectile, g);
			}
		} else {
			for (ProjectileMonster projectileMons: manager.getProjectilesMons()) {
				paintStrategy.paint(g, projectileMons);
			}
		}
		
		if(manager.getChoiceNum() == 1) {
			for (ProjectileHero projectilePinaka : manager.getProjectilesHero()) {
				paintStrategy.paint(projectilePinaka, g);
			}
		} else if(manager.getChoiceNum() == 2) {
			for (ProjectileHero projectileTrident : manager.getProjectilesHero()) {
				paintStrategy.paint(g, projectileTrident);
			}
		} else if(manager.getChoiceNum() == 4) {
			for (ProjectileFeu projectileFeu : manager.getProjectilesFeu()) {
				paintStrategy.paint(projectileFeu, g);
			}
		}
		
		//NPCS
		Npcs npcs = manager.getNpcs();
		paintStrategy.paint(npcs, map, point, g2);
		
		if (debugGrid) {
			drawDebugGrid(g);
		}
		
		
	}
	
	private void drawDebugGrid(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		g.setColor(Color.BLACK);

		for (int i = GameConfiguration.BLOCK_SIZE; i <= width; i += GameConfiguration.BLOCK_SIZE) {
			g.drawLine(i, 1, i, height);
		}

		for (int i = GameConfiguration.BLOCK_SIZE; i <= height; i += GameConfiguration.BLOCK_SIZE) {
			g.drawLine(1, i, width, i);
		}
	}
	
	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}


	public MobileElementManager getManager() {
		return this.manager;
	}


	public void setManager(MobileElementManager manager) {
		this.manager = manager;
	}
	
}
