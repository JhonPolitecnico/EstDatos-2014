package ui.console;

import java.util.Scanner;

import kernel.console.Action;
import kernel.console.ConsoleUI;

/**
 * Arbol binario
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
public class Altura extends Action {

	public Altura(ConsoleUI UI) {
		super(UI);
	}

	@Override
	public String name() {
		return "altura";
	}

	@Override
	public void execute(Scanner scanner) {
		System.out.println("La altura del arbol es: " + ((UI) this.UI).getArbol().getHigh());
	}

}
