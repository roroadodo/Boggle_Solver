package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EngDictionary {
	private Map<String, String> Words;
	private File File;
	private Scanner InputFile;

	public EngDictionary() {
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

	private void addWordsToDictionary() {
		while (InputFile.hasNext()) {
			String word = InputFile.nextLine();
			Words.put(word, word);
		}
	}

}
