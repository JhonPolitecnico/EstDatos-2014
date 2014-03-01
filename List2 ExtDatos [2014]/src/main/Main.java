package main;

import lista.Lista;

public class Main {

	public static void main(String[] args) {

		// Creamos la lista
		Lista lista = new Lista();
		lista.addContent("Hola");
		lista.addContent(" ");
		lista.addContent("Mundo");
		lista.addContent("!!!");

		lista.addContent(3, " -> ");

		System.out.print(lista.getContent(0));
		System.out.print(lista.getContent(1));
		System.out.print(lista.getContent(2));
		System.out.print(lista.getContent(3));
		System.out.print(lista.getContent(4));

	}

}
