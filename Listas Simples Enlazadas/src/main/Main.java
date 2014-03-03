package main;

import lista.Lista;

public class Main {

	public static void main(String[] args) {
		Lista lista = new Lista();

		// Test!!!

		// Initial content
		lista.addItem("Grancolombiano");
		lista.addItem("Politecnico");
		lista.addItem("del");
		lista.addItem("los"); // Middle
		lista.addItem("nosotros");
		lista.addItem("somos");
		lista.addItem("Hola");

		// Insert copyright :D

		// Insert content in 0 index
		lista.addItem(0, "Powered");

		lista.addItem(1, "By");
		lista.addItem(2, "Jhon");
		lista.addItem(3, "Jairo");
		lista.addItem(4, "Eslava");
		lista.addItem(5, "==>");

		// Add spaces
		for (int i = 1; i < lista.getLength(); i += 2) {
			lista.addItem(i, " ");
		}

		// Wrap the phrase with [] characters
		lista.addItem("["); // Insert into the last position
		lista.addItem(0, "]"); // Insert into the first position

		// exchange ] to [
		lista.exchangeItems(0, lista.getLength() - 1);

		// exchange phrase
		int lastWord = lista.getLength() - 2; // "Hola"
		int ratio = lastWord - 6 - 6; // 6 Words, 6 Spaces
		int firstWord = lastWord - 2 - 2; // "nosotros"; 2 Words, 2 Spaces

		for (int i = lastWord; i >= firstWord; i -= 2) {
			lista.exchangeItems(i, ratio + (lastWord - i));
		}

		// Add trash
		int length = lista.getLength() * 2;
		for (int i = 0; i < length; i += 2) {
			lista.addItem(i, "*");
		}

		// Remove trash
		for (int i = 0; i < lista.getLength(); i++) {
			lista.removeItem(i);
		}

		// Print content
		for (int i = 0; i < lista.getLength(); i++) {
			System.out.print(lista.getItem(i));
		}

	}
}
