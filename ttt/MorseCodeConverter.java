import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author hyeyeon Jeon
 * @version 11/29/2023
 */
public class MorseCodeConverter {
	private static MorseCodeTree MCtree;
	/**
	 * Constructor to call the MorseCodeTree.
	 */
	public MorseCodeConverter() {
		MCtree = new MorseCodeTree();
	}
	/**
	 * returns a string with all the data in the tree in LNR order with an space.
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree() {
		String str = "";
		for(String temp: MCtree.toArrayList()) {
			str += temp+" ";
		}
		return str;
	}
	/**
	 * Converts Morse code into English.
	 * @param code the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		String str = "";
		String[] words = code.split("/");
		String[] letters;
		for(String temp : words) {
			letters = temp.split(" ");
			for(String ch: letters) {
				str += MCtree.fetch(ch);
			}
			str += " ";
		}
		return str;
	}
	/**
	 * Converts a file of Morse code into English.
	 * @param codeFile File name that contains Morse Code
	 * @return the English translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		Scanner fileName = new Scanner(codeFile);
		String str = "";
		while(fileName.hasNext()) {
			str += fileName.nextLine();
		}
		return convertToEnglish(str);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
