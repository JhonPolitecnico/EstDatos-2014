package main;

import kernel.binary.tree.Arbol;
import kernel.binary.tree.Nodo;
import ui.console.UI;

/**
 * Arbol binario
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
public class Main {

	/*
	 * Guia: http://prezi.com/jf3pn1z9lxv4/arboles-binarios/
	 */

	public static void main(String[] args) {
		boolean testMode = false;

		if (testMode) {

			Arbol arbol = new Arbol();
			Nodo node = null;

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

			System.out.println("Preorden:");
			System.out.println(arbol.preorden());

			System.out.println("Inorden:");
			System.out.println(arbol.inorden());

			System.out.println("Postorden:");
			System.out.println(arbol.postorden());

			System.out.println("Numero de hojas:");
			System.out.println(arbol.getNumberOfLeaves());

			System.out.println("Numero de nodos:");
			System.out.println(arbol.getNumberOfNodes());

			System.out.println("Altura:");
			System.out.println(arbol.getHigh());

			for (int i = 0; i <= 50; i++) {
				node = arbol.search(i);
				System.out.println("Buscar el numero " + i + ":");
				System.out.println((node != null) ? "\t\tEncontrado!" : "No existe :c");
			}

			System.out.println();
			System.out.println();

			System.out.println("Nodo mas izquierdo: " + arbol.getLeftOfleft().getNum());

			System.out.println();
			System.out.println();

			for (int i = 0; i <= 50; i++) {
				node = arbol.getParent(i);
				System.out.println("Buscar el padre de: " + i + ":");
				System.out.println((node != null) ? "\t\tEncontrado: " + node.getNum() + "!" : "No tiene padre :'c");
			}

		} else {
			UI UI = new UI();
			UI.on();
		}

	}
}
