package main;

import java.util.*;

import pila.Pila;
import lista.Lista;
import cola.Cola;

public class UI {
	private Scanner in;

	public void start() {
		try {

			in = new Scanner(System.in);
			int action = 0;

			Lista cajeros = new Lista();
			Cola usuarios = new Cola();
			Ticket ticket = new Ticket();
			Cajero cajero;
			User user;
			Pila pila;

			try {
				System.out.println("Estructuras de Datos 2014-1");
				System.out.println("Jhon Jairo Eslava 1310012946\n");

				System.out.println("3 Cajeros y 1 lista de usuarios\n");

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

					// Add ATM
					case 1:
						cajeros.addItem(new Cajero());
						System.out.println("Cajero agregado!");
						break;

					// Add User
					case 2:
						System.out.println("Ingrese el nombre del usuario:");
						usuarios.enqueue(new User(in.next(), ticket.getTicket()));
						System.out.println("Usuario agregado!");
						break;

					// Serve user
					case 3:
						System.out.println("Seleccione el n\u00FAmero del cajero que atender\u00E1 a este usuario");

						// Get ATM number
						if (in.hasNextInt())
							cajero = (Cajero) cajeros.getItem(in.nextInt());
						else {
							System.out.println("El n\u00FAmero del cajero es invalido");
							in.next();
							break;
						}

						// check if a ATM exists
						if (cajero != null) {
							// Get user
							user = (User) usuarios.dequeue();

							// check if a user exists
							if (user != null) {
								// Serve user
								cajero.addForm(user);
								System.out.println("Usuario atendido!");
							} else
								System.out.println("No hay usuarios en cola :c");
						} else
							System.out.println("El cajero elegido no existe :c");

						break;

					// Dispatch users
					case 4:
						if (cajeros.getLength() == 0) {
							System.out.println("No hay cajeros");
						} else {
							for (int i = 0; i < cajeros.getLength(); i++) {
								System.out.println("Se procesaron los siguientes formularios en el cajero " + i + " ==>");

								pila = ((Cajero) cajeros.getItem(i)).getPila();

								while ((user = (User) pila.pop()) != null) {
									System.out.println("\tTicket: " + user.getTicket() + " Nombre: " + user.getName());
								}

							}
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

	private void printMenu() {
		System.out.println("\nMenu:");
		System.out.println("\t1. Agregar Cajero");
		System.out.println("\t2. Agregar Usuario");
		System.out.println("\t3. Atender usuario");
		System.out.println("\t4. Imprimir pila de cajeros / Procesar formularios");
		System.out.println("\t5. Cerrar Banco");
	}
}