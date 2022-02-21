package test;

import gui.WelcomePage;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 *
 */
public class testPrinc {
	public static void main(String[] args) {

		WelcomePage titname = new WelcomePage("Shiva's Quests");

		Thread gameThread = new Thread(titname);
		gameThread.start();
	}
}
