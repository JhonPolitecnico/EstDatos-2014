package poligran;

import java.util.Scanner;

/**
 * Ventiuna
 * 
 * @author Politecnico Grancolombiano
 * 
 */
public class MainVentiuna {
	public int NUMERO_CARTAS = 52;
	public int MAX_OPCIONES = 4;
	public int RELANCINA = 100;
	public int CHIPOLO = 1000;
	public int MAX_PALOS = 4;
	public int MAX_VALORES = 13;
	// Palos
	public char PALOS_PICAS = '♠';
	public char PALOS_CORAZONES = '♥';
	public char PALOS_TREBOLES = '♣';
	public char PALOS_DIAMANTES = '♦';
	public char[] palosSegunImagenes = { PALOS_CORAZONES, PALOS_TREBOLES, PALOS_PICAS, PALOS_DIAMANTES };

	public int turnoActual = 1;
	public boolean partidaTerminada = false;

	public char[] palos = { PALOS_PICAS, PALOS_CORAZONES, PALOS_TREBOLES, PALOS_DIAMANTES };

	// Valores en String
	public char[] valores = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K' };
	public int[] puntajes = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

	// TODO : PUNTO 1 : Declare los arreglos que representan el
	// juego.-------------------------------------------------------
	/*
	 * 
	 * El arreglo etiquetasCartas es un arreglo de Strings que representa las etiquetas de la carta i El arreglo puntajesCartas es un arreglo entero que representa el puntaje de la carta i El arreglo
	 * cantidadCartas es un arreglo entero que representa la cantidad existente de la carta i El arreglo cartasJugador1 es un arreglo entero que representa la cantidad de carta i que tiene el jugador
	 * 1 El arreglo cartasJugador2 es un arreglo entero que representa la cantidad de carta i que tiene el jugador 2 El arreglo cartasJugador3 es un arreglo entero que representa la cantidad de carta
	 * i que tiene el jugador 3 El arreglo cartasJugador4 es un arreglo entero que representa la cantidad de carta i que tiene el jugador 4
	 */
	public String[] etiquetasCartas = new String[NUMERO_CARTAS];
	public int[] puntajesCartas = new int[NUMERO_CARTAS];
	public int[] cantidadCartas = new int[NUMERO_CARTAS];
	public int[] cartasJugador1 = new int[NUMERO_CARTAS];
	public int[] cartasJugador2 = new int[NUMERO_CARTAS];
	public int[] cartasJugador3 = new int[NUMERO_CARTAS];
	public int[] cartasJugador4 = new int[NUMERO_CARTAS];

	// TODO: FIN PUNTO 1:
	// ----------------------------------------------------------------------------------------------------

	public void reiniciar() {

		// TODO: PUNTO 2:
		// ----------------------------------------------------------------------------------------------------
		/*
		 * Modificar los valores del arreglo de etiquetasCartas y puntajesCartas para que queden correctos
		 */
		int carta = 0;
		for (int i = 0; i < MAX_PALOS; i++) {
			for (int j = 0; j < MAX_VALORES; j++, carta++) {
				char p = palos[i];
				char v = valores[j];
				etiquetasCartas[carta] = p + "" + v;
				puntajesCartas[carta] = puntajes[j];
			}
		}
		// TODO: FIN PUNTO 2:
		// ------------------------------------------------------------------------------------------------
		cartasJugador1 = new int[NUMERO_CARTAS];
		cartasJugador2 = new int[NUMERO_CARTAS];
		cartasJugador3 = new int[NUMERO_CARTAS];
		cartasJugador4 = new int[NUMERO_CARTAS];
		// cantidad inicial de cartas
		for (int i = 0; i < cantidadCartas.length; i++) {
			cantidadCartas[i] = 1;
		}
		turnoActual = 1;
		repartir();
	}

	private void repartir() {
		pedirCarta(1);
		pedirCarta(1);
		pedirCarta(2);
		pedirCarta(2);
		pedirCarta(3);
		pedirCarta(3);
		pedirCarta(4);
		pedirCarta(4);

	}

