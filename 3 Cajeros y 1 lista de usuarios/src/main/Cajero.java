package main;

import pila.Pila;

public class Cajero {

	Pila pila = new Pila();

	public void addForm(User user) {
		this.pila.push(user);
	}

	public Pila getPila() {
		return this.pila;
	}

}
