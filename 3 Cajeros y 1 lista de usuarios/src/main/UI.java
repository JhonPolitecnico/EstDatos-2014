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

			Lista cajeros = new Lista();
			Cola usuarios = new Cola();
			Ticket ticket = new Ticket();
			Cajero cajero = null;
			User user;
			Pila pila;

			try {
				System.out.println("Estructuras de Datos 2014-1");
				System.out.println("Jhon Jairo Eslava 1310012946\n");

				System.out.println("3 Cajeros y 1 lista de usuarios\n");

				do {

					this.printMenu();

					int action = in.nextInt();

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

					// Serve User
					case 3:
						System.out.println("Seleccione el número del cajero que atender\u00E1 a este usuario");

						cajero = (Cajero) cajeros.getItem(in.nextInt());

						if (cajero != null) {
							user = (User) usuarios.dequeue();
							if (user != null)
								cajero.addForm(user);
							else
								System.out.println("No hay usuarios en cola :c");
						} else
							System.out.println("El cajero elegido no existe :c");

						break;

					// dispatch users
					case 4:
						for (int i = 0; i < cajeros.getLength(); i++) {
							System.out.println("Se procesaron los siguientes formularios en el cajero " + i + " ==>");

							pila = ((Cajero) cajeros.getItem(i)).getPila();

							while ((user = (User) pila.pop()) != null) {
								System.out.println("Ticket: " + user.getTicket() + " Name: " + user.getName() + "\n");
							}

						}
						break;

					// Exit
					case 5:
						this.exit();
						break;

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
		System.out.println("Menu:");
		System.out.println("\t1. Agregar Cajero");
		System.out.println("\t2. Agregar Usuario");
		System.out.println("\t3. Atender usuario");
		System.out.println("\t4. Imprimir pila de cajeros / Procesar formularios");
		System.out.println("\t5. Cerrar Banco");
	}

	// Exit Application
	private void exit() {
		System.out.println("Bye!");
		System.exit(0);
	}
}