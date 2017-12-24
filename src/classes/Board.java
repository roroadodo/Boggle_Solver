package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Board {
	ArrayList<Node> lst;
	String[][] board;
	boolean[][] visitable;
	Node cur;

	public Board(String[][] letters) {
		board = letters;
		visitable = new boolean[board.length][board[0].length];
		setupVisitable();
	}

	public void blockPosition(Node n) {
		Position p = n.getPosition();
		visitable[p.getX()][p.getY()] = false;
	}

	public void unBlockPosition(Node n) {
		Position p = n.getPosition();
		visitable[p.getX()][p.getY()] = true;
	}
	
	public ArrayList<Node> getNeighbors(Node node) {
		Position position = node.getPosition();
		cur = node;
		int x = position.getX();
		int y = position.getY();
		lst = new ArrayList<Node>();
		addToList(x - 1, y);
		addToList(x - 1, y + 1);
		addToList(x - 1, y - 1);

		addToList(x + 1, y);
		addToList(x + 1, y + 1);
		addToList(x + 1, y - 1);

		addToList(x, y + 1);
		addToList(x, y - 1);
		return lst;
	}


	private void addToList(int x, int y) {
		if (!isOutOfBounds(x) && !isOutOfBounds(y)) {
			// create new node if not visited
			if (visitable[x][y] == true) {
				Node node = new Node(cur);
				Position p = new Position(x, y);
				node.setPosition(p);
				node.setCharacter(board[x][y]);
				lst.add(node);
			}
		}
	}

	private boolean isOutOfBounds(int NumbToCheck) {
		if (NumbToCheck < 0 || NumbToCheck > board.length - 1) {
			return true;
		} else {
			return false;
		}
	}
	private void setupVisitable() {
		for(int i = 0; i < visitable.length; i++) {
			for(int j = 0; j < visitable[0].length; j++) {
				visitable[i][j] = true;
			}
		}
	}
}
