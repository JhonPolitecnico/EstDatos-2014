package main;

import pila.Pila;

public class Cajero {

	Pila pila = new Pila();

	public void addForm(User user) {
		this.pila.push(user);
	}

	@Override
	public String toString() {
		User user;
		String ret = "";
		while ((user = (User) pila.pop()) != null) {
			ret += "Ticket: " + user.getTicket() + " Name: " + user.getName()
					+ "\n";
		}
		return ret;
	}
}
