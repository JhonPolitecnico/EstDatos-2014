package main;

public class Carta {

	private Palo palo;
	private Nombre nombre;

	public Carta(Palo palo, Nombre nombre) {
		this.palo = palo;
		this.nombre = nombre;
	}

	public Palo getPalo() {
		return palo;
	}

	public Nombre getNombre() {
		return nombre;
	}

}