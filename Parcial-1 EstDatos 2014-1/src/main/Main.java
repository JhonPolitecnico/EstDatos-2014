package main;

import java.util.Date;

import lista.Lista;

public class Main {

	public static void main(String[] args) {
		Admin admin = new Admin();

		admin.registrarPista(new Pista("Pista 1", 0, true, true, new Date(), new Date()));
		admin.registrarPista(new Pista("Pista 2", 1, true, true, new Date(), new Date()));
		admin.registrarPista(new Pista("Pista 3", 2, true, true, new Date(), new Date()));
		admin.registrarPista(new Pista("Pista 4", 3, true, true, new Date(), new Date()));

		admin.registrarVuelo(new Vuelo("123", "3", "copa", "Bogota"), 0);
		admin.registrarVuelo(new Vuelo("456", "3", "copa", "Bogota"), 0);
		admin.registrarVuelo(new Vuelo("789", "3", "copa", "Bogota"), 0);
		admin.registrarVuelo(new Vuelo("012", "3", "copa", "Bogota"), 0);

		admin.registrarPasajero(new Pasajero("Juan", 1234, 34, 68549), "789");

		System.out.println("Programacion de vuelos:");

		for (int j = 0; j < 4; j++) {

			Lista vuelos = admin.consultarProgramacion(j);
			System.out.println("Pista No: " + j);

			Vuelo v = null;
			for (int i = 0; i < vuelos.getLength(); i++) {
				v = (Vuelo) vuelos.getItem(i);
				System.out.println("\t" + v.getID() + ":" + v.getHoraSalida() + ":" + v.getAerolinea() + ":" + v.getDestino());
			}
		}

		System.out.println("\nVuelo del pasajero juan, segun su numero de reserva: 68549");
		Vuelo v = admin.consultarVueloPasajero(68549);
		System.out.println("\t" + v.getID() + ":" + v.getHoraSalida() + ":" + v.getAerolinea() + ":" + v.getDestino());
	}
}
