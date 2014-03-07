package main;

import java.util.*;

public class UI {
	private Partida partida = new Partida();
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
			System.out.println("Paradigmas De Programación 2014-1");
			System.out.println("Jhon Jairo Eslava 1310012946\n");

			System.out.println("Juego de BlackJack\n");

			System.out.println("Ingrese el numero de jugadores:");
			int jugadores = in.nextInt();
			for (int i = 1; i <= jugadores; i++) {
				System.out.println("Nombre del jugador N° " + String.valueOf(i) + ":");
				this.partida.addJugador(in.next());
			}

			System.out.println("Como jugar:");
			System.out.println("\tGana quien tenga mejor mano que el croupier");
			System.out.println();

			printCartasEnLaMesa();

			// Inicia el juego
			this.partida.iniciarJuego();
			do {

				// Jugadores en su turno
				if (this.partida.hasJugador()) {
					this.printActualJugador();
					this.printMenu();

					int action = in.nextInt();

					System.out.println();

					switch (action) {
					// Plantarse
					case 1:
						this.partida.siguienteTurno();
						break;
					// Pedir
					case 2:
						this.pedirCarta();
						break;

					// Salir
					case 3:
						this.exitGame();
						break;

					default:
						System.out.println("No selecciono una opción valida");
						break;

					}
				} else {
					// Conclusion del juego
					this.concluirJuego();
					this.exitGame();
				}

			} while (true);

		} catch (Exception e) {
			System.out.println("\nOpps, ocurreio un error :!");
			System.out.println("Error: " + e.getMessage());
			System.out.println("Bye!");
		}

	}

	private void printMenu() {
		System.out.println("Menu:");
		System.out.println("\t1. Plantarse");
		System.out.println("\t2. Pedir");
		System.out.println("\t3. Terminar la partida");
	}

	private void printActualJugador() {
		System.out.println("[+] Es el turno del jugador " + this.partida.getActualJugador().getNombre());
		printCroupier();
		printJugador(this.partida.getActualJugador());
	}

	private void printCroupier() {
		printJugador(this.partida.getCroupier());
	}

	private void printJugador(Jugador jugador) {
		String palo = "";
		System.out.println("\tCartas del Jugador " + jugador.getNombre() + ":");
		for (Carta carta : jugador.getCartas()) {
			switch (carta.getPalo()) {
			case Corazones:
				palo = " \u2665";
				break;
			case Diamantes:
				palo = " \u25C6";
				break;
			case Picas:
				palo = " \u2660";
				break;
			case Treboles:
				palo = " \u2663";
				break;
			}

			System.out.println("\t" + carta.getNombre() + palo);
		}
		System.out.println("\tTotal: " + String.valueOf(this.partida.countCartas(jugador)));
		System.out.println();
	}

	private void printCartasEnLaMesa() {
		System.out.println("Cartas en la Mesa:");
		printCroupier();
		for (Jugador jugador : partida.getJugador()) {
			printJugador(jugador);
		}
	}

	private void concluirJuego() {
		switch (this.partida.concluirJuego()) {
		case OVERFLOW:
			System.out.println("El croupier se excedió de 21, todos los jugadores activos ganan");
			break;
		case TERMINATED:
			System.out.println("El juego termino");
			for (Jugador jugador : partida.getJugador()) {
				switch (jugador.getEstado()) {
				case WIN:
					System.out.println("\tEl jugador " + jugador.getNombre() + " le gano al croupier");
					break;
				case DRAW:
					System.out.println("\tEl jugador " + jugador.getNombre() + " empato con el croupier");
					break;
				case LOST:
					System.out.println("\tEl jugador " + jugador.getNombre() + " perdio ante el croupier");
					break;
				case EXPULSED:
					System.out.println("\tEl jugador " + jugador.getNombre() + " fue expulsado");
					break;
				}
			}
			break;
		}

		System.out.println("\n\n\n[+] Cartas en la mesa al terminar [+]\n\n\n");
		printCartasEnLaMesa();
	}

	private void pedirCarta() {
		Jugador jugador = this.partida.getActualJugador();
		switch (this.partida.pedirCarta()) {
		case ADD:
			System.out.println("Se removio una carta del maso");
			break;

		case OVERFLOW:
			System.out.println("El jugador " + jugador.getNombre() + " supero 21 y fue expulsado del juego");
			break;
		}
	}

	// Exit Application
	private void exitGame() {
		System.out.println("Bye!");
		System.exit(0);
	}
}