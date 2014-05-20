package grafo;

import java.util.ArrayList;

public class Grafo {
	private Vertice[] vertices;
	private int[][] matrizDeAdyacencia;

	public Grafo(int numVertices) {
		this.vertices = new Vertice[numVertices];
		this.matrizDeAdyacencia = new int[numVertices][numVertices];
	}

	public void insertarVertice(String etiqueta) {
		if (buscarVertice(etiqueta) != -1)
			return;

		int i = 0;

		for (Vertice vertice : this.vertices) {
			if (vertice != null) {
				i++;
				continue;
			}

			this.vertices[i] = new Vertice(etiqueta);
			break;
		}
	}

	public int buscarVertice(String etiqueta) {
		int i = 0;

		for (Vertice vertice : this.vertices) {
			if (vertice == null)
				return -1;

			if (vertice.getEtiqueta().equals(etiqueta))
				return i;
			i++;
		}

		return -1;
	}

	public void insertarArco(String origen, String destino) {
		if (this.buscarVertice(origen) == -1 || this.buscarVertice(destino) == -1)
			return;

		this.matrizDeAdyacencia[this.buscarVertice(origen)][this.buscarVertice(destino)] = 1;
		this.matrizDeAdyacencia[this.buscarVertice(destino)][this.buscarVertice(origen)] = 1;
	}

	public int gradoDeUnVertice(String etiqueta) {
		int id = this.buscarVertice(etiqueta);
		if (id == -1)
			return -1;

		int[] fila = this.matrizDeAdyacencia[id];
		int ret = 0;

		for (int i : fila)
			ret += i;

		return ret;
	}

	public ArrayList<Vertice> relacionesDeUnVertice(String etiqueta) {
		int id = this.buscarVertice(etiqueta);
		if (id == -1)
			return null;

		int[] fila = this.matrizDeAdyacencia[id];

		ArrayList<Vertice> aristas = new ArrayList<Vertice>();

		for (int i = 0; i < fila.length; i++)
			if (fila[i] != 0)
				aristas.add(this.vertices[i]);

		return aristas;
	}

	public ArrayList<Vertice> profundidadDeUnNodo(String etiqueta) {
		return this.profundidadDeUnNodo(etiqueta, new ArrayList<Vertice>());
	}

	private ArrayList<Vertice> profundidadDeUnNodo(String etiqueta, ArrayList<Vertice> recorrido) {

		if (this.buscarVertice(etiqueta) == -1)
			return null;

		ArrayList<Vertice> relaciones = this.relacionesDeUnVertice(etiqueta);

		/**
		 * Se agrega el al recorrido
		 */
		recorrido.add(this.vertices[this.buscarVertice(etiqueta)]);

		boolean esta = false;

		for (Vertice relacion : relaciones) {

			esta = false;
			for (Vertice vertice : recorrido) {
				if (vertice.getEtiqueta().equals(relacion.getEtiqueta())) {
					esta = true;
					break;
				}
			}

			/**
			 * Si esta la relacion duplicada, omitirla
			 */
			if (esta)
				continue;

			/**
			 * Si no esta, operarla
			 */

			this.profundidadDeUnNodo(relacion.getEtiqueta(), recorrido);

		}

		return recorrido;
	}

	public String imprimir() {
		String ret = "  ";

		/**
		 * Fila de etiquetas
		 */
		for (Vertice vertice : this.vertices) {
			ret += vertice.getEtiqueta() + " ";
		}

		ret += "\n";

		int fila = 0;

		for (int[] i : this.matrizDeAdyacencia) {

			ret += this.vertices[fila].getEtiqueta() + " ";
			for (int j : i) {
				ret += j + " ";
			}
			ret += "\n";
			fila++;
		}

		return ret;
	}

	@Override
	public String toString() {
		return this.imprimir();
	}

}
