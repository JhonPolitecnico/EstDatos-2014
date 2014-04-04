package kernel.subsets.tree;

public class Link {
	private Node parent;
	private boolean decision;

	public Link(Node parent, boolean decision) {
		super();
		this.parent = parent;
		this.decision = decision;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public boolean isDecision() {
		return decision;
	}

	public void setDecision(boolean decision) {
		this.decision = decision;
	}

}
