package main;

public class Tablero {
	// Tablero de damas
	private Campo[][] tablero;
	// fichas en el tablero (no usar ciclos para comprovar el ganador, come mas recursos)
	private int blancas;
	private int negras;

	/**
	 * Se crea nun tablero cuando se crea una nueva partida
	 */
	public Tablero() {

		/**
		 * Creo un nuevo tablero
		 */
		tablero = new Campo[8][8];
		Color color;

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {

				// inicia blanco y se intercala
				if (i % 2 == 0)
					color = (j % 2 == 0) ? Color.BLANCO : Color.NEGRO;
				else
					color = (j % 2 == 0) ? Color.NEGRO : Color.BLANCO;

				// creo los campos del tablero
				tablero[i][j] = new Campo(color);
			}
		}

		/**
		 * Establero las fichas
		 */

		/*
		 * Blancas
		 */

		// Primera Fila
		this.setFicha("A", 1, new Ficha(Color.BLANCO));
		this.setFicha("C", 1, new Ficha(Color.BLANCO));
		this.setFicha("E", 1, new Ficha(Color.BLANCO));
		this.setFicha("G", 1, new Ficha(Color.BLANCO));

		// Segunda Fila
		this.setFicha("B", 2, new Ficha(Color.BLANCO));
		this.setFicha("D", 2, new Ficha(Color.BLANCO));
		this.setFicha("F", 2, new Ficha(Color.BLANCO));
		this.setFicha("H", 2, new Ficha(Color.BLANCO));

		// Tercera Fila
		this.setFicha("A", 3, new Ficha(Color.BLANCO));
		this.setFicha("C", 3, new Ficha(Color.BLANCO));
		this.setFicha("E", 3, new Ficha(Color.BLANCO));
		this.setFicha("G", 3, new Ficha(Color.BLANCO));

		/*
		 * Negras
		 */

		// Primera Fila
		this.setFicha("B", 8, new Ficha(Color.NEGRO));
		this.setFicha("D", 8, new Ficha(Color.NEGRO));
		this.setFicha("F", 8, new Ficha(Color.NEGRO));
		this.setFicha("H", 8, new Ficha(Color.NEGRO));

		// Segunda Fila
		this.setFicha("A", 7, new Ficha(Color.NEGRO));
		this.setFicha("C", 7, new Ficha(Color.NEGRO));
		this.setFicha("E", 7, new Ficha(Color.NEGRO));
		this.setFicha("G", 7, new Ficha(Color.NEGRO));

		// Tercera Fila
		this.setFicha("B", 6, new Ficha(Color.NEGRO));
		this.setFicha("D", 6, new Ficha(Color.NEGRO));
		this.setFicha("F", 6, new Ficha(Color.NEGRO));
		this.setFicha("H", 6, new Ficha(Color.NEGRO));

