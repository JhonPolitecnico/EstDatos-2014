package main;

import java.util.Scanner;

import kernel.lagrange.polynomial.L;
import kernel.lagrange.polynomial.P;
import kernel.lagrange.polynomial.Point;

public class UI {
	private Scanner in;

	public void start() {
		try {

			in = new Scanner(System.in);
			int action = 0;

			L[] ls = null;
			Point[] points = null;
			P p = null;

			try {
				System.out.println("Helementos de Teoria de la Computacion 2014-1");
				System.out.println();
				System.out.println("Jhon Jairo Eslava\t\t\t1310012946");
				System.out.println("Juan Guillermo Celemin\t\t\t1210010657");
				System.out.println("Jhon Jairo Eslava 1310012946");
				System.out.println("Jhon Jairo Eslava 1310012946");
				System.out.println();
				System.out.println("3 Cajeros y 1 lista de usuarios\n");

				do {

					this.printMenu();

					// Get action
					if (in.hasNextInt())
						action = in.nextInt();
					else {
						action = 0;
						in.next();
					}

					// New line
					System.out.println();

					switch (action) {

					case 1:
						System.out.println("Digite el numero de puntos que tiene su conjunto:");
						if (in.hasNextInt()) {
							int n = in.nextInt();

							ls = new L[n];
							points = new Point[n];

							System.out.println("Muy Bien!, ahora agrege los puntos a su conjunto, con el numero 2 del menu.");
						}
						break;

					case 2:

						if (points == null) {
							this.nullError();
						} else {
							int x = 0;
							int y = 0;
							for (int i = 0; i < points.length; i++) {
								while (true) {
									System.out.println("Escriba la coordenada 'x' del punto " + i + ":");
									if (in.hasNextInt())
										x = in.nextInt();
									else {
										in.next();
										continue;
									}

									System.out.println("Escriba la coordenada 'y' del punto " + i + ":");
									if (in.hasNextInt()) {
										y = in.nextInt();
										points[i] = new Point(x, y);
										break;
									} else {
										in.next();
										continue;
									}

								}
							}

							System.out.println("Puntos agregados con exito!, solo te resta generar la funcion.");
						}
						break;

					case 3:

						if (ls == null || points == null) {
							this.nullError();
							break;
						}
						
						System.out.println("ffff");

						// Calcular polinomios individuales
						for (int i = 0; i < ls.length; i++) {
							ls[0] = new L(i, points);
						}
						
						System.out.println("ffff");

						// Generar funcion de interpolacion de Lagrange
						p = new P(ls, points);
						System.out.println("ffff");
						System.out.println(p.toString());

						break;

					// Exit
					case 4:
						System.out.println("Bye!");
						System.exit(0);
						break;

					// Invalid option
					default:
						System.out.println("No selecciono una opci\u00F3n valida");
						break;

					}

				} while (true);

			} catch (Exception e) {
				System.out.println("\nOpps, ocurrio un error :!");
				System.out.println("Error: " + e.getMessage());
				System.out.println("Bye!");
			}
		} finally {
			in.close();
		}

	}

	private void nullError() {
		System.out.println("Opps!, Primero tienes que definir tu conjunto de puntos.");
	}

	private void printMenu() {
		System.out.println("\nMenu:");
		System.out.println("\t1. Numero De Puntos");
		System.out.println("\t2. Agregar Puntos");
		System.out.println("\t3. Generar P(x)");
		System.out.println("\t4. Salir");
	}
}