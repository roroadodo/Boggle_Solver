package classes;

import java.util.ArrayList;
import java.util.List;

public class WordChecker {
	private List<String> ValidWords;
	private EngDictionary Dictionary;

	public WordChecker() {
		ValidWords = new ArrayList<String>();
		Dictionary = new EngDictionary();
	}

	public void handle(String word) {
		if (word.length() >= 3 && !ValidWords.contains(word) && Dictionary.contains(word)) {
			ValidWords.add(word);
		}
	}

	public void ShowWords() {
		for (String word : ValidWords) {
			System.out.println(word);
		}
	}
}
