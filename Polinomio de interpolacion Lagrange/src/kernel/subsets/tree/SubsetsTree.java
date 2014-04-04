package kernel.subsets.tree;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsTree {

	private Node root;
	private Object[] elements;
	private int subsets;
	private ArrayList<ArrayList<Integer>> subsetsOfElements;

	public SubsetsTree(Object[] elements, int subsets) {
		super();
		this.elements = elements;
		this.subsets = subsets;

		// Agregar los indices de los elementos
		for (int i = 0; i < elements.length; i++) {
			addNode(i);
		}

	}

	// Caso particular: 5 elementos, sunconjuntos de 3 elementos
	private void addPar(Node node, int num) {

		int trues = 0;
		int falses = 0;
		Node tmp = node;
		do {

			// Solo 3 si
			if (trues == this.subsets)
				return;

			// Solo 2 no
			if (falses == this.elements.length - this.subsets)
				return;

			// Si llega a la cabeza
			if (tmp.getLink() == null)
				break;

			if (tmp.getLink().isDecision())
				trues++;
			else
				falses++;

			tmp = tmp.getLink().getParent();
		} while (true);

		// Si
		if (node.getLeft() == null) {
			node.setLeft(new Node(num));
			node.getLeft().setLink(new Link(node, true));
		} else {
			addPar(node.getLeft(), num);
		}

		// No
		if (node.getRight() == null) {
			node.setRight(new Node(num));
			node.getRight().setLink(new Link(node, false));
		} else {
			addPar(node.getRight(), num);
		}
	}

	private void addNode(int num) {
		// Si es el primer nodo (raiz)
		if (this.root == null) {
			this.root = new Node(num);
			return;
		}

		this.addPar(this.root, num);

	}

	// Devolver los otros indices de elementos, que no estan el el conjunto $keys
	private ArrayList<Integer> exclusionOfElements(ArrayList<Integer> keys) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < this.elements.length; i++) {
			Elements: {
				// Si esta, entonces, no agregarle
				for (Integer key : keys) {
					if (key == i) {
						break Elements;
					}
				}
				// Si no esta, agregarle
				ret.add(i);
			}
		}

		return ret;
	}

	// Devolver los subconjuntos de elementos, sin repeticion, e indistintamente de su orden
	public ArrayList<ArrayList<Object>> getSubsets() {
		// Empty
		this.subsetsOfElements = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Object>> oSubsetsOfElements = new ArrayList<ArrayList<Object>>();

		// Build subsets
		this.getSubsets(this.root);
		ArrayList<Object> tmp;
		for (ArrayList<Integer> subset : this.subsetsOfElements) {
			tmp = new ArrayList<Object>();
			for (Integer key : subset) {
				tmp.add(this.elements[key]);
			}
			oSubsetsOfElements.add(tmp);
		}

		return oSubsetsOfElements;
	}

	// Devolver valores en Postorden (izquierdo, derecho, raiz)
	private void getSubsets(Node node) {

		// Evitar errores
		if (node == null)
			return;

		// Avanzar hasta el nodo final
		if (node.getLeft() != null)
			this.getSubsets(node.getLeft());
		if (node.getRight() != null)
			this.getSubsets(node.getRight());

		// Nodo final
		if (node.getLeft() == null && node.getRight() == null) {

			// Obtener los indices de subconjuntos
			ArrayList<Integer> keysTrues = new ArrayList<Integer>();
			ArrayList<Integer> keysFalses = new ArrayList<Integer>();
			Node tmp = node;
			do {

				// Si completo los Si, entonces, devolver el subconjunto construido
				if (keysTrues.size() == this.subsets) {
					Collections.reverse(keysTrues); // Invertir el orden
					this.subsetsOfElements.add(keysTrues);
					break;
				}

				// Si completo los No, entonces, devolver el subconjunto construido
				if (keysFalses.size() == this.elements.length - this.subsets) {
					this.subsetsOfElements.add(this.exclusionOfElements(keysFalses));
					break;
				}

				// Si llega a la cabeza
				if (tmp.getLink() == null)
					break;

				if (tmp.getLink().isDecision()) {
					// Agregar el indice del padre
					keysTrues.add(tmp.getLink().getParent().getNum());
				} else {
					// Agregar el indice del padre
					keysFalses.add(tmp.getLink().getParent().getNum());
				}

				// Luego analizar el padre del padre
				tmp = tmp.getLink().getParent();
			} while (true);

		}

	}
}
