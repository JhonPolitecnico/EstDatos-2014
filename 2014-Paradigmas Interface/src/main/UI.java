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
						salas.add(new Sala(new Hora(8, 0, 0), new Hora(20, 0, 0), 5, 20));
						break;

					// Add movie
					case 2:
						boolean ret = AgregarPelicula(0, new Pelicula("Viernes 13", new Hora(18, 0, 0), new Hora(20, 0, 0)));

						if (ret)
							System.out.println("La pelicula se agrego!");
						else
							System.out.println("la pelicula no puede agregarse :c");
						break;

					// Buy ticket
					case 3:
						break;

					// List theaters
					case 4:
						int i = 0;
						for (Sala sala : salas) {
							System.out.println("Sala No: " + i);
							System.out.println("\tHorario:  " + this.horarioToString(sala.getHoraInicio()) + " - " + this.horarioToString(sala.getHoraFin()));
							System.out.println();
							System.out.println("\tEstas son las peliculas:");
							for (Pelicula peli : sala.getPeliculas()) {
								System.out.println("\t\tPelicula: " + peli.getNombre());
								System.out.println("\t\tHorario:  " + this.horarioToString(peli.getHoraInicio()) + " - " + this.horarioToString(peli.getHoraFin()));
								System.out.println("\t\tSillas:   ");
								System.out.println("\t\t\t   " + printToNum(peli.getSillas()[0].length));
								for (int j = 0; j < peli.getSillas().length; j++) {
									System.out.print("\t\t\t" + this.numToLetter(j) + " ");
									for (int j2 = 0; j2 < peli.getSillas()[0].length; j2++) {
										System.out.print("  " + this.estadoSilla(peli.getSillas()[j][j2]));
									}
									System.out.println();
								}
							}
							i++;
						}
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

	private String estadoSilla(int silla) {
		return (silla == 0) ? "V" : "O";
	}

	private String espaciosIzquierda(int num) {
		// 0 - 9
		if (num / 10 == 0) {
			return " ";
			// 10 - 100
		} else if (num / 100 == 0) {
			return "  ";
		}

		return "";
	}

	private String printToNum(int num) {
		String ret = "";
		for (int i = 0; i < num; i++) {
			ret += (i > 9) ? i + " " : " " + i + " ";
		}
		return ret;
	}

	private String numToLetter(int num) {
		return String.valueOf(((char) (65 + num)));
	}

	private String horarioToString(Hora hora) {
		return hora.getHora() + ":" + hora.getMinuto() + ":" + hora.getSegundo();
	}

	private String fechaToString(Fecha fecha) {
		return fecha.getAño() + ":" + fecha.getMes() + ":" + fecha.getDia();
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
		if (noSala > salas.size() - 1)
			return false;

		Sala sala = salas.get(noSala);
		return sala.AgregarPelicula(peli);
	}
}