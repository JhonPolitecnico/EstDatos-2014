package main;

import lista.Lista;

public class Vuelo {

	private String ID;
	private String horaSalida;
	private String aerolinea;
	private String destino;

	private Lista pasajeros = new Lista();

	public Vuelo(String iD, String horaSalida, String aerolinea, String destino) {
		super();
		ID = iD;
		this.horaSalida = horaSalida;
		this.aerolinea = aerolinea;
		this.destino = destino;
	}

	public boolean hasReserva(int noReserva) {
		Pasajero p = null;
		for (int i = 0; i < this.pasajeros.getLength(); i++) {
			p = (Pasajero) this.pasajeros.getItem(i);
			if (p.getNoReserva() == noReserva) {
				return true;
			}
		}
		return false;
	}

	public void agregarPasajero(Pasajero pasajero) {
		this.pasajeros.addItem(pasajero);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

}