	/**
	 * contarCartas
	 * 
	 * @param jugador
	 * @return El metodo tiene la responsabilidad de contar las cartas del jugador que tiene como parametro Para hacerlo, se debe revisar el arreglo cartasJugador que corresponda
	 */
	public int contarCartas(int jugador) {
		// TODO: PUNTO 3:
		// --------------------------------------------------------------------------------------------------------
		/*
		 * Este metodo debe retornar la cantidad de cartas que tiene un jugador particular, el parametro es el numero de jugador por quien se esta preguntando.
		 */
		int contador = 0;
		if (jugador == 1) {
			for (int i = 0; i < cartasJugador1.length; i++) {
				contador += cartasJugador1[i];
			}
		} else if (jugador == 2) {
			for (int i = 0; i < cartasJugador2.length; i++) {
				contador += cartasJugador2[i];
			}
		} else if (jugador == 3) {
			for (int i = 0; i < cartasJugador3.length; i++) {
				contador += cartasJugador3[i];
			}
		} else if (jugador == 4) {
			for (int i = 0; i < cartasJugador4.length; i++) {
				contador += cartasJugador4[i];
			}
		}

		return contador;
		// TODO: FIN PUNTO 3:
		// --------------------------------------------------------------------------------------------------------
	}

	/**
	 * contarPuntaje
	 * 
	 * @param jugador
	 * @return El metodo tiene la responsabilidad de contar el puntaje de las cartas que tiene el jugador que viene como parametro Para hacerlo, debe utilizar el arreglo cartasJugador que corresponda
	 *         y el arreglo puntajesCartas
	 */
	public int contarPuntaje(int jugador) {
		// TODO: PUNTO 4:
		// --------------------------------------------------------------------------------------------------------------
		/*
		 * Este metodo debe retornar el puntaje total que tiene un jugador.
		 */
		int puntaje = 0;
		if (jugador == 1) {
			for (int i = 0; i < cartasJugador1.length; i++) {
				int pos = cartasJugador1[i];
				if (pos != 0) {
					puntaje += puntajesCartas[i];
				}
			}
		} else if (jugador == 2) {
			for (int i = 0; i < cartasJugador2.length; i++) {
				int pos = cartasJugador2[i];
				if (pos != 0) {
					puntaje += puntajesCartas[i];
				}
			}
		} else if (jugador == 3) {
			for (int i = 0; i < cartasJugador3.length; i++) {
				int pos = cartasJugador3[i];
				if (pos != 0) {
					puntaje += puntajesCartas[i];
				}
			}
		} else if (jugador == 4) {
			for (int i = 0; i < cartasJugador4.length; i++) {
				int pos = cartasJugador4[i];
				if (pos != 0) {
					puntaje += puntajesCartas[i];
				}
			}
		}

		return puntaje;
		// TODO: FIN PUNTO 4:
		// --------------------------------------------------------------------------------------------------------------
	}

	public String[] darListaCartasJugador(int jugador) {
		// TODO: PUNTO
		// 5----------------------------------------------------------------------------------------------------------------
		/*
		 * Este metodo debe retornar un arreglo de string con las etiquetas de las cartas que tiene un jugador particular
		 */
		String[] listaCartas = new String[contarCartas(jugador)];
		if (jugador == 1) {
			for (int i = 0, j = 0; i < cartasJugador1.length; i++) {
				if (cartasJugador1[i] > 0) {
					listaCartas[j] = etiquetasCartas[i];
					j++;
				}
			}

		} else if (jugador == 2) {
			for (int i = 0, j = 0; i < cartasJugador2.length; i++) {
				if (cartasJugador2[i] > 0) {
					listaCartas[j] = etiquetasCartas[i];
					j++;
				}
			}
		} else if (jugador == 3) {
			for (int i = 0, j = 0; i < cartasJugador3.length; i++) {
				if (cartasJugador3[i] > 0) {
					listaCartas[j] = etiquetasCartas[i];
					j++;
				}
			}
		} else if (jugador == 4) {
			for (int i = 0, j = 0; i < cartasJugador4.length; i++) {
				if (cartasJugador4[i] > 0) {
					listaCartas[j] = etiquetasCartas[i];
					j++;
				}
			}
		}
		return listaCartas;
		// TODO: FIN PUNTO
		// 5--------------------------------------------------------------------------------------------------------------------
	}

