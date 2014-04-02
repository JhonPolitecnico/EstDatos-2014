package kernel.binary.tree;

public class Arbol {

	private Nodo root;

	public Nodo getRoot() {
		return root;
	}

	public void addNode(int num) {
		// Si es el primer nodo (raiz)
		if (this.root == null) {
			this.root = new Nodo(num);
			return;
		}

		Nodo node = this.root;

		do {

			// Lado Derecho
			if (num > node.getNum()) {

				if (node.getRight() == null) {
					node.setRight(new Nodo(num));
					return;
				}

				node = node.getRight();

				// Lado izquierdo
			} else if (num < node.getNum()) {

				if (node.getLeft() == null) {
					node.setLeft(new Nodo(num));
					return;
				}

				node = node.getLeft();

				// Igual
			} else {
				return;
			}

		} while (true);
	}
}
