/**
 * Teoria de listas doblemente enlazadas
 * 
 * 
 * @author Michael Torres
 * @author Jhon Eslava
 */

public class Nodo {
	/*
	 * Atributos y relaciones
	 */

	private int dato;
	private Nodo siguiente;
	private Nodo anterior;

	/*
	 * Constructores
	 */
	public Nodo(int dato) {
		this.dato = dato;
		this.siguiente = null;
		this.anterior = null;
	}

	/*
	 * getters and setters
	 */

	public void setDato(int dato) {
		this.dato = dato;
	}

	public int getDato() {
		return this.dato;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public Nodo getSiguiente() {
		return this.siguiente;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}

	public Nodo getAnterior() {
		return this.anterior;
	}

	/*
	 * Metodos
	 */

}
