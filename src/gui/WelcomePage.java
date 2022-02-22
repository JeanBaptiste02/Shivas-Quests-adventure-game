package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Container;

import configuration.GameConfiguration;


import java.awt.Font;



@SuppressWarnings("serial")
public class WelcomePage extends JFrame{
	
	private JFrame mafenetre;
	private Container myfem;
	private JPanel rightSidePan;
	private JLabel mainTitle;
	private JButton start, achieve, help;
		
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
	
	
	public WelcomePage(String title) {
		super(title);
		init();
	}

	private void init() {
		
		mafenetre = new JFrame();
		myfem = mafenetre.getContentPane();
		mafenetre.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mafenetre.setSize(preferredSize);
		mafenetre.setVisible(true);
		mafenetre.setLocationRelativeTo(null);
		mafenetre.setResizable(false);
		myfem.setLayout(new BoxLayout(mafenetre.getContentPane(), BoxLayout.X_AXIS));

	
		/*title of the page*/
		mainTitle = new JLabel("Shiva's Quests");
		mainTitle.setAlignmentY(0.0f); //using position
		mainTitle.setFont(new Font("Stencil", Font.BOLD, 35));
		mainTitle.setForeground(Color.RED);
		myfem.add(mainTitle); //adding the title to the container
		
		
		/*creating a panel on the right side of the page*/
		rightSidePan = new JPanel();
		rightSidePan.setBackground(Color.GRAY);
		myfem.add(rightSidePan); //adding the panel to the container
		rightSidePan.setLayout(null);
		
		//start button
		start = new JButton("Start");
		start.setBackground(Color.BLUE);
		start.setForeground(Color.RED);
		start.setBounds(300, 161, 120, 31); //setting position and size
		rightSidePan.add(start); //adding the button to the panel
		start.addActionListener(new startGame()); //adding an actionListener to the button
		
		achieve = new JButton("Achievements");
		achieve.setBackground(Color.BLUE);
		achieve.setForeground(Color.RED);
		achieve.setBounds(300, 218, 120, 31);//setting position and size
		rightSidePan.add(achieve);//adding the button to the panel
		
		help = new JButton("Help");
		help.setBackground(Color.BLUE);
		help.setForeground(Color.RED);
		help.setBounds(300, 276, 120, 31);//setting position and size
		rightSidePan.add(help);//adding the button to the panel
		
		
	}
	
	
/*
 * action Listeners
 */
private class startGame implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		if(e.getSource()==start) {
    			
    			mafenetre.dispose();
    			mafenetre.setVisible(false);
    			MainGUI gameMainGUI = new MainGUI("Shiva's Quests");

    			Thread gameThread = new Thread(gameMainGUI);
    			gameThread.start();
    			
    		}
    	}
    }
}