	public void pedirCarta(int jugador) {
		int cartaAleatoria1 = darPosicionCartaAleatoria();

		while (cantidadCartas[cartaAleatoria1] == 0 || cartaAleatoria1 == 0 || cartaAleatoria1 == 1) {
			cartaAleatoria1 = darPosicionCartaAleatoria();
		}
		// reducir de la cantidad de cartas
		cantidadCartas[cartaAleatoria1]--;
		if (jugador == 1) {
			// aumentar en las cartas del jugador
			cartasJugador1[cartaAleatoria1]++;
		} else if (jugador == 2) {
			// aumentar en las cartas del jugador
			cartasJugador2[cartaAleatoria1]++;
		} else if (jugador == 3) {
			// aumentar en las cartas del jugador
			cartasJugador3[cartaAleatoria1]++;
		} else if (jugador == 4) {
			// aumentar en las cartas del jugador
			cartasJugador4[cartaAleatoria1]++;
		}
		validar(jugador);

	}

	private int validar(int jugador) {
		// caso relancina
		boolean relancina = validarRelancina(jugador);
		// caso chipolo
		boolean chipolo = validarChipolo(jugador);
		// contar los puntajes, considere el as como 1
		int puntaje = contarPuntaje(jugador);

		if (relancina) {
			System.out.println("El jugador " + jugador + " tiene relancina");
			puntaje = RELANCINA;
		} else if (chipolo) {
			System.out.println("El jugador " + jugador + " tiene chipolo");
			puntaje = CHIPOLO;
		} else {
			if (puntaje == 21) {
				System.out.println("El jugador " + jugador + " tiene ventiuna");
			} else if (puntaje > 21) {
				System.out.println("El jugador " + jugador + " se pasó!");
			} else {
				if (puntaje != 0) {
					System.out.println("El jugador " + jugador + " tiene " + puntaje);
				}
			}
		}
		return puntaje;
	}

	public String darValidacion(int jugador) {
		String respuesta = "";
		// caso relancina
		boolean relancina = validarRelancina(jugador);
		// caso chipolo
		boolean chipolo = validarChipolo(jugador);
		// contar los puntajes, considere el as como 1
		int puntaje = contarPuntaje(jugador);

		if (relancina) {
			respuesta = ("El jugador " + jugador + " tiene relancina");
			puntaje = RELANCINA;
		} else if (chipolo) {
			respuesta = ("El jugador " + jugador + " tiene chipolo");
			puntaje = CHIPOLO;
		} else {
			if (puntaje == 21) {
				respuesta = ("El jugador " + jugador + " tiene ventiuna");
			} else if (puntaje > 21) {
				respuesta = ("El jugador " + jugador + " se pasó!");
			} else {
				if (puntaje != 0) {
					respuesta = ("El jugador " + jugador + " tiene " + puntaje);
				}
			}
		}
		return respuesta;
	}

	private boolean validarRelancina(int jugador) {
		String[] cartas = darListaCartasJugador(jugador);
		if (cartas.length == 2) {
			char v0 = cartas[0].charAt(1);
			char v1 = cartas[1].charAt(1);

			if ((esAs(v0) && esJQK(v1)) || (esAs(v1) && esJQK(v0))) {
				return true;
			}
		}
		return false;
	}

	private boolean esAs(char v) {
		if (v == 'A') {
			return true;
		}
		return false;
	}

	private boolean esJQK(char v) {
		if (v == 'J' || v == 'Q' || v == 'K') {
			return true;
		}
		return false;
	}

	private boolean validarChipolo(int jugador) {
		String[] cartas = darListaCartasJugador(jugador);
		if (cartas.length == 2) {
			char v0 = cartas[0].charAt(1);
			char v1 = cartas[1].charAt(1);

			if ((esAs(v0) && esAs(v1))) {
				return true;
			}
		}
		return false;
	}

	public int darPosicionCartaAleatoria() {
		double millis = Math.random() * 100000;
		millis = Math.round(millis);
		millis = millis % NUMERO_CARTAS;
		int res = (int) millis;
		return res;
	}

