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

		usuarios.enqueue(new User("Jhon", ticket.getTicket()));
		usuarios.enqueue(new User("Jairo", ticket.getTicket()));
		usuarios.enqueue(new User("Juan", ticket.getTicket()));

		usuarios.enqueue(new User("Jorge", ticket.getTicket()));
		usuarios.enqueue(new User("Jesus", ticket.getTicket()));
		usuarios.enqueue(new User("Johnatan", ticket.getTicket()));

		usuarios.enqueue(new User("Freddy", ticket.getTicket()));
		usuarios.enqueue(new User("Fred", ticket.getTicket()));
		usuarios.enqueue(new User("Carlos", ticket.getTicket()));

		usuarios.enqueue(new User("Pedro", ticket.getTicket()));
		usuarios.enqueue(new User("Alejandro", ticket.getTicket()));
		usuarios.enqueue(new User("Francisco", ticket.getTicket()));

		usuarios.enqueue(new User("Daniel", ticket.getTicket()));
		usuarios.enqueue(new User("Jordan", ticket.getTicket()));
		usuarios.enqueue(new User("Samuel", ticket.getTicket()));

		// add 3 users per ATM
		for (int i = 0; i < cajeros.getLength(); i++) {
			Cajero cajero = (Cajero) cajeros.getItem(i);
			for (int j = 1; j <= 3; j++) {
				cajero.addForm((User) usuarios.dequeue());
			}

		}

		// dispatch users
		for (int i = 0; i < cajeros.getLength(); i++) {
			System.out.println("Se procesaron los siguientes formularios en el cajero " + i + " ==>");
			System.out.println(cajeros.getItem(i).toString());
		}

	}
}
