package pila;

public class Pila extends Nodo {

	public Pila() {
		super(null);
	}

	// Push content
	public void push(Object content) {

		Nodo nodo = this;
		if (nodo.hasRight())
			nodo = getLastNode();

		Nodo newNodo = new Nodo(content);
		nodo.setRight(newNodo);
	}

	// Pop content
	public Object pop() {
		Nodo nodo = this;

		if (!nodo.hasRight())
			return null;

		// Get previous to the last node
		while (nodo != null) {

			// Previous to the last node
			if (nodo.hasRight()) {
				if (!nodo.getRight().hasRight()) {
					break;
				}

			}
			
			nodo = nodo.getRight();
		}

		// Next node
		Nodo lastNode = nodo.getRight();
		// Delete last node
		nodo.setRight(null);
		// Return last node
		return lastNode.getContent();

	}

	// Get last node
	private Nodo getLastNode() {

		Nodo nodo = this.getRight();

		while (nodo != null) {

			// last node
			if (!nodo.hasRight())
				break;

			// Next node
			nodo = nodo.getRight();
		}

		return nodo;

	}

}
