package ui.console;

import java.util.ArrayList;

import kernel.console.ConsoleUI;
import kernel.lagrange.polynomial.D;
import kernel.lagrange.polynomial.L;
import kernel.lagrange.polynomial.Math;
import kernel.lagrange.polynomial.P;
import kernel.lagrange.polynomial.Point;
import kernel.subsets.tree.SubsetsTree;

public class UI extends ConsoleUI {

	private L[] ls = null;
	private Point[] points = null;
	private P p = null;

	@Override
	protected String[] registerCommands() {
		return new String[] { "puntos", "agregar", "generar", "sub", "distancia", "salir" };
	}

	@Override
	protected void printHeader() {
		System.out.println("Helementos de Teoria de la Computacion 2014-1");
		System.out.println();
		System.out.println("Jhon Jairo Eslava\t\t\t1310012946");
		System.out.println("Juan Guillermo Celemin\t\t\t1210010657");
		System.out.println("Michael Roberto Torres\t\t\t1310019024");
		System.out.println("Jabier Alejandro Sierra\t\t\t0612040895");
		System.out.println();
		System.out.println("Polinomio de interpolacion de Lagrange\n");
	}

	@Override
	protected void printMenu() {
		System.out.println("\nMenu:");
		System.out.println("puntos:\t\t\tNumero De Puntos");
		System.out.println("agregar:\t\tAgregar Puntos");
		System.out.println("generar:\t\tGenerar P(x)");
		System.out.println("sub:\t\t\tObtener el numero de subconjuntos posibles");
		System.out.println("distancia:\t\tObtener la distancia entre el conjunto principal y los subconjuntos indicados");
		System.out.println("salir:\t\t\tSalir");

	}

	@Override
	protected void onError(Exception e) {
		System.out.println("\nOpps, ocurrio un error :!");
		System.out.println("Error: " + e.getMessage());
		System.out.println("Bye!");

	}

	@Override
	protected void onCommand(String command) {
		// ...
	}

	@Override
	protected void onInvalidCommand(String command) {
		System.out.println("No selecciono una opci\u00F3n valida");
	}

	private void nullError() {
		System.out.println("Opps!, Primero tienes que definir tu conjunto de puntos.");
	}

	/*
	 * Actions
	 */

	public void puntosAction() {
		System.out.println("Digite el numero de puntos que tiene su conjunto:");
		if (in.hasNextInt()) {
			int n = in.nextInt();

			ls = new L[n];
			points = new Point[n];

			System.out.println("Muy Bien!, ahora agrege los puntos a su conjunto, escribiendo 'agregar'.");
		} else {
			System.out.println("Opps!, Ingresaste un numero invalido");
			this.skipError();
		}
	}

	public void agregarAction() {
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
						this.skipError();
						continue;
					}

					System.out.println("Escriba la coordenada 'y' del punto " + i + ":");
					if (in.hasNextInt()) {
						y = in.nextInt();
						points[i] = new Point(x, y);
						break;
					} else {
						this.skipError();
						continue;
					}

				}
			}

			System.out.println("Puntos agregados con exito!, solo te resta generar la funcion.");
		}

	}

	public void generarAction() {
		if (ls == null || points == null) {
			this.nullError();
			return;
		}

		// Calcular polinomios individuales
		for (int i = 0; i < ls.length; i++) {
			ls[i] = new L(i, points);
		}

		// Generar funcion de interpolacion de Lagrange
		p = new P(ls, points);
		System.out.println(p.toString());
	}

	public void subAction() {
		if (ls == null || points == null) {
			this.nullError();
			return;
		}

		System.out.println("Escriba la longutud de elementos del subconjunto:");
		if (in.hasNextInt()) {
			int iSub = in.nextInt();

			if (iSub > points.length) {
				System.out.println("La longitud del subconjunto no puede ser mayor al del conjunto original");
			}

			System.out.println("El numero de subconjuntos posibles es: " + Math.binomialCoefficient(points.length, iSub));
		} else {
			System.out.println("Es un subconjunto invalido.");
			this.skipError();
		}
	}

	public void distanciaAction() {
		if (ls == null || points == null) {
			this.nullError();
			return;
		}

		System.out.println("Escriba la longutud de elementos del subconjunto:");
		if (in.hasNextInt()) {
			int iSub = in.nextInt();

			if (iSub > points.length) {
				System.out.println("La longitud del subconjunto no puede ser mayor al del conjunto original");
				return;
			}

			// Obtener los subconjuntos
			SubsetsTree tree = new SubsetsTree(this.points, iSub);
			ArrayList<ArrayList<Object>> susetsOfPoints = tree.getSubsets();

			// Evaluar todos los subconjuntos con respecto al conjunto principal
			L[] subLs = null;
			Point[] subPoints = null;
			MinorSubset minor = null;

			for (ArrayList<Object> oSubPoints : susetsOfPoints) {
				subLs = new L[iSub];
				subPoints = oSubPoints.toArray(new Point[iSub]);

				// Calcular polinomios individuales
				for (int i = 0; i < subLs.length; i++) {
					subLs[i] = new L(i, subPoints);
				}

				// Generar funcion de interpolacion de Lagrange
				P subP = new P(subLs, subPoints);

				D d = new D(subPoints, p, subP);

				if (minor == null || d.getDistance() <= minor.getDistance()) {
					minor = new MinorSubset(d.getDistance(), subPoints);
				}

			}

			// Imprimir el subconjunto de menor distancia del conjunto original
			System.out.println("La menor distancia es: ");
			Point tmpPoint = null;
			System.out.print("\t{");
			for (int i = 0; i < minor.getPoints().length; i++) {
				tmpPoint = minor.getPoints()[i];
				System.out.print("(" + tmpPoint.getX() + ", " + tmpPoint.getY() + ((i == minor.getPoints().length - 1) ? ")" : "),"));
			}
			System.out.println("}");
			System.out.println("\tDistancia: " + minor.getDistance());

		} else {
			System.out.println("Es un subconjunto invalido.");
			this.skipError();
		}
	}

	public void salirAction() {
		System.out.println("Bye!");
		this.off();
	}

}
