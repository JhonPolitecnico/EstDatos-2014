package grafo.ordenado;

import grafo.Vertice;

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

	public void insertarArcoDirigido(String origen, String destino) {
		if (this.buscarVertice(origen) == -1 || this.buscarVertice(destino) == -1)
			return;

		this.matrizDeAdyacencia[this.buscarVertice(origen)][this.buscarVertice(destino)] = 1;
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

	public ArrayList<Vertice> nodosFuente() {

		ArrayList<Vertice> fuentes = new ArrayList<Vertice>();

		int i = 0;
		int sum = 0;

		for (int[] fila : this.matrizDeAdyacencia) {
			for (int j : fila)
				sum += j;

			if (sum > 0) {
				sum = 0;

				for (int ii = 0; ii < this.matrizDeAdyacencia.length; ii++)
					sum += this.matrizDeAdyacencia[ii][i];

				if (sum == 0)
					fuentes.add(this.vertices[i]);
			}

			sum = 0;
			i++;
		}

		return fuentes;
	}

	public ArrayList<Vertice> nodosSumideros() {

		ArrayList<Vertice> sumideros = new ArrayList<Vertice>();

		int i = 0;
		int sum = 0;

		for (int[] fila : this.matrizDeAdyacencia) {
			for (int j : fila)
				sum += j;

			if (sum == 0) {

				for (int ii = 0; ii < this.matrizDeAdyacencia.length; ii++)
					sum += this.matrizDeAdyacencia[ii][i];

				if (sum > 0)
					sumideros.add(this.vertices[i]);
			}

			sum = 0;
			i++;
		}

		return sumideros;
	}

	public ArrayList<Vertice> sucesoresDeUnVertice(String etiqueta) {
		int id = this.buscarVertice(etiqueta);
		if (id == -1)
			return null;

		int[] fila = this.matrizDeAdyacencia[id];

		ArrayList<Vertice> sucesores = new ArrayList<Vertice>();

		for (int i = 0; i < fila.length; i++)
			if (fila[i] != 0)
				sucesores.add(this.vertices[i]);

		return sucesores;
	}

	public ArrayList<Vertice> predecesoresDeUnVertice(String etiqueta) {
		int id = this.buscarVertice(etiqueta);
		if (id == -1)
			return null;

		ArrayList<Vertice> predecesores = new ArrayList<Vertice>();

		for (int i = 0; i < this.matrizDeAdyacencia.length; i++)
			if (this.matrizDeAdyacencia[i][id] != 0)
				predecesores.add(this.vertices[i]);

		return predecesores;
	}

	public ArrayList<Vertice> ordenar() {
		
		return this.ordenar(this.clone(), this.vertices[0].getEtiqueta(), new ArrayList<Vertice>());
	}

	private ArrayList<Vertice> ordenar(Grafo clon, String etiqueta, ArrayList<Vertice> recorrido) {

		if (this.buscarVertice(etiqueta) == -1)
			return null;

		ArrayList<Vertice> sumideros = this.nodosSumideros();

		for (Vertice vertice : sumideros) 
			recorrido.add(vertice);
		
		for (Vertice vertice : sumideros) {

			ArrayList<Vertice> predecesores = this.predecesoresDeUnVertice(vertice.getEtiqueta());
			
			for (Vertice predecesor : predecesores) {
				
			}
			
		}
		
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
	
	public Grafo clone(){
		
		Grafo clon = new Grafo(this.vertices.length);
		clon.insertarVertice(etiqueta);
		
		return null;
		
	}
}
