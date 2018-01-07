package classes;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Position p;
		Node root;
		String[][] letters = new String[4][4];

		System.out.println("BOGGLE SOLVER \n\n"
				+ "Input Board:\n" 
				+ "Please enter 4 lines of 4 characters \n"
				+ "where characters are separated by an empty space");

		for (int i = 0; i < 4; i++) {
			String input = keyboard.nextLine();
			letters[i] = input.split(" ");
		}

		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < letters[0].length; j++) {

				root = new Node();
				root.setCharacter(letters[i][j]);
				p = new Position(i, j);
				root.setPosition(p);

				Runnable partialSolver = new PartialSolver(root, letters);
				new Thread(partialSolver).start();

			}
		}
		System.out.println("threads complete");
	}

}
