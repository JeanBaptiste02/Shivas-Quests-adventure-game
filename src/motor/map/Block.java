package motor.map;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 *classe permettant de gerer une case (les caracteristiques generaux d'une case)
 */
public class Block {
	private int ligne;
	private int colonne;

	public Block(int ligne, int colonne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}

	public int getLine() {
		return ligne;
	}

	public int getColumn() {
		return colonne;
	}

	@Override
	public String toString() {
		return "Block [line=" + ligne + ", column=" + colonne + "]";
	}


	
}
