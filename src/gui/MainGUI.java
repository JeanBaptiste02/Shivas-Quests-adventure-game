package gui;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import configuration.GameConfiguration;
import motor.map.Map;
import motor.process.GameBuilder;
import motor.process.MobileElementManager;

/**
 * 
 * @author D.JB E.SRI Z.VIC
 *
 */
public class MainGUI extends JFrame implements Runnable {
	
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
	
	private Map map;
	private MobileElementManager manager;
	private GameDisplay dashboard;
	
	public MainGUI(String title) {
		super(title);
		init();
	}
	
	private void init() {
		
		KeyControls keyControls = new KeyControls();
		addKeyListener(keyControls);
		
		map = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(map);
		dashboard = new GameDisplay(map, manager);
		dashboard.setPreferredSize(preferredSize);
		add(dashboard);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void run() {
		while (true) {
			try {
				
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			dashboard.repaint();
		}
		
	}
	
	private class KeyControls implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			char keyChar = event.getKeyChar();
			switch (keyChar) {

			case 'q': 
					manager.getPlayer().setLeftPressed(true);
					manager.moveLeftPlayer();
				break;
			case 'd':
					manager.getPlayer().setRightPressed(true);
					manager.moveRightPlayer();
				break;
			case 'z':
					manager.getPlayer().setUpPressed(true);
					manager.moveTopPlayer();
				break;
			case 's':
					manager.getPlayer().setDownPressed(true);
					manager.moveBottomPlayer();
			default:
				break;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	

}