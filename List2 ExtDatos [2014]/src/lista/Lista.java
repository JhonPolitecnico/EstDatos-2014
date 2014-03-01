package lista;

public class Lista extends Nodo {

	private int length;

	public Lista() {
		super(0, null);
		this.length = 0; // length of list
	}

	public int getLength() {
		return length;
	}

	public Object getContent(int id) {

		// Null list
		if (!this.hasRight())
			return null;

		// No list element
		if (id < 0 || id >= this.length)
			return null;

		Nodo nodo = this.getRight();

		// Iterate nodes
		while (nodo != null) {
			// Node
			if (nodo.getId() == id)
				break;

			// Next node
			nodo = nodo.getRight();
		}

		if (nodo != null)
			return nodo.getContent();
		else
			return null;
	}

	public void addContent(int id, Object content) {

		// Null list
		if (!this.hasRight())
			return;

		// No list element
		if (id < 0 || id > this.length)
			return;

		// Add node to last node
		if (id == this.length) {
			this.addContent(content);
		} else {

			// Initial node
			Nodo nodo = this.getRight();

			// Iterate nodes
			while (nodo != null) {

				// Increment node index
				if (nodo.getId() >= id)
					nodo.setId(nodo.getId() + 1);

				// Next node
				nodo = nodo.getRight();
			}

			// Increment length
			this.length++;

			// Add node to last node with index: id
			Nodo newNodo = new Nodo(id, content);
			this.getLastNodo().setRight(newNodo);
		}

	}

	// Get last node
	private Nodo getLastNodo() {

		// Null list
		if (!this.hasRight())
			return null;

		Nodo nodo = this.getRight();

		// Iterate nodes
		while (nodo != null) {

			// last node
			if (!nodo.hasRight())
				break;

			// Next node
			nodo = nodo.getRight();
		}

		return nodo;
	}

	public void addContent(Object content) {
		// Increment length
		this.length++;

		// Initial node
		Nodo nodo = null;

		if (this.getRight() != null)
			nodo = this.getLastNodo();
		else
			nodo = this;

		// Add node to last node (Index start in 0)
		Nodo newNodo = new Nodo(this.length - 1, content);
		nodo.setRight(newNodo);
	}

}
