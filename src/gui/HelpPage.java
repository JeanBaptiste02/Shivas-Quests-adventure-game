package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;

import configuration.GameConfiguration;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

@SuppressWarnings("serial")
public class HelpPage extends JFrame{
	
	private JPanel monConten;
	private JLabel title;
	private JLabel contenu;
	
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
	
	public HelpPage(String title) {
		super(title);
		init();
	}	
	
	public void init() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(preferredSize);
		monConten = new JPanel();
		setContentPane(monConten);
		monConten.setBackground(Color.DARK_GRAY);
		monConten.setLayout(new BorderLayout(0, 0));
		
		title = new JLabel("HELP");
		title.setFont(new Font("Stencil", Font.BOLD, 35));
		title.setForeground(Color.RED);
		monConten.add(title, BorderLayout.NORTH);
		
		contenu = new JLabel("blablablablablablablablablablablab");
		contenu.setFont(new Font("Poor Richard", Font.BOLD, 15));
		contenu.setForeground(Color.YELLOW);
		monConten.add(contenu, BorderLayout.WEST);
	}
	
}
