package Base;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OptionPaneSwing extends JFrame {
	private static final long serialVersionUID = 4038914321129666366L;
	
	final static String programName = "Pythagore";

	/**
	 * Fonction invoquant une fen�tre d'erreur avec un message personnalis�
	 * @author Lorissou_
	 * @param message Message affich� dans la bo�te de dialogue
	 */
	
	public static void showDialog(String message) {
		
		showMessagePane(message, "", 2, null);
		
	}
	
	/**
	 * Fonction invoquant une fen�tre d'erreur avec un message personnalis�
	 * @author Lorissou_
	 * @param message Message affich� dans la bo�te de dialogue
	 * @param titre Titre de la bo�te de dialogue
	 */
	
	public static void showDialog(String message, String titre) {
		
		showMessagePane(message, titre, 2, null);
		
	}
	
	/**
	 * Fonction invoquant une fen�tre de dialogue avec un message personnalis�
	 * @author Lorissou_
	 * @param message Message affich� dans la bo�te de dialogue
	 * @param titre Titre de la bo�te de dialogue
	 * @param messageType Type de message WARNING / INFORMATION / ...
	 */
	
	public static void showDialog(String message, String titre, int messageType) {
		
		showMessagePane(message, titre, messageType, null);
		
	}
	
	/**
	 * Fonction pour g�n�rer des messages fatal dans une OptionPane de swing
	 * @author Lorissou_
	 * @param message Message personnalis� dans la zone de texte
	 */
	
	public static void showFatalError(String message) {
	
		showMessagePane(message, "Erreur fatale", 0, null);
		
		System.exit(1);
		
	}
	
	/**
	 * Fonction invoquant une fen�tre OptionPane de message, avec un message, titre, code et icone de d�faut personnalis�
	 * @author Loris
	 * @param message Message affich� dans la bo�te de dialogue
	 * @param titre Titre de la bo�te de dialogue
	 * @param messageType Personnalisation de l'image de d�faut dans la bo�te de dialogue
	 * @param icone Icone de la bo�te de dialogue
	 */
	
	public static void showMessagePane (String message, String titre, int messageType, Icon icone) {
		
		JOptionPane.showMessageDialog(new JFrame(), message, programName + " - " + titre, messageType, icone);
		
	}
}
