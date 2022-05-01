package configuration;

/**
 *  @author D.JB E.SRI Z.VIC
 * classe gerant les cases du jeu.
 */

public class GameConfiguration {

	public static final int ORIGINAL_BLOCK_SIZE = 26; 
	public static final int SCALE = 2; // adapte la taille du block a l'echelle de l'ecran
	public static final int BLOCK_SIZE = ORIGINAL_BLOCK_SIZE * SCALE; 
	public static final int BLOCK_COLUMN_COUNT = 64;
	public static final int BLOCK_LINE_COUNT = 36;
	public static final int WINDOW_WIDTH = BLOCK_SIZE * 16; 
	public static final int WINDOW_HEIGHT = BLOCK_SIZE * 12;
	public static final int GAME_SPEED = 20;
	
	
}
