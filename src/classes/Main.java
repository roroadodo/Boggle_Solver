package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		WordChecker checker = new WordChecker();
		Position p;
		Node root;
		TreeManager tm;
		String[][] letters = new String[4][4];

		for (int i = 0; i < 4; i++) {
			String input = keyboard.nextLine();
			letters[i] = input.split(" ");
		}

		// root = new Node();
		// root.setCharacter(letters[0][0]);
		// p = new Position(0, 0);
		// root.setPosition(p);
		//
		// Runnable partialSolver = new PartialSolver(root, letters);
		// new Thread(partialSolver).start();

		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < letters[0].length; j++) {

				root = new Node();
				root.setCharacter(letters[i][j]);
				p = new Position(i, j);
				root.setPosition(p);

				Runnable partialSolver = new PartialSolver(root, letters);
				new Thread(partialSolver).start();

//				tm = new TreeManager(root);
//				tm.setBoard(letters);
//				tm.GrowTree();
//
//				ArrayList<String> foundWords = tm.getWordsFromTree();
//				for (String word : foundWords) {
//					checker.handle(word);
//				}

			}
		}
		System.out.println("threads complete");
		//checker.ShowWords();
	}

}
