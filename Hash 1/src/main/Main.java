package main;

import hashtable.Capital;

public class Main {

	public static void main(String[] args) {
		Capital capitales = new Capital();

		// Insertar
		capitales.insertarPareja("Colombia", "Bogota");
		capitales.insertarPareja("Venezuela", "Caracas");
		capitales.insertarPareja("Uruguay", "Montevideo");
		capitales.insertarPareja("Ucrania", "Kiev");

		// Bogota
		System.out.println(capitales.buscarPorClave("Colombia"));
		// Eliminar
		capitales.removerPorClave("Colombia");
		// Null
		System.out.println(capitales.buscarPorClave("Colombia"));
		// Caracas, Montevideo, Kiev
		System.out.println(capitales.devolverParejas());
	}

}
