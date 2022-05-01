package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
	
	private Container contentPane = new Container();
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();

	private JLabel title = new JLabel("Quêtes principales : ");
	private JLabel title2 = new JLabel("Choix de l'arme : ");
	private JLabel title3 = new JLabel("Quêtes secondaires : ");
	private JLabel cristaux = new JLabel("- Récuperer les 3 cristaux (0/3)");
	private JLabel boss = new JLabel("- Battre le boss final (0/1)");
	private JLabel miniMons = new JLabel("- Battre 2 mini monstres (0/2)");
	private JLabel gardien = new JLabel("- Battre 2 gardiens (0/2)");
	private JLabel niv = new JLabel("- Débloquer le niveau 5 (0/1)");
	private JLabel dialogue = new JLabel("Npc dialogue :");
	private JLabel level = new JLabel("Niveau 1");
	private JLabel exp = new JLabel("Nombre d'EXP : 0/500");
	private JLabel or = new JLabel("Nombre d'Or : 0");
	
	private JButton boutton1 = new JButton("Attaquer");
	private JButton boutton2 = new JButton("Fuire le combat");
	private JButton boutton3 = new JButton("Options");
	private JButton boutton4 = new JButton("Récuperer");
	private JButton boutton5 = new JButton("Lancer le sort");
	
	private JRadioButton pinakaButton = new JRadioButton("l'arc de la Destruction (× infini)");
	private JRadioButton trishulButton = new JRadioButton("Trident (× 2)");
	private JRadioButton casqueButton = new JRadioButton("Casque (× 1)");
	
	private ButtonGroup groupChoice = new ButtonGroup();
	
	private JTextArea affDialogue = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(affDialogue);
	
	public MainGUI(String title) {
		super(title);
		init(); 
	}
	
	private void init() {
		
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		KeyControls keyControls = new KeyControls();
		addKeyListener(keyControls);
		boutton1.addKeyListener(keyControls);     
		
		
		map = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(map);
		dashboard = new GameDisplay(map, manager);
	
		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard, BorderLayout.CENTER);
		
		   
		boutton3.addKeyListener(keyControls);
		dashboard.add(boutton3);
		boutton3.addActionListener(new OptWindow());
		
		boutton2.addKeyListener(keyControls);
		boutton2.addActionListener(new BattleFail());
		
		boutton1.addActionListener(new AttackBattle());
		
		groupChoice.add(pinakaButton);
		groupChoice.add(trishulButton);
		groupChoice.add(casqueButton);
		
		pinakaButton.addActionListener(new ChoiceOfWeapon());
		trishulButton.addActionListener(new ChoiceOfWeapon());
		casqueButton.addActionListener(new ChoiceOfWeapon());
		
		boutton4.addActionListener(new RecupButton());
		boutton5.addActionListener(new FireButton());
		
		p1.add(boutton1);
		p1.add(boutton4);
		p1.add(boutton2);
		p1.add(boutton5);
		boutton5.setVisible(false);
		p1.setPreferredSize(new Dimension(0, 45));
		p1.setBackground(Color.black);
		p1.setVisible(false);
		contentPane.add(p1, BorderLayout.SOUTH);
		
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		p2.setBackground(Color.lightGray);
		p2.add(Box.createRigidArea(new Dimension(10, 0)));
		title.setFont(new Font("TimesRoman", Font.BOLD, 19));
		title.setForeground(Color.BLACK);
		
		
		p2.add(title);
		p2.add(Box.createRigidArea(new Dimension(0, 5))); 
		cristaux.setForeground(Color.BLACK);
		cristaux.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		
		p2.add(cristaux);
		boss.setForeground(Color.BLACK);
		boss.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		
		p2.add(boss);
		title3.setForeground(Color.BLACK);
		title3.setFont(new Font("TimesRoman", Font.BOLD, 19));
		
		
		p2.add(title3);
		p2.add(Box.createRigidArea(new Dimension(0, 5)));
		miniMons.setForeground(Color.BLACK);
		miniMons.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		
		p2.add(miniMons); 
		gardien.setForeground(Color.BLACK);
		gardien.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		
		p2.add(gardien);
		niv.setForeground(Color.BLACK);
		niv.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		
		p2.add(niv); 
		p2.add(Box.createRigidArea(new Dimension(0, 20)));
		dialogue.setForeground(Color.BLACK);
		dialogue.setFont(new Font("SansSerif", Font.BOLD, 15));
		
		
		p2.add(dialogue);
		affDialogue.addKeyListener(keyControls);
		affDialogue.setEditable(false);
		affDialogue.setLineWrap(true);
		affDialogue.setWrapStyleWord(true);
		affDialogue.setBackground(Color.WHITE);
		affDialogue.setForeground(Color.RED);
		affDialogue.setFont(new Font("Verdana", Font.BOLD, 13));
		p2.add(scrollPane);
		
		
		level.setForeground(Color.BLACK);
		level.setFont(new Font("SansSerif", Font.BOLD, 20));
		p2.add(level);
		exp.setForeground(Color.BLACK);
		exp.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		
		p2.add(exp);
		or.setForeground(Color.BLACK);
		or.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		
		p2.add(or);
		p2.add(Box.createRigidArea(new Dimension(0, 200)));
		p2.setPreferredSize(new Dimension(200, 600));
		contentPane.add(p2, BorderLayout.WEST);
		
		p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
		p3.setBackground(Color.GRAY);
		p3.add(Box.createRigidArea(new Dimension(10, 40)));
		title2.setFont(new Font("Poor Richard", Font.BOLD, 20));
		title2.setForeground(Color.BLACK);
		
		
		p3.add(title2);
		p3.add(Box.createRigidArea(new Dimension(30, 70)));
		pinakaButton.setForeground(Color.BLACK);
		pinakaButton.setBackground(Color.GRAY);
		
		
		p3.add(pinakaButton);
		p3.add(Box.createRigidArea(new Dimension(30, 70)));
		trishulButton.setForeground(Color.BLACK);
		trishulButton.setBackground(Color.GRAY);
		
		
		p3.add(trishulButton);
		p3.add(Box.createRigidArea(new Dimension(30, 70)));
		casqueButton.setForeground(Color.BLACK);
		casqueButton.setBackground(Color.GRAY);
		
		
		p3.add(casqueButton);
		p3.setVisible(false);
		p3.setPreferredSize(new Dimension(200, 600));
		contentPane.add(p3, BorderLayout.EAST);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void run() {
		
		int time = 1, time2 = 1;
		
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			manager.nextRound();
			dashboard.repaint();
			
			if(manager.getPoint().getQuitPressed() == true) {
				groupChoice.clearSelection();
			}
			
			if((manager.getCollisionMonsterOn() == true)) { // on rentre en phase de combat
				p1.setVisible(true);
				p2.setVisible(false);
				p3.setVisible(true);
				if(manager.getUseTrident() == 0 || manager.getHasTrident() == false) {
					trishulButton.setVisible(false);
				}
				if(manager.getUseTrident() != 0 && manager.getHasTrident() == true) {
					trishulButton.setVisible(true);
				}
				if(manager.getUseCasque() == 0 || manager.getCanUseCasque() == false || manager.getHasCasque() == false) {
					casqueButton.setVisible(false);
				}
				if(manager.getCanUseCasque() == true && manager.getUseCasque() != 0 && manager.getHasCasque() == true) {
					casqueButton.setVisible(true);
				}
				trishulButton.setText("Trident (× "+manager.getUseTrident()+")");
				casqueButton.setText("Casque (× "+manager.getUseCasque()+")");
				if(manager.getMaskButton5() == true) {
					boutton5.setVisible(false);
				}
				manager.getPoint().setQuitPressed(false);
				try {
					Thread.sleep(60);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				manager.generateOneProjectileMons();
				if((manager.getMaskButton1() == true && manager.getPlayerTouched() == false)
						|| manager.getChoiceSelected() == false  || manager.getCasqueSelected() == false) { //si le joueur nest pas toucher et quil a pas choisi alors on rend invisible le boutton attaquer
					boutton1.setVisible(false);
					manager.setMaskButton1(false);
					boutton4.setVisible(false);
				} 
				if((manager.getMaskButton1() == false && manager.getPlayerTouched() == true)) { // si le joueur est toucher
					if(manager.getChoiceSelected() != false && manager.getCasqueSelected() == false) { //on rend visible le boutton attaquer que si il a choisi
						boutton1.setVisible(true);
						boutton4.setVisible(false);
					}
					manager.setPlayerTouched(false);
				} 
				if(manager.getChoiceSelected() != false && manager.getCasqueSelected() == false) { //si il a choisi alors on rend visible le boutton attaque
					boutton1.setVisible(true);
					boutton4.setVisible(false);
				}
				if(manager.getCasqueSelected() == true) { // si loption casque est sectionner on affiche le boutton recuperer
					boutton4.setVisible(true);
				}
				if(manager.getMaxLvlReached() == 1 && manager.getUseFeu() > 0 && manager.getMaskButton5() == false) {
					boutton5.setVisible(true);
				}
			}
			
			if((manager.getPoint().getIsDead() == true) || manager.getPoint().getHeWon() == true) { // on revient a la normal si le joueur a perdu ou gagner
				p1.setVisible(false);
				p2.setVisible(true);
				p3.setVisible(false);
				manager.setCollisionMonsterOn(false);	
			}
			
			cristaux.setText("- Récuperer les 3 cristaux ("+manager.getHasCrystal()+"/3)");
			boss.setText("- Battre le boss final ("+manager.getBossDefeated()+"/1)");
			miniMons.setText("- Battre 2 mini monstres ("+manager.getMiniMonsterDefeated()+"/2)");
			gardien.setText("- Battre 2 gardiens ("+manager.getGardienDefeated()+"/2)");
			niv.setText("- Débloquer le niveau 5 ("+manager.getMaxLvlReached()+"/1)");
			level.setText("Niveau "+manager.getNiveau());
			exp.setText("Nombre d'EXP : "+manager.getExpCourant()+"/"+manager.getExpMaximum());
			or.setText("Nombre d'Or : "+manager.getNbrOr());
			affDialogue.setText(manager.getDialogueNpc());
			
			if(manager.getNpcDialogueActived() == false) {
				affDialogue.setText("");
			}
		
			
			
			if(manager.getMaxLvlReached() == 1 && time > 0) {
				time--;
				JOptionPane.showMessageDialog(null,"Bravo ! vous avez atteint le niveau maximum du jeu, vous venez de débloquer un nouveau sort.");
			}
			if(manager.getBossDefeated() == 1 && time2 > 0) {
				time2--;
				JOptionPane.showMessageDialog(null,"Félicitation ! vous avez rétabli la paix dans le monde des Hommes.");
			}
		}	
	}
	

	private class KeyControls implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent event) { //le joueur peut se deplacer que si la touche qu'il est entrain dappuyer est relacher
			char keyChar = event.getKeyChar();
			switch (keyChar) {
			case 'q':
					manager.getPoint().setLeftPressed(true);
					manager.getPlayer().setLeftPressed(true);
					manager.moveLeftPlayerFictional();
					manager.moveLeftPlayer();
				break;
			case 'd':
					manager.getPoint().setRightPressed(true);
					manager.getPlayer().setRightPressed(true);
					manager.moveRightPlayerFictional();
					manager.moveRightPlayer();
				break;
			case 'z':
					manager.getPoint().setUpPressed(true);
					manager.getPlayer().setUpPressed(true);
					manager.moveTopPlayerFictional();
					manager.moveTopPlayer();
				break;
			case 's':
					manager.getPoint().setDownPressed(true);
					manager.getPlayer().setDownPressed(true);
					manager.moveBottomPlayerFictional();
					manager.moveBottomPlayer();
			default:
				break;
			}
		}
	}
	
	/*
	* action Listeners
	 */
	private class OptWindow implements ActionListener {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		if(e.getSource()==boutton3) {
	    			
	    			new OptionsWindow("Options");
	
	    		}
	    	}
	}
	
	private class BattleFail implements ActionListener {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		if((e.getSource()==boutton2)) {
	    			p1.setVisible(false);
	    			p2.setVisible(true);
	    			p3.setVisible(false);
	    			manager.setCollisionMonsterOn(false);
	    			manager.getPoint().setCollisionMons(false);
	    			manager.getPoint().setQuitPressed(true);
	    		}
	    	}
	}
	
	private class AttackBattle implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		if(e.getSource()==boutton1) {
    			
    			groupChoice.clearSelection();
    		    manager.setChoiceSelected(false);
    			manager.generateProjectileHero();
    			manager.setMaskButton1(true);
    		}
    	}
	}
	
	private class ChoiceOfWeapon implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		
    		if(e.getSource()==pinakaButton) {
    			manager.setChoiceNum(1);
    			manager.setChoiceSelected(true);
    			manager.setCasqueSelected(false);
    		} else if(e.getSource()==trishulButton) {
    			manager.setChoiceNum(2);
    			manager.setChoiceSelected(true);
    			manager.setCasqueSelected(false);
    		} else if(e.getSource()==casqueButton) {
    			manager.setChoiceNum(3);
    			manager.setCasqueSelected(true);
    			manager.setChoiceSelected(false);
    		}
    		
    	}
	}
	
	private class RecupButton implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
    		
    		if(e.getSource()==boutton4) {
    			manager.casquePower();
    			manager.setUseCasque(0);
    			manager.setCasqueSelected(false);
    		}
		}	
	}
	
	private class FireButton implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
    		
    		if(e.getSource()==boutton5) {
    			
    			groupChoice.clearSelection();
    			manager.setChoiceNum(4);
    			manager.generateProjectileFeu();
    			manager.setMaskButton5(true);
    		}
		}	
	}
	
}