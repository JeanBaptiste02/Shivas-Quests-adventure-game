package motor.mobile;


public class Npcs {
	
	private Npc[]nonPlayableChara;
	private int arraySize=0;
	
	
	public Npcs(int size) {
		nonPlayableChara = new Npc[size];
	}
	
	public void add(Npc npcs) {
        if (arraySize != nonPlayableChara.length) {
        	nonPlayableChara[arraySize] = npcs;
            arraySize++;
        }
    }
	public Npc currentNpc(int index) {
		return nonPlayableChara[index];
	}

	public Npc[] getNpc() {
		return nonPlayableChara;
	}

	public void setNpcs(Npc[] nonNpcs) {
		this.nonPlayableChara = nonNpcs;
	}
}