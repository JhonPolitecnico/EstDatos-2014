package main;

import grafo.Grafo;

public class Main {

	public static void main(String[] args) {

		/*
		 * Grafo grafo = new Grafo(6); grafo.insertarVertice("1"); grafo.insertarVertice("2"); grafo.insertarVertice("3"); grafo.insertarVertice("4"); grafo.insertarVertice("5");
		 * grafo.insertarVertice("6");
		 * 
		 * grafo.insertarArco("1", "1"); grafo.insertarArco("1", "2"); grafo.insertarArco("1", "5");
		 * 
		 * grafo.insertarArco("2", "3"); grafo.insertarArco("2", "5");
		 * 
		 * grafo.insertarArco("3", "4");
		 * 
		 * grafo.insertarArco("4", "5"); grafo.insertarArco("4", "6");
		 */

		Grafo grafo = new Grafo(8);
		grafo.insertarVertice("A");
		grafo.insertarVertice("B");
		grafo.insertarVertice("C");
		grafo.insertarVertice("D");
		grafo.insertarVertice("E");
		grafo.insertarVertice("F");
		grafo.insertarVertice("G");
		grafo.insertarVertice("H");

		grafo.insertarArco("A", "B");
		grafo.insertarArco("A", "E");
		grafo.insertarArco("A", "F");
		grafo.insertarArco("A", "H");

		grafo.insertarArco("B", "C");

		grafo.insertarArco("C", "D");

		grafo.insertarArco("F", "G");
		grafo.insertarArco("F", "H");

		System.out.println(grafo);

		for (int i = 1; i <= 8; i++) {
			char letter = (char) (64 + i);
			System.out.println("Grado del vertive " + i + ": " + grafo.gradoDeUnVertice(String.valueOf(letter)));
		}
		System.out.println();

		for (int i = 1; i <= 8; i++) {
			char letter = (char) (64 + i);
			System.out.print("relaciones del vertive " + letter + ": ");
			System.out.print(grafo.relacionesDeUnVertice(String.valueOf(letter)));
			System.out.println();
		}

		System.out.println("Profundidad desde el vertice C: " + grafo.profundidadDeUnNodo("C"));

	}

}
