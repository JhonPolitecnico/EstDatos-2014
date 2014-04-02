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

	// Devolver valores en Preorden
	public String preorden() {
		return preorden(this.root);
	}

	// Devolver valores en Preorden (raiz, izquierdo, derecho)
	private String preorden(Nodo node) {
		String sRet = "";

		if (node == null)
			return "";

		sRet = String.valueOf(node.getNum()) + " ";
		if (node.getLeft() != null)
			sRet += preorden(node.getLeft());
		if (node.getRight() != null)
			sRet += preorden(node.getRight());
		return sRet;
	}

	// Devolver valores en Inorden
	public String inorden() {
		return inorden(this.root);
	}

	// Devolver valores en Inorden (izquierdo, raiz, derecho)
	private String inorden(Nodo node) {
		String sRet = "";

		if (node == null)
			return "";

		if (node.getLeft() != null)
			sRet += inorden(node.getLeft());

		sRet += String.valueOf(node.getNum()) + " ";

		if (node.getRight() != null)
			sRet += inorden(node.getRight());

		return sRet;
	}

	// Devolver valores en Postorden
	public String postorden() {
		return postorden(this.root);
	}

	// Devolver valores en Postorden (izquierdo, derecho, raiz)
	private String postorden(Nodo node) {
		String sRet = "";

		if (node == null)
			return "";

		if (node.getLeft() != null)
			sRet += postorden(node.getLeft());
		if (node.getRight() != null)
			sRet += postorden(node.getRight());

		sRet += String.valueOf(node.getNum()) + " ";

		return sRet;
	}

}
