package main;

import java.util.*;

public class UI {
	private Partida partida;
	private Scanner in;

	public UI() {
		super();
		in = new Scanner(System.in);
	}

	public void finalize() {
		in.close();
	}

	public void start() {

		try {
			System.out.println("Estructuras De Datos 2014-1");
			System.out.println("Jhon Jairo Eslava 1310012946\n");
			
			System.out.println("Juego de Damas\n");

			System.out.println("Nombre del primer jugador:");
			String nombre1 = in.next();
			System.out.println("Nombre del segundo jugador:");
			String nombre2 = in.next();

			partida = new Partida(nombre1, nombre2);

			System.out.println("Como jugar:");
			System.out.println("\tPuede moverse indicando la posición de su ficha y luego la posición donde ira");
			System.out.println("\t\tEj: A3->B4");
			System.out.println("\tLas fichas del juego son:");
			System.out.println("\t\tFicha negra: \u25CF");
			System.out.println("\t\tFicha blanca: \u25CB");
			System.out.println("\t\tFicha negra reina: \u25D9");
			System.out.println("\t\tFicha blanca reina: \u25CA");

			do {
				this.printMenu();

				int action = in.nextInt();

				System.out.println();

				switch (action) {
				// Jugar
				case 1:
					this.printActualJugador();
					this.printTablero();
					this.solicitarMovimiento();
					break;

				// Salir
				case 2:
					this.exitGame();
					break;

				default:
					System.out.println("No selecciono una opción valida");
					break;

				}

			} while (true);

		} catch (Exception e) {
			System.out.println("\nOpps, ocurreio un error :!");
			System.out.println("Error: " + e.getMessage());
			System.out.println("Bye!");
		}

	}

	private void printMenu() {
		System.out.println("\nMenu:");
		System.out.println("\t1. Jugar");
		System.out.println("\t2. Abandonar :c");
	}

	private void printActualJugador() {
		System.out.println("Es el turno del jugador " + this.partida.getActualJugador().getNombre() + " -> " + this.colorToString(partida.getActualJugador().getColor()));
	}

	// Tablero virtual
	private void printTablero() {
		int iFila = 8;
		System.out.println("   A  B  C  D  E  F  G  H");
		for (Campo[] filas : this.partida.getTablero()) {
			System.out.print(iFila + "  ");
			for (Campo campo : filas) {
				if (!campo.hasFicha()) {
					if (campo.getColor() == Color.NEGRO)
						System.out.print("\u25A0  ");
					else
						System.out.print("\u25A1  ");
					continue;
				}
				Ficha ficha = campo.getFicha();

				if (ficha.getColor() == Color.NEGRO) {
					if (!ficha.isReina())
						System.out.print("\u25CF  ");
					else
						System.out.print("\u25D9  ");
				} else {
					if (!ficha.isReina())
						System.out.print("\u25CB  ");
					else
						System.out.print("\u25CA  ");
				}
			}
			System.out.print(iFila);
			System.out.println();
			iFila--;
		}
		System.out.println("   A  B  C  D  E  F  G  H");
	}

	private void solicitarMovimiento() {
		System.out.println("Escriba su movimiento:");
		String mov = in.next();
		mov = mov.trim();

		if (mov.length() != 6 || !mov.contains("->")) {
			System.out.println("Movimiento incomprensible!");
			return;
		}

		String[] movs = mov.split("->");

		try {
			Eventos evn = this.partida.moverFicha(movs[0].substring(0, 1), Integer.parseInt(movs[0].substring(1, 2)), movs[1].substring(0, 1), Integer.parseInt(movs[1].substring(1, 2)));

			switch (evn) {
			case ERROR:
				System.out.println("Ocurrio un error al intentar ejecutar el movimiento");
				break;

			case MOVIO:
				System.out.println("Se movio " + mov);
				this.printTablero();
				break;

			case COMIO:
				System.out.println("Se movio y comio " + mov);
				System.out.println("El jugador " + this.partida.getActualJugador().getNombre() + " sigue en el turno\n");
				this.printTablero();
				break;

			case REINA:
				System.out.println("El jugador " + this.partida.getActualJugador().getNombre() + " ahora tiene una ficha reina\n");
				break;

			case GANO:
				System.out.println("El jugador " + this.partida.getActualJugador().getNombre() + " es el GANADOR!!!\n");
				this.exitGame();
				break;
			}

		} catch (Exception e) {
			System.out.println("Movimiento incomprensible!");
		}
	}

	private String colorToString(Color color) {
		String sRet = "";
		switch (color) {
		case BLANCO:
			sRet = "BLANCO";
			break;

		case NEGRO:
			sRet = "NEGRO";
			break;
		}
		return sRet;
	}

	// Exit Application
	private void exitGame() {
		System.out.println("Bye!");
		System.exit(0);
	}
}