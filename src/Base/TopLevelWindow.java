package Base;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * <h1>Chiffres premiers</h1>
 * <p>Programme dédié au calcul des chiffres premiers<p>
 * @author Loris
 */

public class TopLevelWindow {
	
	final static String[] listeDecimales = {"0 décimales", "1 decimale", "2 décimales", "3 décimales", "4 décimales", "5 décimales", "6 décimales"};
	static int numberOfDecimals = 3;

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
		JButton effacerButton = new JButton("Effacer");
		frame.add(effacerButton);
		effacerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				valeur_aField.setText("");
				valeur_bField.setText("");
				valeur_cField.setText("");
			}
		});
		
		JComboBox<String> decimalesComboBox = new JComboBox<String>(listeDecimales);
		frame.add(decimalesComboBox);
		decimalesComboBox.setSelectedIndex(numberOfDecimals);
		decimalesComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unchecked")
				JComboBox<String> cb = (JComboBox<String>) e.getSource(); // Récupérer la combo box dans le Listener
				int indexElementChoisi = cb.getSelectedIndex(); // get l'index du séléectionné
		        System.out.println("Décimales choisie : " + indexElementChoisi + "\n");
		        numberOfDecimals = indexElementChoisi; // set la var globale à la valeur choisie
				
			}
		});
		
		//Rendre visible l'interface
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.pack();
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setSize(700,75);
		
	}
	
	// Fonction calculer
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
		
		int tmp_numberOfDecimal = numberOfDecimals + 1;
		
		try {
			
			// Si 1 case de remplie
			if (numberOfEmpty.size() == 2) { OptionPaneSwing.showDialog("Veuillez remplir au minimum 2 champs", "Erreur utilisateur", 0); }
			
			// Si 3 cases de remplies --> calculer si bon ou pas
			else if (numberOfEmpty.size() == 0) {
				
				a_val = Double.parseDouble(a.getText());
				b_val = Double.parseDouble(b.getText());
				c_val = Double.parseDouble(c.getText());
				
				// Cas ou l'égalité est bon
				if (Math.ceil(Math.pow(a_val, 2) + Math.pow(b_val, 2)) == Math.ceil(Math.pow(c_val, 2))) {
					
					String ligne1 = "L'équation A² + B² = C² est vérifiée :";
					String ligne2 = Math.ceil(a_val) + "² + " + Math.ceil(b_val) + "² = " + Math.ceil(c_val) + "²";
					String ligne3 = Math.ceil(Math.pow(a_val, 2)) + " + " + Math.ceil(Math.pow(b_val, 2)) + " = " + Math.ceil(Math.pow(c_val, 2));
					String ligne4 = "Les valeurs sont arrondies pour être vérifiées\n cela ne garanti donc pas vos décimales";
					
					String message = ligne1 + "\n" + ligne2 + "\n" + ligne3 + "\n" + ligne4;
					
					OptionPaneSwing.showDialog(message, "L'équation est vérifiée", 1);
					
				} else {
					
					String ligne1 = "L'équation A² + B² = C² n'est pas est vérifiée :";
					String ligne2 = Math.ceil(a_val) + "² + " + Math.ceil(b_val) + "² ≠ " + Math.ceil(c_val) + "²";
					String ligne3 = Math.ceil(Math.pow(a_val, 2)) + " + " + Math.ceil(Math.pow(b_val, 2)) + " ≠ " + Math.ceil(Math.pow(c_val, 2));
					String ligne4 = "Les valeurs sont arrondies pour être vérifiées\n cela ne garanti donc pas vos décimales";
					
					String message = ligne1 + "\n" + ligne2 + "\n" + ligne3 + "\n" + ligne4;
					
					OptionPaneSwing.showDialog(message, "L'équation est vérifiée", 1);
					
				}
				
			}
			
			// Si 2 cases de remplies
			else if (numberOfEmpty.size() == 1) { 
			
				if (a.getText().isEmpty() == true && b.getText().isEmpty() == true && c.getText().isEmpty() == true) {
					OptionPaneSwing.showDialog("Veuillez remplir tous les champs...", "Erreur", 2);
				}
				
				// a & b != null ; c == null
				if (a.getText().isEmpty() == false && b.getText().isEmpty() == false && c.getText().isEmpty() == true) {
					
					a_val = Double.parseDouble(a.getText());
					b_val = Double.parseDouble(b.getText());
					
					c_val = Math.sqrt(Math.pow(a_val, 2) + Math.pow(b_val, 2));
					
					if (c_val % 1 != 0) {c.setText(String.valueOf(String.format("%." + tmp_numberOfDecimal + "g%n", c_val)));}
					else if (c_val % 1 == 0) {c.setText(String.valueOf((int) c_val));}
					else {OptionPaneSwing.showFatalError("Erreur fatale");}
				
				} 
				
				// a & c != null ; b == null
				else if (a.getText().isEmpty() == false && b.getText().isEmpty() == true && c.getText().isEmpty() == false) {
					
					a_val = Double.parseDouble(a.getText());
					c_val = Double.parseDouble(c.getText());
					
					b_val = Math.sqrt(Math.pow(c_val, 2) - Math.pow(a_val, 2));
					
					if (b_val % 1 != 0) {b.setText(String.valueOf(b_val));}
					else if (b_val % 1 == 0) {b.setText(String.valueOf(String.format("%." + tmp_numberOfDecimal + "g%n", b_val)));}
					else {OptionPaneSwing.showFatalError("Erreur fatale");}
				
				} 
				
				// b & c != null ; a == null
				else if (a.getText().isEmpty() == true && b.getText().isEmpty() == false && c.getText().isEmpty() == false) {
					
					b_val = Double.parseDouble(b.getText());
					c_val = Double.parseDouble(c.getText());
					
					a_val = Math.sqrt(Math.pow(c_val, 2) - Math.pow(b_val, 2));
					
					if (a_val % 1 != 0) {a.setText(String.valueOf(a_val));}
					else if (a_val % 1 == 0) {a.setText(String.valueOf(String.format("%." + tmp_numberOfDecimal + "g%n", a_val)));}
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