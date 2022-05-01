package motor.mobile;

import motor.map.Block;

public class Monster extends MouvElements{

	private String name;
	private boolean isDead;

	public Monster(Block position, String name) {
		super(position);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getIsDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

}
