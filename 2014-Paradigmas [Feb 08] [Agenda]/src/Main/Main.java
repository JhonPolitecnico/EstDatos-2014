package Main;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sIn = new Scanner(System.in);
		Agenda agenda = new Agenda();

		do {

			System.out.println("\nMenu de la Agenda");
			System.out.println("1. Agregar Persona");
			System.out.println("2. Listar Personas");
			System.out.println("3. Salir");
			try {

				int action = sIn.nextInt();

				// exit
				if (action == 3) {
					System.out.println("Bye!");
					break;
				}

				System.out.println();

				switch (action) {
				case 1:
					System.out.println("Agregue los datos pertinentes a continuación\n");
					System.out.println("Nombre:");
					String nombre = sIn.next();
					System.out.println("DNI:");
					int dni = sIn.nextInt();
					agenda.addPersona(nombre, dni);
					break;

				case 2:
					if (!agenda.hasPersonas()) {
						System.out.println("No hay personas en la agenda");
						continue;
					}

					System.out.println("Listado de personas en su agenda:\n");
					for (Persona persona : agenda.getPersonas()) {
						System.out.println("\tNombre:\t" + persona.getNombre());
						System.out.println("\tDNI:\t" + persona.getDni());
						System.out.println();
					}
					break;

				default:
					System.out.println("No selecciono una opción valida");
					break;

				}
			} catch (Exception e) {
				System.out.println("\nOpps, ocurreio un error :!");
				System.out.println("Error: " + e.getMessage());
				System.out.println("Bye!");
				break;
			}

		} while (true);

		sIn.close();

	}
}
