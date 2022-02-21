package motor.mobile;


import motor.map.Block;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 *
 */

public abstract class MouvElements {
	private Block position;
	private String direction = "down"; 
	private int spriteNum = 1;
	
	public MouvElements(Block position) {
		this.position = position;
	}

	public Block getPosition() {
		return position;
	}

	public void setPosition(Block position) {
		this.position = position;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getSpriteNum() {
		return spriteNum;
	}

	public void setSpriteNum(int spriteNum) {
		this.spriteNum = spriteNum;
	}
}