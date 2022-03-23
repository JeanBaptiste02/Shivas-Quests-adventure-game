package motor.mobile;

import motor.map.Block;

public class JoueurFictif extends MouvElements{

	private boolean upPressed, downPressed, leftPressed, rightPressed;
	
	public JoueurFictif(Block position) {
		super(position);
	}
	
	public boolean getUpPressed() {
		return upPressed;
	}
	
	public boolean getDownPressed() {
		return downPressed;
	}
	
	public boolean getLeftPressed() {
		return leftPressed;
	}
	
	public boolean getRightPressed() {
		return rightPressed;
	}
	
	public void setUpPressed(boolean up) {
		this.upPressed = up;
	}
	
	public void setDownPressed(boolean down) {
		this.downPressed = down;
	}
	
	public void setLeftPressed(boolean left) {
		this.leftPressed = left;
	}
	
	public void setRightPressed(boolean right) {
		this.rightPressed = right;
	}

	
	
}
