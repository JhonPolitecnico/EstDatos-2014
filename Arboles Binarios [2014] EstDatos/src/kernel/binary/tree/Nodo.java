package kernel.binary.tree;

/**
 * Arbol binario
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
public class Nodo {

	private Nodo left;
	private Nodo right;
	private int num;

	public Nodo(int num) {
		this.num = num;
	}

	public Nodo getLeft() {
		return left;
	}

	public void setLeft(Nodo left) {
		this.left = left;
	}

	public Nodo getRight() {
		return right;
	}

	public void setRight(Nodo right) {
		this.right = right;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
