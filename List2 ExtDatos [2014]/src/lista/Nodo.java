package lista;

public class Nodo {

	private Nodo right;
	private Object content;
	private int id;

	public Nodo(int id, Object content) {
		super();
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
