package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * this class creates a new window containing more functionnalities for the game
 * @author Damodarane-Elumalai-Zhang
 *
 */
public class OptionsWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p1, p2, p3;
	private JTextField pseudoplace;
	private GridLayout mygrid;
	private Container contentPane;
	private JLabel pseudolab ,WelcomeUsr,WelcomeUsr2; // Label used in the panel 1
	private JLabel infotitle, infotitle2, infotitle3;// Label used in the panel 2 for the titles
	private JTextArea info, info2, info3;
	private JButton recButton;
	
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
		this.setSize(500, 450); //taille
		setVisible(true);
		setResizable(false); //pour ne pas agrandir la fenetre
		
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
		tabs.add("Info", p2);
		
		contentp2(); //method which contains all the components of p2
		
		
		p3 = new JPanel();
		p3.setLayout(null);
		p3.setBackground(Color.GRAY);
		tabs.add("Culture", p3);
		
		contentp3(); //method which contains all the components of p3
		
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
		
		recButton = new JButton("save");
		recButton.setBounds(162, 21, 85, 21);
		recButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeUsr2.setText(pseudoplace.getText());

			}
		});
		p1.add(recButton);
		
		WelcomeUsr = new JLabel("Hello");
		WelcomeUsr.setFont(new Font("Source Serif Pro ExtraLight", Font.PLAIN, 15));
		WelcomeUsr.setForeground(Color.GREEN);
		WelcomeUsr.setBounds(163, 156, 197, 67);
		p1.add(WelcomeUsr);
		
		WelcomeUsr2 = new JLabel("");
		WelcomeUsr2.setFont(new Font("Source Serif Pro ExtraLight", Font.PLAIN, 15));
		WelcomeUsr2.setForeground(Color.BLUE);
		WelcomeUsr2.setBounds(163, 170, 197, 67);
		p1.add(WelcomeUsr2);	
	}	
	
	/**
	 * contents of P2
	 */
	public void contentp2() {

		infotitle = new JLabel("Les Touches :");
		
		
		infotitle.setForeground(Color.WHITE);
		infotitle.setBounds(10, 10, 112, 20);
		p2.add(infotitle);

		info = new JTextArea("La touche « z », permet d'aller vers le haut \n"+"La touche « s », permet d'aller en bas \n"+"La touche « d », permet d'aller vers la droite \n"+"La touche « q »,permet d'aller vers la gauche \n"+"« Le clic gauche », permet de selectionner les bouttons");
	
		info.setBounds(10, 40, 600, 80);
		info.setEditable(false);
		info.setBackground(Color.GRAY);
		info.setFont(new Font("ARIAL", Font.BOLD, 12));
		info.setForeground(Color.BLACK);
		
		p2.add(info);
		
		infotitle2 = new JLabel("Les items et Objets :");
		
		infotitle2.setForeground(Color.WHITE);
		infotitle2.setBounds(10, 120, 112, 20);
		p2.add(infotitle2);
		info2 = new JTextArea("« Le Trishula » est le trident, attribut de Shiva, Un dieu de la mythologie hindouïste. \n" +
							"« Ushnisha » la courronne de Bouddha \n"+
							"« Pinaka » est l'arc original de Shiva utilisé pour la destruction totale \n"+
							"« Le Poing », objet obtenu par la défaite du petit monstre, permet de briser le mur pour avancer dans l'autre partie de la map \n"+
							"« Le Crystal », objet permettant d'ouvrir la barriére permettant de combattre le boss finale \n"+
							"« La clé», objet obtenu par la défaite du mini-bosse (gardien) permettant d'ouvrir la porte au crystal \n");
		
		info2.setBounds(10, 150, 400, 220);
		info2.setEditable(true);
		info2.setBackground(Color.GRAY);
		info2.setFont(new Font("ARIAL", Font.BOLD, 12));
		info2.setForeground(Color.BLACK);
		info2.setLineWrap(true);
		info2.setWrapStyleWord(true);
		p2.add(info2);
		
		}
	
	/**
	 * contents of P2
	 */
	public void contentp3() {

		infotitle3 = new JLabel("Les Monstres :");
		
		
		infotitle3.setForeground(Color.WHITE);
		infotitle3.setBounds(10, 10, 112, 20);
		p3.add(infotitle3);

		info3 = new JTextArea("« Niu Mo Wang » est le boss final de notre jeu, c'est une entité qui appararaît dans la « pérégrination vers l'ouest ».  \n"+
				"« Asuras », Mini-bosss, demi-dieu belligérants du bouddhisme  \n"+
                "«Monstre de feu», mini monstre \n");
	
		info3.setBounds(10, 40, 400, 120);
		info3.setEditable(false);
		info3.setBackground(Color.GRAY);
		info3.setFont(new Font("ARIAL", Font.BOLD, 12));
		info3.setForeground(Color.BLACK);
		info3.setLineWrap(false);
		info3.setLineWrap(true);
		info3.setWrapStyleWord(true);
		
		p3.add(info3);


		
	
	}	
	
	
	
}