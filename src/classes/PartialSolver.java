package classes;

import java.util.ArrayList;

public class PartialSolver implements Runnable {

	private Node Root;
	private String[][] Letters;
	private TreeManager tm;
	private WordChecker checker = new WordChecker();;

	public PartialSolver(Node root, String[][] letters) {
		Root = root;
		Letters = letters;
	}

	@Override
	public void run() {
		tm = new TreeManager(Root);
		tm.setBoard(Letters);
		tm.GrowTree();

		ArrayList<String> foundWords = tm.getWordsFromTree();
		for (String word : foundWords) {
			checker.handle(word);
		}
		checker.ShowWords();
	}

}
