package main;

import java.util.*;

public class UI {
	private Scanner in;
	private ArrayList<Sala> salas = new ArrayList<Sala>();

	public void start() {
		try {

			in = new Scanner(System.in);
			int action = 0;

			try {
				System.out.println("Paradigmas de Programaci\u00F3n 2014-1");
				System.out.println("Jhon Jairo Eslava 1310012946\n");

				System.out.println("Cine\n");

				do {

					this.printMenu();

					// Get action
					if (in.hasNextInt())
						action = in.nextInt();
					else {
						action = 0;
						in.next();
					}

					// New line
					System.out.println();

					switch (action) {

					// Add theater
					case 1:
						salas.add(new Sala(new Hora(8, 0, 0), new Hora(12, 0, 0)));
						break;

					// Add movie
					case 2:
						AgregarPelicula(2, new Pelicula("Viernes 13", new Hora(18, 0, 0), new Hora(20, 0, 0)));
						break;

					// Buy ticket
					case 3:
						break;

					// List theaters
					case 4:
						break;

					// Exit
					case 5:
						System.out.println("Bye!");
						System.exit(0);
						break;

					// Invalid option
					default:
						System.out.println("No selecciono una opci\u00F3n valida");
						break;

					}

				} while (true);

			} catch (Exception e) {
				System.out.println("\nOpps, ocurrio un error :!");
				System.out.println("Error: " + e.getMessage());
				System.out.println("Bye!");
			}
		} finally {
			in.close();
		}

	}

	private void printMenu() {
		System.out.println("\nMenu:");
		System.out.println("\t1. Agregar Sala");
		System.out.println("\t2. Agregar Pelicula");
		System.out.println("\t3. Comprar Voleta");
		System.out.println("\t4. Listar salas");
		System.out.println("\t5. Cerrar Cine");
	}

	public boolean AgregarPelicula(int noSala, Pelicula peli) {
		Sala sala = salas.get(noSala);

		// Si la película esta en el horario de la sala de cine
		if ((peli.getHoraInicio().mayorQue(sala.getHoraInicio()) || peli.getHoraInicio().igualQue(sala.getHoraInicio()))
				&& (peli.getHoraFin().menorQue(sala.getHoraFin()) || peli.getHoraFin().igualQue(sala.getHoraFin()))) {

			if (sala.getPeliculas().size() == 0) {
				sala.getPeliculas().add(peli);
				return true;
			}

			for (Pelicula sPeli : sala.getPeliculas()) {

				// Caso 1, Nueva peli luego de la peli antigua || Caso 2, Nueva peli antes de la peli antigua
				if (!peli.getHoraInicio().mayorQue(sPeli.getHoraFin()) || !peli.getHoraFin().menorQue(sPeli.getHoraInicio()))
					return false;

			}

			return true;
		}

		return false;
	}
}