		// numero fichas en juego
		negras = 12;
		blancas = 12;

	}

	// Elimina una ficha de un campo
	private void vaciarCampo(String letter, int number) {
		int[] pos = this.parsePositions(letter, number);
		this.tablero[pos[1]][pos[0]].vaciar();
	}

	// Poner una ficha en un campo en el tablero
	private void setFicha(String letter, int number, Ficha ficha) {
		int[] pos = this.parsePositions(letter, number);
		this.tablero[pos[1]][pos[0]].setFicha(ficha);
	}

	// obtener una ficha en un campo del tablero
	protected Ficha getFicha(String letter, int number) {
		int[] pos = this.parsePositions(letter, number);
		return this.tablero[pos[1]][pos[0]].getFicha();
	}

	// Existe una ficha en un campo del tablero?
	protected boolean hasFicha(String letter, int number) {
		int[] pos = this.parsePositions(letter, number);
		return this.tablero[pos[1]][pos[0]].hasFicha();
	}

	// Interpreta las posiciones de ajedrez en coordenadas reales de una matriz multidimencional
	private int[] parsePositions(String letter, int number) {
		letter = letter.toUpperCase();
		String[][] letters = { { "A", "0" }, { "B", "1" }, { "C", "2" }, { "D", "3" }, { "E", "4" }, { "F", "5" }, { "G", "6" }, { "H", "7" } };

		for (String[] replacement : letters)
			letter = letter.replace(replacement[0], replacement[1]);

		number = (number - 8) * -1;
		int[] ret = { Integer.parseInt(letter), number };

		return ret;

	}

	// Ejecuta un movimiento, retorna los eventos desencadenados
	protected Eventos moverFicha(String letter, int number, String letterTo, int numberTo) {

		Eventos evn = Eventos.ERROR;

		// Validacion parcial de los movimientos
		if (!this.isValidMovement(letter, number, letterTo, numberTo))
			return Eventos.ERROR;

		// Ficha a mover
		Ficha ficha = this.getFicha(letter, number);

		// Si es reina evaluar movimientos tanto para blanca como para negra
		if (ficha.isReina()) {
			evn = move(Color.BLANCO, letter, number, letterTo, numberTo);
			if (evn == Eventos.ERROR)
				evn = move(Color.NEGRO, letter, number, letterTo, numberTo);
		} else {
			// Si no, moverse segun su color
			evn = move(ficha.getColor(), letter, number, letterTo, numberTo);
		}

		return evn;
	}

	// mover una ficha blanca o negra
	private Eventos move(Color color, String letter, int number, String letterTo, int numberTo) {

		// Ficha a mover
		Ficha ficha = this.getFicha(letter, number);
		Eventos evn = Eventos.ERROR;

		int iModifier = (color == Color.BLANCO) ? 1 : -1;

		// Mover en diagonal
		if (numberTo == number + (1 * iModifier)) {
			this.vaciarCampo(letter, number);
			this.setFicha(letterTo, numberTo, ficha);
			evn = Eventos.MOVIO;
		}

		// Comer diagonal
		if (numberTo == number + (2 * iModifier)) {
			// Obtener la ficha a comer
			char cLetter = (char) this.getLetterInTheMiddle(letter, letterTo);
			int iNumber = this.getNumberInTheMiddle(number, numberTo);

			// Si hay una ficha a comer y es del bando contrario
			if (this.hasFicha("" + cLetter, iNumber) && this.getFicha("" + cLetter, iNumber).getColor() != ficha.getColor()) {
				this.vaciarCampo("" + cLetter, iNumber);
				this.vaciarCampo(letter, number);
				this.setFicha(letterTo, numberTo, ficha);

				// Disminuir la cantidad de fichas del oponente en el tablero
				if (color == Color.BLANCO)
					negras--;
				else
					blancas--;

				// Decensadenar evento comio
				evn = Eventos.COMIO;
			} else {
				evn = Eventos.ERROR;
			}
		}

		// Inicia comprovaciones en caso de llegar a reina o ganar el juego
		if (evn == Eventos.ERROR)
			return evn;

		// ficha movida
		ficha = this.getFicha(letterTo, numberTo);

		// No es reina?
		if (!ficha.isReina()) {
			// Llego al final del tablero para ser una reina?
			if (ficha.getColor() == Color.BLANCO && numberTo == 8) {
				ficha.setReina();
				this.setFicha(letterTo, numberTo, ficha);
				evn = Eventos.REINA;
			} else if (ficha.getColor() == Color.NEGRO && numberTo == 1) {
				ficha.setReina();
				this.setFicha(letterTo, numberTo, ficha);
				evn = Eventos.REINA;
			}
		}

		// Ganador del juego
		if (negras == 0 || blancas == 0)
			evn = Eventos.GANO;

		return evn;
	}

	// Obtiene el numero campo en medio si un jugador intenta comer una ficha
	private int getNumberInTheMiddle(int number, int numberTo) {
		if (number < numberTo)
			return numberTo - 1;
		else
			return numberTo + 1;
	}

	// Obtiene la letra del campo en medio si un jugador intenta comer una ficha
	private int getLetterInTheMiddle(String letter, String letterTo) {
		char cLetter = letter.charAt(0);
		char cLetterTo = letterTo.charAt(0);

		if (cLetter < cLetterTo)
			return cLetterTo - 1;
		else
			return cLetterTo + 1;
	}

	// Comprovacion basica de movimiento
	private boolean isValidMovement(String letter, int number, String letterTo, int numberTo) {

		// Sean coordenadas validas
		if (!isLetterValid(letter) || !isLetterValid(letterTo) || !isNumberValid(number) || !isNumberValid(numberTo))
			return false;

		// Tiene que mover una ficha
		if (!this.hasFicha(letter, number))
			return false;

		// Debe ir a un campo vacio
		if (this.hasFicha(letterTo, numberTo))
			return false;

		return true;
	}

	// Es una letra en el rango de letras?
	private boolean isLetterValid(String letter) {
		letter = letter.toUpperCase();
		String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H" };
		return inArray(letters, letter);
	}

	// Es un numero en el rango de numeros?
	private boolean isNumberValid(int number) {
		return (number >= 1 && number <= 8);
	}

	// PHP Equivalente: http://www.php.net/manual/es/function.in-array.php
	private boolean inArray(String[] haystack, String needle) {
		for (int i = 0; i < haystack.length; i++) {
			if (haystack[i].toString().equals(needle)) {
				return true;
			}
		}
		return false;
	}

	// Retorna el tablero actual
	public Campo[][] getTablero() {
		return tablero;
	}

}