package kernel.binary.tree;

public class Arbol {

	private Nodo root;

	public Nodo getRoot() {
		return root;
	}

	public boolean addNode(int num) {
		// Si es el primer nodo (raiz)
		if (this.root == null) {
			this.root = new Nodo(num);
			return true;
		}

		Nodo node = this.root;

		do {

			// Lado Derecho
			if (num > node.getNum()) {

				if (node.getRight() == null) {
					node.setRight(new Nodo(num));
					return true;
				}

				node = node.getRight();

				// Lado izquierdo
			} else if (num < node.getNum()) {

				if (node.getLeft() == null) {
					node.setLeft(new Nodo(num));
					return true;
				}

				node = node.getLeft();

				// Igual
			} else {
				return false;
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

	// Devolver la cantidad de todos los nodos hojas (Aquellos que no tienen
	// ningun hijo)
	public int getNumberOfLeaves() {
		return this.getNumberOfLeaves(this.root);
	}

	// Devolver la cantidad de todos los nodos hojas (Aquellos que no tienen
	// ningun hijo)
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

	// Buscar un valor
	public boolean search(int num) {
		return search(this.root, num);
	}

	// Buscar un valor
	private boolean search(Nodo node, int num) {
		boolean bRet = false;

		if (node == null)
			return false;

		// Si tiene el numero, retornar verdadero
		if (num == node.getNum())
			return true;

		// Si no, buscar en su lado derecho
		if (node.getLeft() != null)
			bRet = this.search(node.getLeft(), num);

		// Si no, buscar en su lado izquierdo
		if (node.getRight() != null && !bRet)
			bRet = this.search(node.getRight(), num);

		// Retornar el valor
		return bRet;
	}

	// Retornar el nodo mas izquierdo
	public int getLeftOfleft() {
		return this.getLeftOfleft(this.root);
	}

	// Retornar el nodo mas izquierdo
	private int getLeftOfleft(Nodo node) {

		if (node == null)
			return 0;

		if (node.getLeft() != null)
			return this.getLeftOfleft(node.getLeft());

		return node.getNum();

	}

	// Obtener el padre de un nodo
	public Nodo getParent(int num) {
		return this.getParent(this.root, num);
	}

	// Obtener el padre de un nodo
	private Nodo getParent(Nodo node, int num) {

		Nodo tmp = null;

		if (node == null)
			return null;

		// Obtener el padre...
		// Lado izquierdo
		if (node.getLeft() != null && num == node.getLeft().getNum())
			return node;
		// lado derecho
		if (node.getRight() != null && num == node.getRight().getNum())
			return node;

		// Seguir buscando...
		if (node.getLeft() != null)
			tmp = this.getParent(node.getLeft(), num);
		if (node.getRight() != null && tmp == null)
			return this.getParent(node.getRight(), num);

		// Retornar nodo, ya sea nulo o no
		return tmp;

	}
}
