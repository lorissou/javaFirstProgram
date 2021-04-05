package Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * <h1>Programme de Loris</h1>
 * <p>Programmme ayant pour but de demander une certaine liste de mots présents dans une liste <br><br>Site Web : <a href='https://www.google.com'>Google</a></p>
 * @author Lorissou_
 */

public class AskForWords {
			
	public static void main(String[] args) {
		
		// Partie input console
		@SuppressWarnings("resource")
		Scanner input_console = new Scanner(System.in);
		
		
		// Partie chaine de caractère à vérifier 
		final String[] ListWordsToFind = {"a", "e", "i", "o", "u", "y"};
		
		ArrayList<String> WordsToFind = new ArrayList<String>();
		
		Collections.addAll(WordsToFind, ListWordsToFind);
		
		
		// Partie chaine de caractères trouvées
		ArrayList<String> FoundedWords = new ArrayList<String>();
		
		int NumberOfFoundedWords = 0;
		
		
		// Boucle de question utilisateur
		for (; FoundedWords.size() < WordsToFind.size();) {
			
			NumberOfFoundedWords = FoundedWords.size(); // Actualisation du nombre de mots trouvé dans la variable integer
			
			Utils.print("\nTu as déja trouvé " + NumberOfFoundedWords + " mots : " + FoundedWords, true);
			Utils.print("Voyelles à trouver : ", false);
			
			String user_input = input_console.nextLine(); // Attente de texte dans la console
			
			if (FoundedWords.contains(user_input) == false) { 
				
				if (WordsToFind.contains(user_input) == true) {
				
					Utils.print("\nTu as trouvé le mot : " + user_input, true);
				FoundedWords.add(user_input);
				
				} else { Utils.print("\nLe mot \"" + user_input + "\" n'est pas correct...", true); }
				
			} else { Utils.print("\nTu as déja trouvé : " + user_input, true); }
			
		}
		
		Utils.print("\nTu as trouvé touts les mots à chercher !", true);
		
	}
	
}
