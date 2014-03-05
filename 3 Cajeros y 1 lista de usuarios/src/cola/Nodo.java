package cola;

public class Nodo {

	private Nodo right;
	private Object content;

	public Nodo(Object content) {
		super();
		this.content = content;
	}

	public boolean hasRight() {
		return (right != null);
	}

	public Nodo getRight() {
		return right;
	}

	public void setRight(Nodo right) {
		this.right = right;
	}

	protected Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
}
