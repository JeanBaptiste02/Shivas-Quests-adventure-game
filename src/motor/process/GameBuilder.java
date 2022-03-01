package motor.process;

import configuration.GameConfiguration;
import motor.map.Block;
import motor.map.Map;
import motor.mobile.Joueur;

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
		intializePlayer(map, manager);
		return manager;
	}

	private static void intializePlayer(Map map, MobileElementManager manager) {
		Block block = map.getBlock(3, 3);
		Joueur player = new Joueur(block);
		manager.set(player);
	}

}