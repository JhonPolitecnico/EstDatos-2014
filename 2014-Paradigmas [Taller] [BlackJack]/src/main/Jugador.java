package main;

import java.util.ArrayList;

public class Jugador implements Cloneable {
	private String nombre;
	private ArrayList<Carta> cartas = new ArrayList<Carta>();
	private Eventos estado;

	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
	}

	// No modificar al jugador ni al croupier desde la UI
	public Jugador clone() {
		Jugador obj = null;
		try {
			obj = (Jugador) super.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex.getMessage());
		}
		return obj;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Eventos getEstado() {
		return estado;
	}

	public void setEstado(Eventos estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void addCarta(Carta carta) {
		this.cartas.add(carta);
	}

}