package main;

import pila.Pila;

public class Cajero {

	Pila pila = new Pila();

	public void addForm(Form form) {
		this.pila.push(form);
	}

	@Override
	public String toString() {
		Form form;
		String ret = "";
		while ((form = (Form) pila.pop()) != null) {
			ret += "Ticket: " + form.getTicket() + " Name: "
					+ form.getUser().getName() + "\n";
		}
		return ret;
	}
}
