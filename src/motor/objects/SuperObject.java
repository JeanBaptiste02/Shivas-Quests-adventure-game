package motor.objects;


import motor.map.Block;

public abstract class SuperObject {
	
	private Block position;
	private String name;
	
	public SuperObject(Block position, String name) {
		this.position = position;
		this.name = name;
		
	}

	public Block getPosition() {
		return position;
	}

	public void setPosition(Block position) {
		this.position = position;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
