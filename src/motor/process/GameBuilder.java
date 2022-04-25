package motor.process;

import configuration.GameConfiguration;
import motor.map.Block;
import motor.map.Map;
import motor.mobile.Joueur;
import motor.mobile.JoueurFictif;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 *
 */
public class GameBuilder {

	public static Map buildMap() {
		return new Map(GameConfiguration.BLOCK_LINE_COUNT, GameConfiguration.BLOCK_COLUMN_COUNT);
	}

	public static MobileElementManager buildInitMobile(Map map) {
		MobileElementManager manager = new MobileElementManager(map);
		//les 3 methodes suivantes n'ont pas besoin d'etre instanciees car elles sont statics
		intializePlayer(map, manager);
		intializeFictionalPlayer(map, manager);
		intializeObjects(map, manager);
		return manager;
	}

	/**
	 * permet d'initialiser le joueur original
	 * @param map
	 * @param manager
	 */
	private static void intializePlayer(Map map, MobileElementManager manager) {
		Block block = map.getBlock(3, 3);
		Joueur player = new Joueur(block);
		manager.set(player);
	}
	
	/**
	 * permet d'initialiser le joueur fictif
	 * @param map
	 * @param manager
	 */
	private static void intializeFictionalPlayer(Map map, MobileElementManager manager) {
		Block block = map.getBlock(3, 3);
		JoueurFictif point = new JoueurFictif(block);
		manager.setPoint(point);
	}
	
	/**
	 * permet d'initialiser les objets
	 * @param map
	 * @param manager
	 */
	private static void intializeObjects(Map map, MobileElementManager manager) {
		manager.setObjects();
	}

}