package classes;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EngDictionary {
	private Map<String, String> Words;
	private File File;
	private Scanner InputFile;
	private static EngDictionary dictionary;
	
	private EngDictionary() {
		Words = new HashMap<String, String>();
		File = new File("./wordsEn.txt");

		try {

			InputFile = new Scanner(File);
			addWordsToDictionary();

		} catch (FileNotFoundException e) {
			System.out.println("EngDictionary unable to find file error: ");
			e.printStackTrace();
		}

	}

	public boolean contains(String word) {
		return Words.containsKey(word);
	}

	public static synchronized EngDictionary getDictInstance() {
		if(dictionary == null) {
			dictionary = new EngDictionary();
		}
		return dictionary;
	}
	
	private void addWordsToDictionary() {
		while (InputFile.hasNext()) {
			String word = InputFile.nextLine();
			Words.put(word, word);
		}
	}

}
