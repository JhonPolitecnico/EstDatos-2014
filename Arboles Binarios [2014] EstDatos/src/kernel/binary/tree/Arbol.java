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

	// Devolver la cantidad de todos los nodos hojas (Aquellos que no tienen ningun hijo)
	public int getNumberOfLeaves() {
		return this.getNumberOfLeaves(this.root);
	}

	// Devolver la cantidad de todos los nodos hojas (Aquellos que no tienen ningun hijo)
	private int getNumberOfLeaves(Nodo node) {
		int sum = 0;

		if (node == null)
			return sum;

		if (node.getLeft() != null)
			sum += this.getNumberOfLeaves(node.getLeft());
		if (node.getRight() != null)
			sum += this.getNumberOfLeaves(node.getRight());

		if (node.getLeft() == null && node.getRight() == null) {
			sum++;
		}

		return sum;
	}

	// Devolver todos los nodos hojas (Aquellos que no tienen ningun hijo)
	public int getNumberOfNodes() {
		return this.getNumberOfNodes(this.root);
	}

	// Devolver todos los nodos hojas (Aquellos que no tienen ningun hijo)
	private int getNumberOfNodes(Nodo node) {
		int sum = 0;

		if (node == null)
			return sum;

		if (node.getLeft() != null)
			sum += this.getNumberOfNodes(node.getLeft());
		if (node.getRight() != null)
			sum += this.getNumberOfNodes(node.getRight());

		sum++;

		return sum;
	}

	// Devolver la altura del arbol (el nivel mas profundo del arbol)
	public int getHigh() {
		return this.getHigh(this.root, 0);
	}

	// Devolver la altura del arbol (el nivel mas profundo del arbol)
	private int getHigh(Nodo node, int deep) {
		int deepLeft = 0;
		int deepRight = 0;

		if (node == null)
			return 0;

		// Sumar la profundidad de cada lado
		if (node.getLeft() != null)
			deepLeft = this.getHigh(node.getLeft(), deep + 1);
		if (node.getRight() != null)
			deepRight = this.getHigh(node.getRight(), deep + 1);

		// Profundidad final por hoja
		if (node.getLeft() == null && node.getRight() == null) {
			return deep;
		}

		// Retornar la mayor profundidad
		return (deepLeft > deepRight) ? deepLeft : deepRight;

	}

}