	public void main(String[] args) {
		reiniciar();
		menu();
	}

	public void cambiarTurno() {
		if (turnoActual < 4) {
			turnoActual++;
		} else if (turnoActual == 4) {
			turnoActual = 1;
		}
	}

	private void menu() {
		// variable para guardar la opcion seleccionada por el usuario
		int opcion = 0;
		// scanner para pedir al usuario la opcion de menu
		Scanner teclado = new Scanner(System.in);
		// ciclo encargado de mostrar al usuario las opciones de menu cada
		// jugada hasta que decida salir
		while (opcion < MAX_OPCIONES) {

			// titulo
			System.out.println("-------------------Ventiuna!!---------------- ");

			// mostrar las opciones posibles para el usuario
			System.out.println(" El turno es del jugador " + turnoActual + ", Seleccione opcion: ");
			if (!partidaTerminada) {
				System.out.println(" 1. Pedir Carta");
				System.out.println(" 2. Plantar");
				System.out.println(" 3. Mostrar cartas");
				System.out.println(" 4. Salir");
				System.out.println("----------------------------------------------");
			} else {
				System.out.println(" 4. Salir");
				System.out.println("----------------------------------------------");
			}

			// pido la opcion de menu al usuario
			opcion = teclado.nextInt();
			if (opcion == 1) // si la opcion es 1, juego
			{
				if (!partidaTerminada)
					pedirCarta(turnoActual);
			} else if (opcion == 2) // si la opcion es 2, planta (termina turno)
			{
				if (!partidaTerminada)
					plantar(turnoActual);
			} else if (opcion == 3) // si la opcion es 3, muestro estado
			{
				if (!partidaTerminada)
					mostrarCartasJugador(turnoActual);
			} else if (opcion == 4) // si la opcion es 4, salgo
			{
				System.out.println("Ha seleccionado salir del juego!");
			} else // cualquier otra cosa que escriba el usuario es invalida
			{
				System.out.println("Opcion Invalida");
			}
			// imprimir algunos espacios
			espacios();
		}
	}

	public void plantar(int jugador) {
		if (jugador < 4) {
			cambiarTurno();
		} else if (jugador == 4) {
			System.out.println("Fin del juego, los resultados finales son: ");
			validar(1);
			validar(2);
			validar(3);
			validar(4);
			partidaTerminada = true;
		}
	}

	private void espacios() {

		System.out.println("---------Pulse Enter para continuar-----------");
		new Scanner(System.in).nextLine();
		for (int i = 0; i < 25; i++) {
			System.out.println();
		}
	}

	public int darTurno() {
		return turnoActual;
	}

	public boolean darPartidaTerminada() {
		return partidaTerminada;
	}

	/**
	 * mostrarCartasJugador
	 * 
	 * @param jugador
	 *            El metodo tiene la responsabilidad de mostrar las cartas del jugador que viene como parametro Para hacerlo, debe utilizar el arreglo cartasJugador que corresponda y el arreglo
	 *            etiquetasCartas
	 */
	private void mostrarCartasJugador(int jugador) {

		if (jugador == 1) {
			System.out.println("Cartas del jugador 1");
			for (int i = 0; i < cartasJugador1.length; i++) {
				if (cartasJugador1[i] > 0) {
					System.out.println(etiquetasCartas[i]);
				}
			}

		} else if (jugador == 2) {
			System.out.println("Cartas del jugador 2");
			for (int i = 0; i < cartasJugador2.length; i++) {
				if (cartasJugador2[i] > 0) {
					System.out.println(etiquetasCartas[i]);
				}
			}
		} else if (jugador == 3) {
			System.out.println("Cartas del jugador 3");
			for (int i = 0; i < cartasJugador3.length; i++) {
				if (cartasJugador3[i] > 0) {
					System.out.println(etiquetasCartas[i]);
				}
			}
		} else if (jugador == 4) {
			System.out.println("Cartas del jugador 4");
			for (int i = 0; i < cartasJugador4.length; i++) {
				if (cartasJugador4[i] > 0) {
					System.out.println(etiquetasCartas[i]);
				}
			}
		}

		validar(jugador);
	}

}
