package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import java.awt.Container;

import configuration.GameConfiguration;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


/**
 * 
 * @author D.JB E.SRI Z.VIC
 * cette classe permet de construire la page d'accueil du jeu presentant les principaux options du jeu
 *
 */
@SuppressWarnings("serial")
public class WelcomePage extends JFrame implements Runnable{
	
	private JFrame mafenetre;
	private Container contenu;
	private JPanel titre, pantitle, panStart;
	private JLabel nomtitre;
	private JButton start, achievements, help;

	Font titreStyle = new Font("Time New Roman", Font.PLAIN,50);
	
	


	
	public WelcomePage(String title) {
		super(title);
		init();
	}

	private void init() {
		
		mafenetre = new JFrame();
		mafenetre.setSize(800,600);
		mafenetre.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mafenetre.getContentPane().setBackground(Color.gray);
		mafenetre.setVisible(true);
		contenu = mafenetre.getContentPane();
		
		titre = new JPanel();
		titre.setBounds(90,90,300,110);
		titre.setBackground(Color.red);
		
		pantitle = new JPanel();
		nomtitre = new JLabel("Shiva's Quests");
		nomtitre.setForeground(Color.blue);
		nomtitre.setFont(titreStyle);
		contenu.add(nomtitre);
		
		panStart = new JPanel();
		panStart.setBounds(200,200,90,40);
		panStart.setBackground(Color.black);
		contenu.add(titre);
		
		start = new JButton("Start");
		start.setForeground(Color.white);
		start.setBackground(Color.BLUE);
		start.addActionListener(new startGame());

		
		achievements = new JButton("Achievements");
		achievements.setForeground(Color.white);
		achievements.setBackground(Color.BLUE);
		
		help = new JButton("Help");
		help.setForeground(Color.white);
		help.setBackground(Color.BLUE);
		
		GroupLayout compo1 = new GroupLayout(titre);
		compo1.setHorizontalGroup(
			compo1.createParallelGroup(Alignment.LEADING)
			//pour le titre
				.addGroup(compo1.createSequentialGroup()
					.addGap(90)
					.addComponent(nomtitre)
					.addGap(90))
			//pour le boutton start
				.addGroup(Alignment.TRAILING, compo1.createSequentialGroup()
					.addContainerGap(658, Short.MAX_VALUE)
					.addComponent(start, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(25))
			//pour le boutton achievements
				.addGroup(Alignment.TRAILING, compo1.createSequentialGroup()
						.addContainerGap(0, Short.MAX_VALUE)
						.addComponent(achievements, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
						.addGap(25))
			//pour le boutton help
				.addGroup(Alignment.TRAILING, compo1.createSequentialGroup()
						.addContainerGap(0, Short.MAX_VALUE)
						.addComponent(help, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
						.addGap(25))
		);
		compo1.setVerticalGroup(
			compo1.createParallelGroup(Alignment.LEADING)
				.addGroup(compo1.createSequentialGroup()
			//pour le titre
					.addGap(5)
					.addComponent(nomtitre)
					.addGap(102)
					.addComponent(start, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(353, Short.MAX_VALUE))
			//pour le boutton achievements
				.addGroup(Alignment.TRAILING, compo1.createSequentialGroup()
					.addGap(230)
					.addComponent(achievements, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(353, Short.MAX_VALUE))
			//pour le boutton help
				.addGroup(Alignment.TRAILING, compo1.createSequentialGroup()
						.addGap(285)
						.addComponent(help, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(353, Short.MAX_VALUE))
		);
		titre.setLayout(compo1);
		
		
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