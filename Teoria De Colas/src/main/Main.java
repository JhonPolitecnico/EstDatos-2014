package main;

import cola.Cola;

public class Main {

	public static void main(String[] args) {
		Cola cola = new Cola();
		cola.enqueue("soy el 1ro");
		cola.enqueue("soy el 2do");
		cola.enqueue("soy el 3ro");
		cola.enqueue("soy el 4to");
		cola.enqueue("soy el 5to");
		cola.enqueue("soy el 6to");

		String str;
		while ((str = (String) cola.dequeue()) != null) {
			System.out.println(str);
		}
	}
}
