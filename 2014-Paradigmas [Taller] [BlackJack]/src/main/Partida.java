package main;

import java.util.*;

public class Partida extends Mesa {

	private int turno;

	private Jugador croupier;
	private ArrayList<Jugador> jugador = new ArrayList<Jugador>();
	private boolean juegoIniciado = false;

	/**
	 * Crea una nueva partida solicitando los nombres de los jugadores
	 * 
	 * @param nombreJugador1
	 * @param nombreJugador2
	 */
	// Reglas: http://www.youtube.com/watch?v=q1JwKw_c4r0
	public Partida() {
		super();
		croupier = new Jugador("croupier");
		turno = 0;

		// Carta del croupier
		this.croupier.addCarta(this.getCartaFromMaso());
	}

	public void iniciarJuego() {
		this.juegoIniciado = true;
	}

	public void addJugador(String nombre) {
		if (juegoIniciado)
			return;

		jugador.add(new Jugador(nombre));
		jugador.get(jugador.size() - 1).addCarta(this.getCartaFromMaso());
		jugador.get(jugador.size() - 1).addCarta(this.getCartaFromMaso());
	}

	public Eventos pedirCarta() {
		Eventos evn = Eventos.ADD;
		this.getCurrentPlayer().addCarta(getCartaFromMaso());

		// expulsar al jugador
		if (countCartas(this.getCurrentPlayer()) > 21) {
			this.getCurrentPlayer().setEstado(Eventos.EXPULSED);
			this.siguienteTurno();
			evn = Eventos.OVERFLOW;
		}

		return evn;

	}

	// Cuenta los valores de las cartas de un jugador
	public int countCartas(Jugador jugador) {
		int sum = 0;
		boolean As = false;

		// Suma estandar
		for (Carta carta : jugador.getCartas()) {
			if (!As && carta.getNombre() == Nombre.A)
				As = true;
			sum += carta.getNombre().getValor();
		}

		// Si sus cartas contando el As como 1 suman o se pasan de 21 devolver esa suma, o no tiene ningun As
		if (sum >= 21 || !As)
			return sum;

		// Si no, puede que contando un As como 11, su puntaje sea mayor (si hay mas de un As en su mano, solo el primero se contara como 11)
		int sumAs = 0;
		As = false;
		for (Carta carta : jugador.getCartas()) {
			if (!As && carta.getNombre() == Nombre.A) {
				sumAs += 11;
				As = true;
			} else
				sumAs += carta.getNombre().getValor();
		}

		// Si contando los As como 11(o si hay varios As, solo contando el primero como 11), su resultado es igual o mayor a 21 devolver esa suma, si no, comparar las dos sumas y devolver la suma mas alta
		if (sumAs < 21) {
			return (sumAs > sum) ? sumAs : sum;
		} else
			return sum;
	}

	// Terminar el juego
	public Eventos concluirJuego() {
		Eventos evn = Eventos.TERMINATED;

		/*
		 * El crupier está obligado a pedir carta hasta sumar al menos 17.
		 * 
		 * El crupier no podrá pedir ninguna carta más si su mano tiene un valor de 17 o más.
		 * 
		 * Referencia: http://www.casino.es/blackjack/reglas-crupier-blackjack/
		 */
		do { // Primero debe pedir su segunda carta obligatoria
			this.croupier.addCarta(getCartaFromMaso());
		} while (countCartas(this.croupier) < 17);

		int cartasCroupier = countCartas(this.croupier);
		// Todos en la mesa ganan
		if (cartasCroupier > 21) {
			this.croupier.setEstado(Eventos.EXPULSED);
			evn = Eventos.OVERFLOW;
		} else {
			// Asignar ganadores y perdedores
			for (Jugador player : jugador) {
				if (player.getEstado() != Eventos.EXPULSED) {
					// Menos puntaje que el Croupier
					if (countCartas(player) < cartasCroupier)
						player.setEstado(Eventos.LOST);
					// Mismo numero de cartas
					else if (countCartas(player) == cartasCroupier)
						player.setEstado(Eventos.DRAW);
					else
						// Mas cartas
						player.setEstado(Eventos.WIN);
				}
			}
		}

		return evn;

	}

	// retorna un clon del Croupier
	public Jugador getCroupier() {
		return croupier.clone();
	}

	// Retornar un clon de los jugadores
	public ArrayList<Jugador> getJugador() {
		ArrayList<Jugador> clone = new ArrayList<Jugador>(jugador.size());
		for (Jugador clon : jugador)
			clone.add(clon.clone());
		return clone;

	}

	// Pasar turno
	public void siguienteTurno() {
		this.turno++;
	}

	// Hay jugadores en turno aun?
	public boolean hasJugador() {
		return (turno <= jugador.size() - 1 && this.getCurrentPlayer() != null);
	}

	// retorna un clon del jugador actual
	public Jugador getActualJugador() {
		return this.getCurrentPlayer().clone();
	}

	// retorna el jugador actual
	private Jugador getCurrentPlayer() {
		return jugador.get(turno);
	}

}