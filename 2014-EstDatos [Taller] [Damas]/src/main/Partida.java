package main;

public class Partida extends Tablero {

	private int turno;

	private Jugador[] jugador;

	/**
	 * Crea una nueva partida solicitando los nombres de los jugadores
	 * 
	 * @param nombreJugador1
	 * @param nombreJugador2
	 */
	public Partida(String nombreJugador1, String nombreJugador2) {
		super();
		jugador = new Jugador[3];
		jugador[0] = new Jugador(nombreJugador1, Color.NEGRO);
		jugador[1] = new Jugador(nombreJugador2, Color.BLANCO);
		turno = 0;
	}

	// retorna el jugador actual
	public Jugador getActualJugador() {
		return jugador[this.turno];
	}

	// Controller
	public Eventos moverFicha(String letter, int number, String letterTo, int numberTo) {
		// Mover!
		if (this.hasFicha(letter, number)) {
			if (this.getFicha(letter, number).getColor() != this.getActualJugador().getColor())
				return Eventos.ERROR;
		} else
			return Eventos.ERROR;

		Eventos evn = super.moverFicha(letter, number, letterTo, numberTo);
		// Cambiar turno solo si no se comio
		if (evn != Eventos.COMIO)
			this.turno = (this.turno == 0) ? 1 : 0;
		return evn;
	}

}