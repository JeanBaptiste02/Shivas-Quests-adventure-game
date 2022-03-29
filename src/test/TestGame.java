package test;

import gui.MainGUI;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 *
 */
public class TestGame {
	public static void main(String[] args) {

		MainGUI gameMainGUI = new MainGUI("Shiva's Quests");

		Thread gameThread = new Thread(gameMainGUI);
		gameThread.start();
	}
}
		
