package main;

import lista.Lista;

public class Admin {

	private Lista pistas = new Lista();

	public void registrarPista(Pista pista) {
		this.pistas.addItem(pista);
	}

	public void registrarVuelo(Vuelo vuelo, int noPista) {
		Pista p = null;
		for (int i = 0; i < this.pistas.getLength(); i++) {
			p = (Pista) this.pistas.getItem(i);
			if (p.getNo() == noPista) {
				p.agregarVuelo(vuelo);
				break;
			}
		}
	}

	public void registrarPasajero(Pasajero pasajero, String ID) {
		Pista p = null;
		for (int i = 0; i < this.pistas.getLength(); i++) {
			p = (Pista) this.pistas.getItem(i);
			if (p.hasVuelo(ID)) {
				p.getVuelo(ID).agregarPasajero(pasajero);
				break;
			}
		}
	}

	public Pista consultarPistaDeVuelo(int ID) {
		Pista p = null;
		for (int i = 0; i < this.pistas.getLength(); i++) {
			p = (Pista) this.pistas.getItem(i);
			if (p.getNo() == ID) {
				return p;
			}
		}
		return null;
	}

	public Lista consultarProgramacion(int noPista) {
		Pista p = this.consultarPistaDeVuelo(noPista);

		if (p != null)
			return p.getVuelos();

		return null;

	}

	public Vuelo consultarVueloPasajero(int noReserva) {
		Lista vuelos = null;
		Pista p = null;
		for (int i = 0; i < this.pistas.getLength(); i++) {
			p = (Pista) this.pistas.getItem(i);

			vuelos = p.getVuelos();
			Vuelo v = null;
			for (int j = 0; j < vuelos.getLength(); j++) {
				v = (Vuelo) vuelos.getItem(j);
				if (v.hasReserva(noReserva)) {
					return v;
				}
			}

		}

		return null;
	}

}
