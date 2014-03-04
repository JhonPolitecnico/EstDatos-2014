package lista;

public class Lista extends Nodo {

	private int length;

	public Lista() {
		super(null);
	}

	public int getLength() {
		return length;
	}

	// Get node
	private Nodo getNodo(int id) {

		// Null list
		if (!this.hasRight())
			return null;

		// No list element
		if (id < 0 || id >= this.length)
			return null;

		Nodo nodo = this.getRight();

		for (int i = 0; i < id; i++) {
			// Next node
			nodo = nodo.getRight();
		}

		return nodo;
	}

	public Object getItem(int id) {
		Nodo nodo = this.getNodo(id);

		if (nodo == null)
			return null;

		return nodo.getContent();
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

	public void exchangeItems(int id, int targetId) {

		// Null list
		if (!this.hasRight())
			return;

		// No list element
		if (id < 0 || id >= this.length || targetId < 0 || targetId >= this.length || id == targetId)
			return;

		// Link one (A)
		int onePreviousId = id - 1;
		Nodo onePreviousNode = null;

		if (onePreviousId >= 0)
			onePreviousNode = this.getNodo(id - 1);
		else
			onePreviousNode = this;

		Nodo oneNode = this.getNodo(id); // Node A
		Nodo oneNextNode = oneNode.getRight();

		// Link two (B)
		int twoPreviousId = targetId - 1;
		Nodo twoPreviousNode = null;

		if (twoPreviousId >= 0)
			twoPreviousNode = this.getNodo(targetId - 1);
		else
			twoPreviousNode = this;

		Nodo twoNode = this.getNodo(targetId); // Node B
		Nodo twoNextNode = twoNode.getRight();

		// exchange A to B

		// B to A
		onePreviousNode.setRight(twoNode);
		twoNode.setRight(oneNextNode);

		// A to B
		twoPreviousNode.setRight(oneNode);
		oneNode.setRight(twoNextNode);

	}

	public void removeItem(int id) {

		Nodo nodo = this.getNodo(id);

		if (nodo == null)
			return;

		// Link one
		int previousId = id - 1;
		Nodo previousNode = null;

		if (previousId >= 0)
			previousNode = this.getNodo(id - 1);
		else
			previousNode = this;

		// Link two
		Nodo nextNode = nodo.getRight();

		// One to two
		previousNode.setRight(nextNode);

		// Decrement length
		this.length--;
	}

	public void addItem(int id, Object content) {

		// Null list
		if (!this.hasRight())
			return;

		// No list element
		if (id < 0 || id >= this.length)
			return;

		// Add node to last node
		if (id == this.length) {
			this.addItem(content);
		} else {

			// Link one
			int previousId = id - 1;
			Nodo previousNode = null;

			if (previousId >= 0)
				previousNode = this.getNodo(id - 1);
			else
				previousNode = this;

			// Link two
			Nodo nextNode = this.getNodo(id);

			// New node
			Nodo newNodo = new Nodo(content);

			// link the new node to the node list
			previousNode.setRight(newNodo);
			newNodo.setRight(nextNode);

			// Increment length
			this.length++;
		}

	}

	public void addItem(Object content) {
		// Increment length
		this.length++;

		// Initial node
		Nodo nodo = null;

		// last node
		if (this.getRight() != null)
			nodo = this.getLastNodo();
		else
			nodo = this;

		// Add node to last node
		Nodo newNodo = new Nodo(content);
		nodo.setRight(newNodo);
	}

}
