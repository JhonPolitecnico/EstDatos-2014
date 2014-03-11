package cola;

import nodo.Nodo;

public class Cola extends Nodo {

	public Cola() {
		super(null);
	}

	public Object dequeue() {

		if (this.hasRight()) {
			Nodo nodo = this.getRight();
			// more nodes in queue
			if (nodo.hasRight()) {
				this.setRight(nodo.getRight());
			} else {
				// Only one node in queue
				this.setRight(null);
			}
			return nodo.getContent();
		}

		return null;
	}

	public void enqueue(Object content) {

		Nodo nodo = this;

		while (nodo != null) {
			if (!nodo.hasRight())
				break;

			nodo = nodo.getRight();
		}

		nodo.setRight(new Nodo(content));
	}
}
