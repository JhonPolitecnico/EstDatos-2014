package kernel.binary.tree;

/**
 * Arbol binario
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
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
	public Nodo search(int num) {
		return search(this.root, num);
	}

	// Buscar un valor
	private Nodo search(Nodo node, int num) {
		Nodo rNode = null;

		if (node == null)
			return null;

		// Si tiene el numero, retornar verdadero
		if (num == node.getNum())
			return node;

		// Si no, buscar en su lado derecho
		if (node.getLeft() != null)
			rNode = this.search(node.getLeft(), num);

		// Si no, buscar en su lado izquierdo
		if (node.getRight() != null && rNode == null)
			rNode = this.search(node.getRight(), num);

		// Retornar el valor
		return rNode;
	}

	// Retornar el nodo mas izquierdo
	public Nodo getLeftOfleft() {
		return this.getLeftOfleft(this.root);
	}

	// Retornar el nodo mas izquierdo
	private Nodo getLeftOfleft(Nodo node) {

		if (node == null)
			return null;

		if (node.getLeft() != null)
			return this.getLeftOfleft(node.getLeft());

		return node;

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

	public boolean deleteNode(int num) {

		Nodo node = this.search(num);

		// Si el nodo a eliminar no existe
		if (node == null)
			return false;

		Nodo parent = null;

		/*
		 * Eliminar nodo sin hijos
		 */
		if (node.getLeft() == null && node.getRight() == null) {
			// Buscar su padre
			parent = this.getParent(num);
			// Si el padre existe...
			if (parent != null) {
				// Dependiendo de su valor, esta a la izquierda o derecha,
				// entonces eliminar segun corresponda
				if (num > parent.getNum())
					parent.setRight(null);
				else
					parent.setLeft(null);
			}
			// Si no tiene padre, hay un error
			return false;
		}

		/*
		 * Eliminar nodo con un hijo
		 */
		// Lado Izquierdo
		if (node.getLeft() != null && node.getRight() == null) {
			// Busar su padre
			parent = this.getParent(num);
			// Si el padre existe...
			if (parent != null) {
				// Dependiendo de su valor, esta a la izquierda o derecha,
				// entonces eliminar segun corresponda
				if (num > parent.getNum())
					parent.setRight(node.getLeft());
				else
					parent.setLeft(node.getLeft());

			}
			// Si no tiene padre, hay un error
			return false;
			// Lado derecho
		} else if (node.getLeft() == null && node.getRight() != null) {
			// Busar su padre
			parent = this.getParent(num);
			// Si el padre existe...
			if (parent != null) {
				// Dependiendo de su valor, esta a la izquierda o derecha,
				// entonces eliminar segun corresponda
				if (num > parent.getNum())
					parent.setRight(node.getRight());
				else
					parent.setLeft(node.getRight());

			}
			// Si no tiene padre, hay un error
			return false;
		}

		/*
		 * Eliminar nodo con dos hijos
		 */

		Nodo nodeLeft = null;
		Nodo nodeRight = null;

		/*
		 * Nota, el reemplazo es por valor, y la eliminacion del hijo es recursiva, no usar enlaces
		 */

		// Obtener el nodo mas izquierdo del nodo derecho
		nodeRight = this.getLeftOfleft(node.getRight());
		// Pasar el lado izquierdo del nodo a eliminar al nodo que lo reemplazara

		// Guardar el nodo que lo reemplazara
		int nodoNuevo = nodeRight.getNum();
		// Eliminar este nodo
		this.deleteNode(nodoNuevo);
		// Reemplazar el nodo
		node.setNum(nodoNuevo);

		return true;
	}
}
