package configuration;

/**
 * 
 * @author vikne
 *classe gerant les cases du jeu
 */

public class GameConfiguration {

	public static final int ORIGINAL_BLOCK_SIZE = 15; // block du hero ou npc ou de la map
	public static final int SCALE = 1; // adapte la taille du block a l'echelle de l'ecran
	public static final int BLOCK_SIZE = ORIGINAL_BLOCK_SIZE * SCALE; // ici le block fais 48x48
	public static final int BLOCK_COLUMN_COUNT = 48;
	public static final int BLOCK_LINE_COUNT = 36;
	public static final int WINDOW_WIDTH = BLOCK_SIZE * BLOCK_COLUMN_COUNT; // 48*16 = 768pixels
	public static final int WINDOW_HEIGHT = BLOCK_SIZE * BLOCK_LINE_COUNT; // 48*12 = 576pixels
	
	public static final int GAME_SPEED = 10; 
}
