package motor.mobile;

import motor.map.Block;

public class Npc extends MouvElements  {

	String name;
	String dialogue;
	
	public Npc(Block position, String name) {
		super(position);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDialogue() {
		return dialogue;
	}

	public void setDialogue(String dialogue) {
		this.dialogue = dialogue;
	}
	
}