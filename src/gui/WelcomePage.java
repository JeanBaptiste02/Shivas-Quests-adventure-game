package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

import java.awt.Container;

import configuration.GameConfiguration;
import motor.map.Map;
import motor.process.MobileElementManager;

import java.awt.Font;



@SuppressWarnings("serial")
public class WelcomePage extends JFrame implements Runnable{
	
	private JFrame mafenetre;
	private Container myfem;
	private JPanel rightSidePan;
	private JLabel mainTitle;
	private JButton start, achieve, help;
	
	private Font titleStyle;
	
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
	


	
	public WelcomePage(String title) {
		super(title);
		init();
	}

	private void init() {
		
		mafenetre = new JFrame();
		myfem = mafenetre.getContentPane();
		mafenetre.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mafenetre.setSize(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
		mafenetre.setVisible(true);
		mafenetre.setResizable(false);
		myfem.setLayout(new BoxLayout(mafenetre.getContentPane(), BoxLayout.X_AXIS));

		
		mainTitle = new JLabel("Shiva's Quests");
		mainTitle.setAlignmentY(0.0f);
		mainTitle.setFont(new Font("Stencil", Font.BOLD, 35));
		mainTitle.setForeground(Color.RED);
		myfem.add(mainTitle);
		
		rightSidePan = new JPanel();
		rightSidePan.setBackground(Color.GRAY);
		myfem.add(rightSidePan);
		rightSidePan.setLayout(null);
		
		start = new JButton("Start");
		start.setBackground(Color.BLUE);
		start.setForeground(Color.RED);
		start.setBounds(300, 161, 120, 31);
		rightSidePan.add(start);
		start.addActionListener(new startGame());
		
		achieve = new JButton("Achievements");
		achieve.setBackground(Color.BLUE);
		achieve.setForeground(Color.RED);
		achieve.setBounds(300, 218, 120, 31);
		rightSidePan.add(achieve);
		
		help = new JButton("Help");
		help.setBackground(Color.BLUE);
		help.setForeground(Color.RED);
		help.setBounds(300, 276, 120, 31);
		rightSidePan.add(help);
		
		
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			mafenetre.repaint();
		}
		
	}
	
private class startGame implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		if(e.getSource()==start) {
    			
    			MainGUI gameMainGUI = new MainGUI("Shiva's Quests");

    			Thread gameThread = new Thread(gameMainGUI);
    			gameThread.start();
    			
    		}
    	}
    }
}