package classes;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private Node Parent;
	private List<Node> Children;
	private String character;
	private Position Position;

	public Node() {
		Parent = null;
		Children = new ArrayList<Node>();
	}

	public Node(Node parent) {
		Parent = parent;
		Children = new ArrayList<Node>();
	}

	public void add(Node child) {
		Children.add(child);
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public void setPosition(Position inPosition) {
		this.Position = inPosition;
	}

	public Position getPosition() {
		return Position;
	}
	
	public List<Node> getChildren(){
		return Children;
	}

	@Override
	public String toString() {
		return character;
	}
}
