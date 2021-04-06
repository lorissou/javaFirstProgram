package Base;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OptionPaneSwing extends JFrame {
	private static final long serialVersionUID = 4038914321129666366L;

	public static void showDialog(String message) {
		
		/**
		 * Fonction invoquant une fen�tre d'erreur avec un message personnalis�
		 * @author Lorissou_
		 * @param message Message affich� dans la bo�te de dialogue
		 */
		
		showMessagePane(message, "Erreur", 2, null);
		
	}
	
	public static void showDialog(String message, String titre) {
		
		/**
		 * Fonction invoquant une fen�tre d'erreur avec un message personnalis�
		 * @author Lorissou_
		 * @param message Message affich� dans la bo�te de dialogue
		 * @param titre Titre de la bo�te de dialogue
		 */
		
		showMessagePane(message, titre, 2, null);
		
	}
	
	public static void showDialog(String message, String titre, int messageType) {
		
		/**
		 * Fonction invoquant une fen�tre de dialogue avec un message personnalis�
		 * @author Lorissou_
		 * @param message Message affich� dans la bo�te de dialogue
		 * @param titre Titre de la bo�te de dialogue
		 */
		
		showMessagePane(message, titre, messageType, null);
		
	}
	
	public static void showDialog(String message, String titre, int messageType, Icon icone) {
		
		/**
		 * Fonction invoquant une fen�tre de dialogue avec un message personnalis�
		 * @author Lorissou_
		 * @param message Message affich� dans la bo�te de dialogue
		 * @param titre Titre de la bo�te de dialogue
		 */
		
		showMessagePane(message, titre, messageType, icone);
		
	}
	
	public static void showMessagePane (String message, String titre, int messageType, Icon icone) {
		
		/**
		 * Fonction invoquant une fen�tre OptionPane de message, avec un message, titre, code et icone de d�faut personnalis�
		 * @author Loris
		 * @param message Message affich� dans la bo�te de dialogue
		 * @param titre Titre de la bo�te de dialogue
		 * @param messageType Personnalisation de l'image de d�faut dans la bo�te de dialogue
		 * @param icone Icone de la bo�te de dialogue
		 */
		
		JOptionPane.showMessageDialog(new JFrame(), message, titre, messageType, icone);
		
	}
}
