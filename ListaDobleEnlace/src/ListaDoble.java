/**
 * Teoria de listas doblemente enlazadas
 * 
 * 
 * @author Michael Torres
 * @author Jhon Eslava
 */

public class ListaDoble {
	/*
	 * Atributos y relaciones
	 */
	private Nodo inicio;
	private Nodo fin;

	/*
	 * Constructores
	 */
	public ListaDoble() {
		this.inicio = null;
		this.fin = null;
	}

	/*
	 * getters and setters
	 */
	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}

	public Nodo getFin() {
		return fin;
	}

	public void setFin(Nodo fin) {
		this.fin = fin;
	}

	/*
	 * Metodos
	 */

	// Metodo para insertar un nodo con doble referencia al incio de la lista

	public void insertarInicio(int dato) {
		Nodo nuevo = new Nodo(dato);

		if (inicio == null && fin == null) {
			inicio = nuevo;
			fin = nuevo;
		} else if (inicio.getAnterior() == null) {
			nuevo.setSiguiente(inicio);
			inicio.setAnterior(nuevo);
			inicio = nuevo;
		}
	}

	// Metodo para insertar un nodo con doble referencia al final de la lista

	public void insertarFinal(int dato) {
		Nodo nuevo = new Nodo(dato);

		if (inicio == null && fin == null) {
			inicio = nuevo;
			fin = nuevo;
		} else if (fin.getSiguiente() == null) {
			fin.setSiguiente(nuevo);
			nuevo.setAnterior(fin);
			fin = nuevo;
		}
	}

	// Metodo para eliminar un nodo con doble referencia al inicio de la lista

	public void eliminarInicio() {
		if (inicio == fin) {
			inicio = null;
			fin = null;
		} else {
			inicio = inicio.getSiguiente();
			inicio.setAnterior(null);
		}
	}

	// Metodo para eliminar un nodo con doble referencia al final de la lista

	public void eliminarFinal() {
		if (inicio == fin) {
			inicio = null;
			fin = null;
		} else {
			fin = fin.getAnterior();
			fin.setSiguiente(null);
		}
	}

	// Metodo que imprime y recorre una lista creada de izquiera a derecha e imprime los valores enteros
	// El recorrido empieza desde la referencia inio

	public void imprimirIzquierdaDerecha() {
		Nodo recorrer = inicio;

		System.out.print("ELEMENTOS DE LA LISTA DE IZQUIERDA A DERECHA: ");

		while (recorrer != null) {
			System.out.print(recorrer.getDato() + " ");
			recorrer = recorrer.getSiguiente();
		}
		System.out.println();
	}

	// Metodo que imprime y recorre una lista creada de derecha a izquierda e imprime los valores enteros
	// El recorrido empieza desde la referencia fin

	public void imprimirDerechaIzquierda() {
		Nodo recorrer = fin;

		System.out.print("ELEMENTOS DE LA LISTA DE DERECHA A IZQUIERDA: ");

		while (recorrer != null) {
			System.out.print(recorrer.getDato() + " ");
			recorrer = recorrer.getAnterior();
		}
		System.out.println();
		System.out.println();
	}

	// Crear metodo para agregar un nodo en un subindice especifico
	public void agregarNodo(int indice, int dato) {

		if (inicio == null && fin == null) {
			this.insertarInicio(dato);
		}

		Nodo recorrer = inicio;
		int contador = 0;

		while (recorrer != null) {

			// Encontro el indice
			if (indice == contador) {
				Nodo nuevo = new Nodo(dato);

				nuevo.setSiguiente(recorrer.getSiguiente());
				recorrer.setSiguiente(nuevo);
				nuevo.setAnterior(recorrer);
				break; // salir del ciclo
			}

			// Siguiente nodo
			recorrer = recorrer.getSiguiente();
			contador++;
		}
	}

	// Crear metodo para eliminar un nodo en un subindice especifico

	public void eliminarNodo(int indice) {

		if (inicio == null || fin == null) {
			return;
		}

		Nodo recorrer = inicio;
		int contador = 0;

		while (recorrer != null) {

			// Encontro el indice
			if (indice == contador) {

				// Establecer enlaces de los nosdos aledaños y auto eliminarse
				if (recorrer.getAnterior() != null) {
					recorrer.getAnterior().setSiguiente(recorrer.getSiguiente());
				} else {
					this.inicio = recorrer.getSiguiente();
				}

				if (recorrer.getSiguiente() != null) {
					recorrer.getSiguiente().setAnterior(recorrer.getAnterior());
				} else {
					this.fin = recorrer.getAnterior();
				}

				break; // salir del ciclo
			}

			// Siguiente nodo
			recorrer = recorrer.getSiguiente();
			contador++;
		}

	}

}