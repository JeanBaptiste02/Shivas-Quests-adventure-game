package motor.mobile;

import motor.map.Block;

public class JoueurFictif extends MouvElements{

	private boolean upPressed, downPressed, leftPressed, rightPressed;
	private boolean collisionMons;
	private boolean quitPressed;
	private boolean isDead;
	private boolean heWon = false;
	private String nameCurrentMonster;

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
	
	public boolean getCollisionMons() {
		return collisionMons;
	}

	public void setCollisionMons(boolean collisionMons) {
		this.collisionMons = collisionMons;
	}
	
	public boolean getQuitPressed() {
		return quitPressed;
	}

	public void setQuitPressed(boolean quitPressed) {
		this.quitPressed = quitPressed;
	}
	
	public boolean getIsDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	public boolean getHeWon() {
		return heWon;
	}

	public void setHeWon(boolean heWon) {
		this.heWon = heWon;
	}

	public String getNameCurrentMonster() {
		return nameCurrentMonster;
	}

	public void setNameCurrentMonster(String nameCurrentMonster) {
		this.nameCurrentMonster = nameCurrentMonster;
	}
	
	
}
