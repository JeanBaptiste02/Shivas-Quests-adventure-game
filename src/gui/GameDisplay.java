package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import configuration.GameConfiguration;
import motor.map.Map;
import motor.mobile.Joueur;
import motor.mobile.JoueurFictif;
import motor.objects.SuperObject;
import motor.process.MobileElementManager;

/**
 * Cette classe permet d'afficher les composants sur la fenetre
 * @author D.JB E.SRI Z.VIC
 *
 */
public class GameDisplay extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private boolean debugGrid = false; // permet de montrer la grille
	
	private Map map;
	private MobileElementManager manager;
	private PaintStrategy paintStrategy = new PaintStrategy(); // instanciation pour utiliser les méthodes de la classe PaintStrategy
	private Joueur player;
	private JoueurFictif point;
	
	/**
	 * constructeur 
	 * @param map represente la carte du jeu (l'atmosphere/environnement du jeu)
	 * @param manager de type MobileElementManager
	 */
	public GameDisplay(Map map, MobileElementManager manager) {
		this.map = map;
		this.manager = manager;
	}
	
	/**
	 * permet de dessiner(autres que l'arrière plan...) des composants sur le JPanel comme la map, et les joueurs
	 * @param g représente un objet graphic
	 */
	@Override
	public void paintComponent(Graphics g) { // comme si on avait un crayon pour dessiner
		super.paintComponent(g); //fait référence à la méthode de la classe JComponent
		
		
		Graphics2D g2 = (Graphics2D)g; // permet d'avoir plus de fonctionalité graphique
		
		player = manager.getPlayer(); //joueur original
		point = manager.getPoint();// joueur fictif

		//dessine la map
		paintStrategy.paint(map, player, point, g2);
		
		//tableau d'objets
		SuperObject[] object = manager.getObj();
		paintStrategy.paint(object, map, point, g2);
		
		//dessine les joueurs original et fictif
		paintStrategy.paint(player,g2);
		paintStrategy.paint(point, g2);
		
		//pour montrer les cases
		if (debugGrid) {
			drawDebugGrid(g);
		}
		
		
	}
	
	/**
	 * dessine les cases/grille (les bords des blocks)
	 * @param g
	 */
	private void drawDebugGrid(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		g.setColor(Color.white);

		for (int i = GameConfiguration.BLOCK_SIZE; i <= width; i += GameConfiguration.BLOCK_SIZE) {
			g.drawLine(i, 3, i, height);
		}

		for (int i = GameConfiguration.BLOCK_SIZE; i <= height; i += GameConfiguration.BLOCK_SIZE) {
			g.drawLine(1, i, width, i);
		}
	}
	

	
}
