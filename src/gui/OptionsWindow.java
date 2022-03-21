package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.*;
/**
 * this class creates a new window containing more functionnalities for the game
 * @author Damodarane-Elumalai-Zhang
 *
 */
public class OptionsWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p1, p2, p3, p4;
	private JTextField pseudoplace;
	private JTextField time;
	private JTextField maxlvl;
	private GridLayout mygrid;
	private Container contentPane;
	private JLabel pseudolab, chrono, lvlMaximal, equipinfotitle, equipinfo, equipinfo2,equipinfo3,equipinfo4, questInfo, SpeedModif;
	
	/**
	 * constructor
	 * @param title2 is the title of the window : "options"
	 */
	public OptionsWindow(String title2) {
		super(title2);
		init();
	}
	
	/**
	 * this method initiates the window
	 */
	public void init() {
		
		//permet d'afficher la fenetre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 300); //taille
		this.setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true); //pour ne pas agrandir la fenetre
		
		//appel de la fonction initLayout()
		initPane();
	}
	
	/**
	 * creates different widgets/tabs
	 */
	protected void initPane() {
		
		mygrid = new GridLayout(1, 1); 
	    contentPane = getContentPane();
		contentPane.setLayout(mygrid);
		
		JTabbedPane tabs = new JTabbedPane(JTabbedPane.LEFT);
		tabs.setForeground(Color.blue);
		tabs.setBackground(Color.red);	
		
		p1 = new JPanel();
		p1.setBackground(Color.GRAY);
		p1.setLayout(null);
		tabs.add("Profil", p1);
		
		contentp1(); //method which contains all the components of p1
		
		
		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(Color.GRAY);
		tabs.add("Equipements", p2);
		
		contentp2(); //method which contains all the components of p2

		
		p3 = new JPanel();
		p3.setLayout(null);
		p3.setBackground(Color.GRAY);
		tabs.add("Quêtes", p3);
		
		contentp3(); //method which contains all the components of p3
		
		p4 = new JPanel();
		p4.setLayout(null);
		p4.setBackground(Color.GRAY);
		tabs.add("Paramètres", p4);
		
		contentp4(); //method which contains all the components of p4
		
		contentPane.add(tabs); //adding all these tabs to the contentPane

	}
	
	/**
	 * contents of P1
	 */
	public void contentp1() {
		pseudolab = new JLabel("Pseudo");
		pseudolab.setBounds(51, 10, 45, 13);
		p1.add(pseudolab);
		
		pseudoplace = new JTextField();
		pseudoplace.setBounds(51, 22, 96, 19);
		p1.add(pseudoplace);
		
		chrono = new JLabel("Chrono");
		chrono.setBounds(51, 60, 45, 13);
		p1.add(chrono);
		
		time = new JTextField();
		time.setBounds(23, 74, 96, 19);
		p1.add(time);
		
		lvlMaximal = new JLabel("Maximum Levels : 9");
		lvlMaximal.setBounds(166, 60, 150, 13);
		p1.add(lvlMaximal);
		
		maxlvl = new JTextField();
		maxlvl.setBounds(162, 74, 96, 19);
		p1.add(maxlvl);
	}
	
	/**
	 * contents of P2
	 */
	public void contentp2() {
		equipinfotitle = new JLabel("Equipements");
		equipinfotitle.setForeground(Color.WHITE);
		equipinfotitle.setBounds(10, 10, 112, 20);
		p2.add(equipinfotitle);

		equipinfo = new JLabel("« Pinaka »,l’arc Dragon Subduing Palm");
		equipinfo2 = new JLabel("« Trishul », le trident	Diamond Sutra");
		equipinfo3 = new JLabel("Casque	True fire of Samadhi");
		equipinfo4 = new JLabel ("Armure");
		equipinfo.setBounds(10, 68, 600, 19);
		equipinfo2.setBounds(10, 94, 600, 19);
		equipinfo3.setBounds(10, 123, 600, 19);
		equipinfo4.setBounds(10, 152, 600, 19);
		p2.add(equipinfo);
		p2.add(equipinfo2);
		p2.add(equipinfo3);
		p2.add(equipinfo4);
	}
	
	/**
	 * contents of P3
	 */
	public void contentp3() {
		questInfo = new JLabel("Quêtes");
		questInfo.setForeground(Color.WHITE);
		questInfo.setBounds(10, 10, 112, 20);
		p3.add(questInfo);
	}
	
	/**
	 * contents of P4
	 */
	public void contentp4(){
		SpeedModif = new JLabel("Vitesse");
		SpeedModif.setFont(new Font("Tahoma", Font.BOLD, 13));
		SpeedModif.setForeground(Color.GREEN);
		SpeedModif.setBackground(Color.DARK_GRAY);
		SpeedModif.setBounds(130, 56, 75, 22);
		p4.add(SpeedModif);
		
		JSpinner chosSpeedNumb = new JSpinner();
		chosSpeedNumb.setBounds(215, 53, 94, 32);
		p4.add(chosSpeedNumb);
	}
}