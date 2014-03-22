package main;

import java.util.ArrayList;

public class Main {

	static ArrayList<Sala> salas = new ArrayList<Sala>();

	public static void main(String[] args) {

		salas.add(new Sala(new Hora(8, 0, 0), new Hora(12, 0, 0)));
		salas.add(new Sala(new Hora(12, 1, 0), new Hora(16, 0, 0)));
		salas.add(new Sala(new Hora(16, 1, 0), new Hora(20, 0, 0)));

		AgregarPelicula(new Pelicula("Viernes 13", new Hora(18, 0, 0), new Hora(20, 0, 0)));
	}

	public static void AgregarPelicula(Pelicula peli) {
		for (Sala sala : salas) {
			for (Pelicula sPeli : sala.getPeliculas()) {
				if (sPeli.getHoraInicio().mayorQue(peli.getHoraInicio()) && sPeli.getHoraFin().mayorQue(peli.getHoraFin()))
					return;

			}
		}
	}

}
