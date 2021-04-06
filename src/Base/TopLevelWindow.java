package Base;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

import Old.Utils;

/**
 * <h1>Chiffres premiers</h1>
 * <p>Programme dédié au calcul des chiffres premiers<p>
 * @author Loris
 */

public class TopLevelWindow {

	public static void createTopWindow() {
		
		JFrame frame = new JFrame("Pythagore - a, b, c");
		
		// Déclaration des TextField
		JTextField valeur_aField = new JTextField("", 10);
		frame.add(valeur_aField);
		
		JTextField valeur_bField = new JTextField("", 10);
		frame.add(valeur_bField);
		
		JTextField valeur_cField = new JTextField("", 10);
		frame.add(valeur_cField);
		
		JButton calculateButton = new JButton("Calculer");
		frame.add(calculateButton);
		calculateButton.addActionListener(new ActionListener() { // Déclaration de l'action à réaliser lors de l'appui du bouton
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calculate(valeur_aField, valeur_bField, valeur_cField);
			}
			
		});
		
		// Bouton effacer les champs
		JButton effacerButton = new JButton();
		frame.add(effacerButton);
		effacerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//Rendre visible l'interface
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.pack();
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setSize(500,75);
		
	}
	
	public static void calculate(JTextField a,JTextField b,JTextField c) {
		
		if (a.getText().contains(",") == true) {a.setText(a.getText().replace(",", "."));}
		if (b.getText().contains(",") == true) {b.setText(b.getText().replace(",", "."));}
		if (c.getText().contains(",") == true) {c.setText(c.getText().replace(",", "."));}
		
		ArrayList<String> numberOfEmpty = new ArrayList<String>();
		
		if (a.getText().isEmpty() == true) {numberOfEmpty.add("a");}
		if (b.getText().isEmpty() == true) {numberOfEmpty.add("b");}
		if (c.getText().isEmpty() == true) {numberOfEmpty.add("c");}
		
		double a_val = 0;
		double b_val = 0;
		double c_val = 0;
		
		try {
			
			System.out.println("Demande avec [" + numberOfEmpty.size() + "] de case(s) libre " + numberOfEmpty);
			System.out.println("Demande avec a=" + a_val + " b=" + b_val + " c=" + c_val);
			
			// Si 1 case de remplie
			if (numberOfEmpty.size() == 2) { OptionPaneSwing.showDialog("Veuillez remplir au minimum 2 champs", "Erreur utilisateur", 0); }
			
			// Si 3 cases de remplies --> calculer si bon ou pas
			else if (numberOfEmpty.size() == 0) {
				
				a_val = Double.parseDouble(a.getText());
				b_val = Double.parseDouble(b.getText());
				c_val = Double.parseDouble(c.getText());
				
				if (Math.ceil(Math.pow(a_val, 2) + Math.pow(b_val, 2)) == Math.ceil(Math.pow(c_val, 2))) {System.out.println("Hello");}
				
				OptionPaneSwing.showDialog("Calcul", "", 1);
				
				}
			
			// Si 2 cases de remplies
			else if (numberOfEmpty.size() == 1) { 
			
				if (a.getText().isEmpty() == true && b.getText().isEmpty() == true && c.getText().isEmpty() == true) {
					OptionPaneSwing.showDialog("Veuillez remplir tous les champs...", "Erreur", 2);
				}
				if (a.getText().isEmpty() == false && b.getText().isEmpty() == false && c.getText().isEmpty() == true) {
					
					// a & b != null ; c == null
					a_val = Double.parseDouble(a.getText());
					b_val = Double.parseDouble(b.getText());
					
					c_val = Math.sqrt(Math.pow(a_val, 2) + Math.pow(b_val, 2));
					
					if (c_val % 1 != 0) {c.setText(String.valueOf(c_val));}
					else if (c_val % 1 == 0) {c.setText(String.valueOf((int) c_val));}
					else {OptionPaneSwing.showFatalError("Erreur fatale");}
				
				} else if (a.getText().isEmpty() == false && b.getText().isEmpty() == true && c.getText().isEmpty() == false) {
					
					// a & c != null ; b == null
					
					a_val = Double.parseDouble(a.getText());
					c_val = Double.parseDouble(c.getText());
					
					b_val = Math.sqrt(Math.pow(c_val, 2) - Math.pow(a_val, 2));
					
					if (b_val % 1 != 0) {b.setText(String.valueOf(b_val));}
					else if (b_val % 1 == 0) {b.setText(String.valueOf((int) b_val));}
					else {OptionPaneSwing.showFatalError("Erreur fatale");}
				
				} else if (a.getText().isEmpty() == true && b.getText().isEmpty() == false && c.getText().isEmpty() == false) {
					
					// b & c != null ; a == null
					
					b_val = Double.parseDouble(b.getText());
					c_val = Double.parseDouble(c.getText());
					
					a_val = Math.sqrt(Math.pow(c_val, 2) - Math.pow(b_val, 2));
					
					if (a_val % 1 != 0) {a.setText(String.valueOf(a_val));}
					else if (a_val % 1 == 0) {a.setText(String.valueOf((int) a_val));}
					else {OptionPaneSwing.showFatalError("Erreur fatale");}
				}
				
			} 
			
			// Si cases en erreur
			else if (numberOfEmpty.size() > 3 || numberOfEmpty.size() < -1) {OptionPaneSwing.showFatalError("Erreur fatale"); }
			
		} catch (NumberFormatException e) {
			OptionPaneSwing.showDialog("Veuillez insérer uniquement des caractères numériques...", "Erreur syntaxe", 0);
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Starting the interface");
		
		OptionPaneSwing.showDialog("Programme de calcul à l'aide du théorème de Pythagore\nSachant que \"c\" est hypothénuse", "", 1);
		
		createTopWindow();
		
	}

}