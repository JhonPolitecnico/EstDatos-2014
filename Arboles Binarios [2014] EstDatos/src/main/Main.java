package main;

import kernel.binary.tree.Arbol;
import ui.console.UI;

public class Main {

	public static void main(String[] args) {

		Arbol arbol = new Arbol();

		// Raiz
		arbol.addNode(20);
		// Lado izquierdo
		arbol.addNode(12);
		arbol.addNode(5);
		arbol.addNode(13);
		arbol.addNode(2);
		arbol.addNode(15);
		arbol.addNode(7);
		// Lado derecho
		arbol.addNode(40);
		arbol.addNode(47);
		arbol.addNode(30);
		arbol.addNode(35);

		/*
		 * UI UI = new UI(); UI.on();
		 */
	}

}
