package main;

import hashtable.Capital;

public class Main {

	public static void main(String[] args) {
		Capital capitales = new Capital();
		capitales.insertarPareja("Colombia", "Bogota");
		System.out.println(capitales.buscarPorClave("Colombia"));
		capitales.removerPorClave("Colombia");
		System.out.println(capitales.buscarPorClave("Colombia"));
	}

}
