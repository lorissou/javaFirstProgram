package Old;

public class Utils {

	public static void print(String message, boolean new_line) {
		
		if (new_line == true) {
			
			System.out.println(message);
		
		} else if (new_line == false) {
			
			System.out.print(message);
			
		}
		
	}
	
}
