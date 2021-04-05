package Base;

import java.awt.Font;

import javax.swing.*;

/**
 * <h1>Chiffres premiers</h1>
 * <p>Programme dédié au calcul des chiffres premiers<p>
 * @author Loris
 */

public class TopLevelWindowsPrimeNumber{

	public static void createTopWindow() {
		
		JFrame frame = new JFrame("TopLevelFrame");
		
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("https://img.icons8.com/pastel-glyph/2x/clock--v2.png").getImage());
		
		JLabel titreLabel = new JLabel("Calcul mesures Pythagore");
		//titreLabel.setBounds(10, 10, 600, 50);
		titreLabel.setFont(new Font("Cascadia Code", 0, 30));
		frame.add(titreLabel);
		
		JTextField valeur_aField = new JTextField("", 10);
		valeur_aField.setBounds(10, 100, 200, 50);
		frame.add(valeur_aField);
		
		JTextField valeur_bField = new JTextField("", 10);
		valeur_bField.setBounds(250, 100, 200, 50);
		frame.add(valeur_bField);
		
		/*JTextField valeur_cField = new JTextField("", 10);
		valeur_cField.setBounds(500, 100, 200, 50);
		frame.add(valeur_cField);*/
		
		frame.pack();
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(600,500);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Starting the interface");
		
		createTopWindow();
		
	}

}