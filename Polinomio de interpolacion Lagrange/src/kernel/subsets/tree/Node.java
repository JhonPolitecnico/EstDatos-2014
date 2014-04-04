package kernel.subsets.tree;

public class Node {

	private Link link;
	private Node left;
	private Node right;
	private int num;

	public Node(int num) {
		this.num = num;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getNum() {
		return num;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

}
