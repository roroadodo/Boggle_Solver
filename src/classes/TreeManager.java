package classes;

import java.util.ArrayList;
import java.util.List;

public class TreeManager {
	private Node Root;
	private Board board;
	private List<String> words;
	private int Height;

	public TreeManager(Node rt) {
		Root = rt;
		words = new ArrayList<String>();
		Height = 0;
	}

	public void setBoard(String[][] letters) {
		board = new Board(letters);
	}

	public ArrayList<String> getWordsFromTree() {
		findWords(Root, "");
		return (ArrayList<String>) words;
	}

	public void GrowTree() {
		board.blockPosition(Root);

		ArrayList<Node> children = board.getNeighbors(Root);
		for (Node child : children) {
			addToTree(Root, child);
		}
	}

	private void addToTree(Node parent, Node child) {
		Height++;
		//90% of English words are under 13 characters long
		if (Height < 13) {
			parent.add(child);

			board.blockPosition(child);
			ArrayList<Node> grandchildren = board.getNeighbors(child);

			for (Node grandchild : grandchildren) {
				addToTree(child, grandchild);
			}

			board.unBlockPosition(child);
		}
		Height--;
	}

	private void findWords(Node node, String word) {
		word = word + node;
		words.add(word);
		for (Node child : node.getChildren()) {
			findWords(child, word);
		}
	}
}
