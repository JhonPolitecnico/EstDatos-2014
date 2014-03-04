package main;

import pila.Pila;

public class Main {

	public static void main(String[] args) {
		Pila pila = new Pila();
		pila.push("Aqui");
		pila.push(" ");
		pila.push("Estamos");
		pila.push(" ");
		pila.push("Hola");

		String str;
		while ((str = (String) pila.pop()) != null) {
			System.out.print(str);
		}
	}
}
