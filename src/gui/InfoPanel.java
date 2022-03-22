package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This panel contains information for understanding better that printed line and trains.
 * 
 * @see Dashboard
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class InfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	
	private JLabel labe;

	public InfoPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		setBackground(Color.GRAY);
		
		
		labe = new JLabel("Shiva's Quests");
		
		add(labe);
	}
}