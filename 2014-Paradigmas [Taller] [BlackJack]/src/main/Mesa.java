package main;

import java.util.ArrayList;

public class Mesa {

	private ArrayList<Carta> maso;

	/**
	 * Se crea nun tablero cuando se crea una nueva partida
	 */
	public Mesa() {

		/**
		 * Establesco las cartas del maso
		 */
		maso = new ArrayList<Carta>();
		for (Palo palo : Palo.values()) {
			for (Nombre nombre : Nombre.values()) {
				maso.add(new Carta(palo, nombre));
			}
		}
	}

	protected Carta getCartaFromMaso() {
		Carta carta = maso.get(randomNumber(0, maso.size() - 1));

		// Borrar carta del maso
		if (maso.contains(carta))
			maso.remove(carta);

		// Retornar carta
		return carta;
	}

	private int randomNumber(int Min, int Max) {
		return Min + (int) (Math.random() * ((Max - Min) + 1));
	}

}