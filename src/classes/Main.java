package classes;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		WordChecker checker = new WordChecker();
		Position p;
		Node root;
		TreeManager tm;
		String[][] letters = { { "i", "m", "s", "p" }, { "u", "m", "s", "t" }, { "d", "k", "f", "i" },
				{ "e", "o", "z", "t" } };
		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < letters[0].length; j++) {

				root = new Node();
				root.setCharacter(letters[i][j]);
				p = new Position(i, j);
				root.setPosition(p);

				tm = new TreeManager(root);
				tm.setBoard(letters);
				tm.GrowTree();

				ArrayList<String> foundWords = tm.getWordsFromTree();
				for (String word : foundWords) {
					checker.handle(word);
				}

			}
		}
		checker.ShowWords();
	}

}
