/**
 * Teoria de listas doblemente enlazadas 
 * 
 * 
 * @author Michael Torres
 * @author Jhon Eslava
 */

import java.util.Scanner;

public class Test {
	// Metodo estatico utilizado para obtener valores aleatorios entre 1 y 500
	// Se utiliza para crear una lista doblemente enlazada automaticamente con valores tipo int

	public static int obtenerAleatorio() {
		int temp = 0;
		for (int i = 0; i < 500; i++) {
			temp = (int) (Math.random() * 500 + 1);
		}
		return temp;
	}

	public static void main(String[] args) {

		ListaDoble l1 = new ListaDoble();

		Scanner teclado = new Scanner(System.in);

		int menu = 0;
		int menuListas = 0;
		int dato = 0;
		int indice = 0;

		while (menu != 9) {
			System.out.println("**************LISTAS.DOBLEMENTE.ENLAZADAS*****************");
			System.out.println("(1) Crear una lista con valores enteros aleatoriamente");
			System.out.println("(2) Insertar nodo al inicio");
			System.out.println("(3) Insertar nodo al final");
			System.out.println("(4) Eliminar nodo al incio");
			System.out.println("(5) Eliminar nodo al final");
			System.out.println("(6) Imprimir lista en ambos sentidos");
			System.out.println("(7) Insertar nodo en subindice especifico");
			System.out.println("(8) Eliminar nodo en subindice especifico");
			System.out.println("(9) Salir del programa!!!!");

			menu = teclado.nextInt();

			if (menu == 1) {
				System.out.println("***********************CREAR.LISTA.DOBLE*************************");
				System.out.println("*****************************************************************");
				System.out.print("Ingrese el tamaño de la lista:");
				menuListas = teclado.nextInt();
				System.out.println();

				for (int x = 0; x < menuListas; x++) {
					l1.insertarInicio(obtenerAleatorio());
				}
				System.out.println("Se ha generado la lista doble enlazada correctamente");
				System.out.println();
				menuListas = 0;
			} else if (menu == 2) {
				System.out.print("Ingresar dato: ");
				dato = teclado.nextInt();
				System.out.println();

				l1.insertarInicio(dato);
			} else if (menu == 3) {
				System.out.print("Ingresar dato: ");
				dato = teclado.nextInt();
				System.out.println();

				l1.insertarFinal(dato);
			} else if (menu == 4) {
				l1.eliminarInicio();
			} else if (menu == 5) {
				l1.eliminarFinal();
			} else if (menu == 6) {
				l1.imprimirIzquierdaDerecha();
				l1.imprimirDerechaIzquierda();
			} else if (menu == 7) {
				// Aca se debe llamar al metodo que inserte nodos en el subindice especifico
				System.out.print("Ingresar indice: ");
				indice = teclado.nextInt();
				System.out.print("Ingresar dato: ");
				dato = teclado.nextInt();
				l1.agregarNodo(indice, dato);
			} else if (menu == 8) {
				// Aca se debe llamar al metodo que elimine nodos en el subindice especifico
				System.out.print("Ingresar indice: ");
				indice = teclado.nextInt();
				l1.eliminarNodo(indice);
			}

		}

		System.out.println("Ha salido del programa!!!");
	}

}
