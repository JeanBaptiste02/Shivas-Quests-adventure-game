package motor.mobile;


public class Monsters {

		private Monster[] monsters;
		private int arraySize=0;
		
		
		public Monsters(int size) {
			monsters = new Monster[size];
		}
		
		public void add(Monster m) {
	        if (arraySize != monsters.length) {
	        	monsters[arraySize] = m;
	            arraySize++;
	        }
	    }
		
		public void remove(int index) {
			monsters[index] = null;
		}
		
		public Monster currentMonster(int index) {
			return monsters[index];
		}

		public Monster[] getMonsters() {
			return monsters;
		}

		public void setMonsters(Monster[] m) {
			this.monsters = m;
		}
	
}
