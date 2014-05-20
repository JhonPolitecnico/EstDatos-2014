package main;

import grafo.Grafo;

public class Main {

	public static void main(String[] args) {
		Grafo grafo = new Grafo(6);

		grafo.insertarVertice("1");
		grafo.insertarVertice("2");
		grafo.insertarVertice("3");
		grafo.insertarVertice("4");
		grafo.insertarVertice("5");
		grafo.insertarVertice("6");

		grafo.insertarArco("1", "1");
		grafo.insertarArco("1", "2");
		grafo.insertarArco("1", "5");

		grafo.insertarArco("2", "3");
		grafo.insertarArco("2", "5");

		grafo.insertarArco("3", "4");

		grafo.insertarArco("4", "5");
		grafo.insertarArco("4", "6");

		System.out.println(grafo);

		for (int i = 1; i <= 6; i++)
			System.out.println("Grado del vertive " + i + ": " + grafo.gradoDeUnVertice(String.valueOf(i)));

		System.out.println();

		for (int i = 1; i <= 6; i++) {
			System.out.print("relaciones del vertive " + i + ": ");
			System.out.print(grafo.relacionesDeUnVertice(String.valueOf(i)));
			System.out.println();
		}

		System.out.println(grafo.profundidadDeUnNodo("6"));

	}

}
