package main;

import cola.Cola;
import lista.Lista;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lista cajeros = new Lista();
		Cola usuarios = new Cola();
		Ticket ticket = new Ticket();

		cajeros.addItem(new Cajero());
		cajeros.addItem(new Cajero());
		cajeros.addItem(new Cajero());
		cajeros.addItem(new Cajero());
		cajeros.addItem(new Cajero());

		usuarios.enqueue(new User("Jhon"));
		usuarios.enqueue(new User("Jairo"));
		usuarios.enqueue(new User("Juan"));

		usuarios.enqueue(new User("Jorge"));
		usuarios.enqueue(new User("Jesus"));
		usuarios.enqueue(new User("Johnatan"));

		usuarios.enqueue(new User("Freddy"));
		usuarios.enqueue(new User("Fred"));
		usuarios.enqueue(new User("Carlos"));

		usuarios.enqueue(new User("Pedro"));
		usuarios.enqueue(new User("Alejandro"));
		usuarios.enqueue(new User("Francisco"));

		usuarios.enqueue(new User("Daniel"));
		usuarios.enqueue(new User("Jordan"));
		usuarios.enqueue(new User("Samuel"));

		// add 3 users per ATM
		for (int i = 0; i < cajeros.getLength(); i++) {
			Cajero cajero = (Cajero) cajeros.getItem(i);
			for (int j = 1; j <= 3; j++) {
				cajero.addForm(new Form((User) usuarios.dequeue(),
						ticket.getTicket()));
			}

		}

		for (int i = 0; i < cajeros.getLength(); i++) {
			System.out.println("Usuarios en el cajero " + i + " ==>");
			System.out.println(cajeros.getItem(i).toString());
		}

	}
}
