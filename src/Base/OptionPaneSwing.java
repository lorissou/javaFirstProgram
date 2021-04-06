package Base;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OptionPaneSwing extends JFrame {
	private static final long serialVersionUID = 4038914321129666366L;

	public static void showDialog(String message) {
		
		/**
		 * Fonction invoquant une fenêtre d'erreur avec un message personnalisé
		 * @author Lorissou_
		 * @param message Message affiché dans la boîte de dialogue
		 */
		
		showMessagePane(message, "Erreur", 2, null);
		
	}
	
	public static void showDialog(String message, String titre) {
		
		/**
		 * Fonction invoquant une fenêtre d'erreur avec un message personnalisé
		 * @author Lorissou_
		 * @param message Message affiché dans la boîte de dialogue
		 * @param titre Titre de la boîte de dialogue
		 */
		
		showMessagePane(message, titre, 2, null);
		
	}
	
	public static void showDialog(String message, String titre, int messageType) {
		
		/**
		 * Fonction invoquant une fenêtre de dialogue avec un message personnalisé
		 * @author Lorissou_
		 * @param message Message affiché dans la boîte de dialogue
		 * @param titre Titre de la boîte de dialogue
		 */
		
		showMessagePane(message, titre, messageType, null);
		
	}
	
	public static void showDialog(String message, String titre, int messageType, Icon icone) {
		
		/**
		 * Fonction invoquant une fenêtre de dialogue avec un message personnalisé
		 * @author Lorissou_
		 * @param message Message affiché dans la boîte de dialogue
		 * @param titre Titre de la boîte de dialogue
		 */
		
		showMessagePane(message, titre, messageType, icone);
		
	}
	
	public static void showMessagePane (String message, String titre, int messageType, Icon icone) {
		
		/**
		 * Fonction invoquant une fenêtre OptionPane de message, avec un message, titre, code et icone de défaut personnalisé
		 * @author Loris
		 * @param message Message affiché dans la boîte de dialogue
		 * @param titre Titre de la boîte de dialogue
		 * @param messageType Personnalisation de l'image de défaut dans la boîte de dialogue
		 * @param icone Icone de la boîte de dialogue
		 */
		
		JOptionPane.showMessageDialog(new JFrame(), message, titre, messageType, icone);
		
	}
}
