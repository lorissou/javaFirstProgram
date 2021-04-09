package Base;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
	
	final static String principalThemeColor = "#424340";
	final static String secondaryThemeColor = "#606C5A";
	final static String tertiaryThemeColor = "#384454";
	final static String lightThemeColor = "#C9E3CC";
	final static String JourPrincipalThemeColor = "#ff5722";
	final static String JourSecondaryThemeColor = "#ff8a50";
	final static String JourTertiaryThemeColor = "#c41c00";
	final static String JourLightThemeColor = "#000000";

	//Fonction créer la fenêtre
	public static void createTopWindow() {
		
		// Création de la frame
		JFrame frame = new JFrame("Pythagore - a, b, c");
		GridBagLayout layout = new GridBagLayout();
		frame.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		// Déclaration des Labels
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel aLabel = new JLabel("Valeur de a :");
		aLabel.setForeground(Color.decode(lightThemeColor));
		frame.add(aLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel bLabel = new JLabel("Valeur de b :");
		bLabel.setForeground(Color.decode(lightThemeColor));
		frame.add(bLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel cLabel = new JLabel("Valeur de c :");
		cLabel.setForeground(Color.decode(lightThemeColor));
		frame.add(cLabel, gbc);
		
		// Déclaration des TextFields
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		JTextField valeur_aField = new JTextField("", 12);
		valeur_aField.setBackground(Color.decode(secondaryThemeColor));
		valeur_aField.setForeground(Color.decode(lightThemeColor));
		valeur_aField.setBorder(null);
		frame.add(valeur_aField, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		JTextField valeur_bField = new JTextField("", 12);
		valeur_bField.setBackground(Color.decode(secondaryThemeColor));
		valeur_bField.setForeground(Color.decode(lightThemeColor));
		valeur_bField.setBorder(null);
		frame.add(valeur_bField, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		JTextField valeur_cField = new JTextField("", 12);
		valeur_cField.setBackground(Color.decode(secondaryThemeColor));
		valeur_cField.setForeground(Color.decode(lightThemeColor));
		valeur_cField.setBorder(null);
		frame.add(valeur_cField, gbc);
		
		//Déclaration Bouton calculer
		gbc.gridx = 0;
		gbc.gridy = 3;
		JButton calculateButton = new JButton("Calculer");
		calculateButton.setBackground(Color.decode(tertiaryThemeColor));
		calculateButton.setForeground(Color.decode(lightThemeColor));
		frame.add(calculateButton, gbc);
		calculateButton.addActionListener(new ActionListener() { // Déclaration de l'action à réaliser lors de l'appui du bouton
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calculate(valeur_aField, valeur_bField, valeur_cField);
			}
			
		});
		
		// Bouton effacer les champs
		gbc.gridx = 1;
		gbc.gridy = 3;
		JButton effacerButton = new JButton("Effacer");
		effacerButton.setBackground(Color.decode(tertiaryThemeColor));
		effacerButton.setForeground(Color.decode(lightThemeColor));
		frame.add(effacerButton, gbc);
		effacerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				valeur_aField.setText("");
				valeur_bField.setText("");
				valeur_cField.setText("");
			}
		});
		
		// Déclaration du bouton décimales
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridheight = 3;
		gbc.fill = GridBagConstraints.VERTICAL;
		JComboBox<String> decimalesComboBox = new JComboBox<String>(listeDecimales);
		frame.add(decimalesComboBox, gbc);
		decimalesComboBox.setBackground(Color.decode(tertiaryThemeColor));
		decimalesComboBox.setForeground(Color.decode(lightThemeColor));
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
		
		// Déclaration du menu
		JMenuBar menuBar = new JMenuBar();
		JMenu themeMenu = new JMenu("Thème");
		
		// Déclration des éléments dans le menu
		JMenuItem changerThemeMenuItem = new JMenuItem("Changer de thème");
		ButtonGroup groupeButtonTheme = new ButtonGroup();
		
		// Bouton Jour
		JRadioButtonMenuItem themeRadioButton = new JRadioButtonMenuItem("Jour");
		groupeButtonTheme.add(themeRadioButton);
		themeMenu.add(themeRadioButton);
		themeRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Jour");
				aLabel.setForeground(Color.decode(JourLightThemeColor));
				bLabel.setForeground(Color.decode(JourLightThemeColor));
				cLabel.setForeground(Color.decode(JourLightThemeColor));
				
				valeur_aField.setBackground(Color.decode(JourSecondaryThemeColor));
				valeur_aField.setForeground(Color.decode(JourLightThemeColor));
				
				valeur_bField.setBackground(Color.decode(JourSecondaryThemeColor));
				valeur_bField.setForeground(Color.decode(JourLightThemeColor));
				
				valeur_cField.setBackground(Color.decode(JourSecondaryThemeColor));
				valeur_cField.setForeground(Color.decode(JourLightThemeColor));
				
				calculateButton.setBackground(Color.decode(JourTertiaryThemeColor));
				calculateButton.setForeground(Color.decode(JourLightThemeColor));
				
				effacerButton.setBackground(Color.decode(JourTertiaryThemeColor));
				effacerButton.setForeground(Color.decode(JourLightThemeColor));
				
				decimalesComboBox.setBackground(Color.decode(JourTertiaryThemeColor));
				decimalesComboBox.setForeground(Color.decode(JourLightThemeColor));
				
				menuBar.setBackground(Color.decode(lightThemeColor));
				
				frame.getContentPane().setBackground(Color.decode(JourPrincipalThemeColor));
			}
		});
		
		// Bouton Nuit
		themeRadioButton = new JRadioButtonMenuItem("Nuit");
		themeRadioButton.setSelected(true);
		groupeButtonTheme.add(themeRadioButton);
		themeMenu.add(themeRadioButton);
		themeRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Nuit");
				aLabel.setForeground(Color.decode(lightThemeColor));
				bLabel.setForeground(Color.decode(lightThemeColor));
				cLabel.setForeground(Color.decode(lightThemeColor));
				
				valeur_aField.setBackground(Color.decode(secondaryThemeColor));
				valeur_aField.setForeground(Color.decode(lightThemeColor));
				
				valeur_bField.setBackground(Color.decode(secondaryThemeColor));
				valeur_bField.setForeground(Color.decode(lightThemeColor));
				
				valeur_cField.setBackground(Color.decode(secondaryThemeColor));
				valeur_cField.setForeground(Color.decode(lightThemeColor));
				
				calculateButton.setBackground(Color.decode(tertiaryThemeColor));
				calculateButton.setForeground(Color.decode(lightThemeColor));
				
				effacerButton.setBackground(Color.decode(tertiaryThemeColor));
				effacerButton.setForeground(Color.decode(lightThemeColor));
				
				decimalesComboBox.setBackground(Color.decode(tertiaryThemeColor));
				decimalesComboBox.setForeground(Color.decode(lightThemeColor));
				
				menuBar.setBackground(Color.decode(lightThemeColor));
				
				frame.getContentPane().setBackground(Color.decode(principalThemeColor));
				
			}
		});
		
		
		menuBar.add(themeMenu);
		menuBar.setBackground(Color.decode(lightThemeColor));
		menuBar.setForeground(Color.BLACK);
		
		frame.setJMenuBar(menuBar);
		
		//Rendre visible l'interface
		frame.getContentPane().setBackground(Color.decode(principalThemeColor));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(450,300);
	}
	
	// Fonction calculer
	public static void calculate(JTextField a,JTextField b,JTextField c) {
		
		// Remplace les virgules par des points --> Eviter les erreur lors des String vers Double
		if (a.getText().contains(",") == true) {a.setText(a.getText().replace(",", "."));}
		if (b.getText().contains(",") == true) {b.setText(b.getText().replace(",", "."));}
		if (c.getText().contains(",") == true) {c.setText(c.getText().replace(",", "."));}
		
		// Créer une variable avec le nombre de cases vides
		ArrayList<String> numberOfEmpty = new ArrayList<String>();
		
		if (a.getText().isEmpty() == true) {numberOfEmpty.add("a");}
		if (b.getText().isEmpty() == true) {numberOfEmpty.add("b");}
		if (c.getText().isEmpty() == true) {numberOfEmpty.add("c");}
		
		// Initialiser les variables des valeurs des cases
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
					String ligne4 = "Pour être vérifiées, les valeurs sont arrondies\nles décimales ne sont donc pas garanties";
					
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
					
					if (b_val % 1 != 0) {b.setText(String.valueOf(String.format("%." + tmp_numberOfDecimal + "g%n", b_val)));}
					else if (b_val % 1 == 0) {b.setText(String.valueOf((int) b_val));}
					else {OptionPaneSwing.showFatalError("Erreur fatale");}
				
				} 
				
				// b & c != null ; a == null
				else if (a.getText().isEmpty() == true && b.getText().isEmpty() == false && c.getText().isEmpty() == false) {
					
					b_val = Double.parseDouble(b.getText());
					c_val = Double.parseDouble(c.getText());
					
					a_val = Math.sqrt(Math.pow(c_val, 2) - Math.pow(b_val, 2));
					
					if (a_val % 1 != 0) {a.setText(String.valueOf(String.format("%." + tmp_numberOfDecimal + "g%n", a_val)));}
					else if (a_val % 1 == 0) {a.setText(String.valueOf((int) a_val));}
					else {OptionPaneSwing.showFatalError("Erreur fatale");}
				}
				
			} 
			
			// Si cases en erreur
		else if (numberOfEmpty.size() > 3 || numberOfEmpty.size() < -1) {OptionPaneSwing.showFatalError("Erreur fatale"); }
		else if (numberOfEmpty.size() == 3) { OptionPaneSwing.showDialog("Veuillez rentrer au moins deux valeurs dans les champs", "Erreur", 2); }
			
		} catch (NumberFormatException e) {
			OptionPaneSwing.showDialog("Veuillez insérer uniquement des caractères numériques...", "Erreur syntaxe", 0);
		}
		
	}
	
	// Fonction d'initialisation
	public static void main(String[] args) {
		
		System.out.println("Starting the interface\n");
		
		OptionPaneSwing.showDialog("Programme de calcul à l'aide du théorème de Pythagore\nSachant que \"c\" est hypothénuse", "", 1);
		
		createTopWindow();
		
	}

}